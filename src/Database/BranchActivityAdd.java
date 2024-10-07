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
public class BranchActivityAdd {
    private static DatabaseConfig dbconfig = new DatabaseConfig();

    // Kiểm tra xem ID đã tồn tại hay chưa
    private boolean isIdExist(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
            String checkSql = "SELECT id FROM BranchActivity WHERE id = ?";
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

    // Phương thức thêm hoạt động chi nhánh mới
    public void addBranchActivity(String id, String activityName, String startDate, String endDate, String description, String orgId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. Kiểm tra nếu ID đã tồn tại
            if (isIdExist(id)) {
                JOptionPane.showMessageDialog(null, "ID đã tồn tại, vui lòng nhập ID khác.");
                return;  // Dừng lại nếu ID đã tồn tại
            }

            // 2. Kết nối đến cơ sở dữ liệu
            conn = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());

            // 3. Tạo câu lệnh SQL INSERT
            String sql = "INSERT INTO BranchActivity (id, activityName, startDate, endDate, description, orgId) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";

            // 4. Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, activityName);
            pstmt.setDate(3, java.sql.Date.valueOf(startDate)); // startDate dạng 'YYYY-MM-DD'
            pstmt.setDate(4, java.sql.Date.valueOf(endDate));   // endDate dạng 'YYYY-MM-DD'
            pstmt.setString(5, description);
            pstmt.setString(6, orgId);

            // 5. Thực thi câu lệnh
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Thêm hoạt động thành công!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. Đóng kết nối
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

}
