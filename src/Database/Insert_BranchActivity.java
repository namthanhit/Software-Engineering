/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author buingocduc
 */
public class Insert_BranchActivity {
    private static DatabaseConfig dbconfig = new DatabaseConfig();

    // Kiểm tra xem ID đã tồn tại hay chưa
    private boolean isIdExist(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
            String checkSql = "SELECT id FROM TransferOut WHERE id = ?";
            pstmt = conn.prepareStatement(checkSql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            return rs.next();  // Trả về true nếu ID đã tồn tại
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return false;
    }

        // Phương thức thêm bản ghi hoạt động chi nhánh
    public void addBranchActivityRecord(String id, String activityName, String startDate, String endDate, String status, String description, String orgId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            conn = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());

            // Tạo câu lệnh SQL INSERT
            String sql = "INSERT INTO BranchActivity (id, activityName, startDate, endDate, status, description, orgId) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";

            // Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, activityName);
            pstmt.setDate(3, java.sql.Date.valueOf(startDate));  // startDate dạng 'YYYY-MM-DD'
            pstmt.setDate(4, java.sql.Date.valueOf(endDate));    // endDate dạng 'YYYY-MM-DD'
            pstmt.setString(5, status);
            pstmt.setString(6, description);
            pstmt.setString(7, orgId);

            // Thực thi câu lệnh
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Thêm hoạt động thành công!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    
    
}
