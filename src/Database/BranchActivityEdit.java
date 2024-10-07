/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author buingocduc
 */
public class BranchActivityEdit {
    private static DatabaseConfig dbconfig = new DatabaseConfig();

    public void updateBranchActivity(String id, String activityName, String startDate, String endDate, 
                                     String description, String orgId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. Kết nối đến cơ sở dữ liệu
            conn = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());

            // 2. Tạo câu lệnh SQL UPDATE
            String sql = "UPDATE BranchActivity SET activityName = ?, startDate = ?, endDate = ?, description = ?, orgId = ? WHERE id = ?";

            // 3. Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, activityName);
            pstmt.setDate(2, java.sql.Date.valueOf(startDate)); // startDate dạng 'YYYY-MM-DD'
            pstmt.setDate(3, java.sql.Date.valueOf(endDate));   // endDate dạng 'YYYY-MM-DD'
            pstmt.setString(4, description);
            pstmt.setString(5, orgId);
            pstmt.setString(6, id);

            // 4. Thực thi câu lệnh
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật hoạt động chi nhánh thành công.");
            } else {
                System.out.println("Không tìm thấy hoạt động với ID: " + id);
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
