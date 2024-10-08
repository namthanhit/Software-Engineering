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
public class Insert_OutGroup {
    private static DatabaseConfig dbconfig = new DatabaseConfig();
        // Phương thức kiểm tra xem ID đã tồn tại hay chưa
    private boolean isIdExist(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
            String checkSql = "SELECT id FROM EvalRequest WHERE id = ?";
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

    // Phương thức thêm bản ghi yêu cầu đánh giá
    public void addEvalRequestRecord(String partyMemberId, String orgId, String date, String status, String reason) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            conn = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());

            // Tạo câu lệnh SQL INSERT
            String sql = "INSERT INTO EvalRequest (id, partyMemberId, orgId, date, status, reason) " +
                         "VALUES (UUID(), ?, ?, ?, ?, ?)";

            // Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, partyMemberId);
            pstmt.setString(2, orgId);
            pstmt.setDate(3, java.sql.Date.valueOf(date));  // date dạng 'YYYY-MM-DD'
            pstmt.setString(4, status);
            pstmt.setString(5, reason);

            // Thực thi câu lệnh
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Thành công!");
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
