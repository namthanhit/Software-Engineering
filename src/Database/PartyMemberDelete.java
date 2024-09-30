/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author Thanh Nam
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PartyMemberDelete {

    // Thông tin cơ sở dữ liệu
    private final String DB_URL = "jdbc:mysql://localhost:3306/PartyManagement";
    private final String USER = "root";
    private final String PASS = "12345678";

    public void deletePartyMember(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 2. Tạo câu lệnh SQL DELETE
            String sql = "DELETE FROM PartyMember WHERE id = ?";

            // 3. Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            // 4. Thực thi câu lệnh
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Xóa thành công.");
            } else {
                System.out.println("Không tìm thấy thành viên với ID: " + id);
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

    public static void main(String[] args) {
        // Ví dụ sử dụng
        PartyMemberDelete dao = new PartyMemberDelete();
        dao.deletePartyMember("PM005");  // Thay "PM001" bằng ID bạn muốn xóa
    }
}
