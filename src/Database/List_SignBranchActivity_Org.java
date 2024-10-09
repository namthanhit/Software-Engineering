/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;


import Class.SignBranchActivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author buingocduc
 */
public class List_SignBranchActivity_Org {
    private static DatabaseConfig dbconfig = new DatabaseConfig();
    
    public static List<SignBranchActivity> getSignBranchActivity(String idBA) {
        List<SignBranchActivity> signBA = new ArrayList<>();
        String sql = "SELECT * FROM SignBranchActivity WHERE idActivity = ?";

        try (Connection connection = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, idBA);
            ResultSet resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return signBA;
    }
    
    public void updateSignBranchActivityStatus(String partyMemberId, String idActivity, String status) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());

            // 2. Tạo câu lệnh SQL UPDATE cho bảng SignBranchActivity
            String sql = "UPDATE SignBranchActivity SET status = ? WHERE partyMemberId = ? AND idActivity = ?";

            // 3. Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, status);            // Cập nhật status
            pstmt.setString(2, partyMemberId);     // Đặt điều kiện với partyMemberId
            pstmt.setString(3, idActivity);        // Đặt điều kiện với idActivity

            // 4. Thực thi câu lệnh
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật trạng thái thành công.");
            } else {
                System.out.println("Không tìm thấy bản ghi với partyMemberId: " + partyMemberId + " và idActivity: " + idActivity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Đóng kết nối
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    
}
