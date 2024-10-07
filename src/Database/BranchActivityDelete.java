/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author buingocduc
 */
public class BranchActivityDelete {
    private static DatabaseConfig dbconfig = new DatabaseConfig();

    public void deleteBranchActivity(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());

            // 2. Tạo câu lệnh SQL DELETE
            String sql = "DELETE FROM BranchActivity WHERE id = ?";

            // 3. Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            // 4. Thực thi câu lệnh
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Xoá hoạt động thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy hoạt động với ID: " + id);
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
