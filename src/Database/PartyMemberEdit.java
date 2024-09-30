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

public class PartyMemberEdit {

    // Thông tin cơ sở dữ liệu
    private final String DB_URL = "jdbc:mysql://localhost:3306/PartyManagement";
    private final String USER = "root";
    private final String PASS = "12345678";

    public void updatePartyMember(String id, String fullName, String birthDate, String joinDate, 
                                  String address, String email, String phoneNumber, 
                                  String position, String orgId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 2. Tạo câu lệnh SQL UPDATE
            String sql = "UPDATE PartyMember SET fullName = ?, birthDate = ?, joinDate = ?, address = ?, " +
                         "email = ?, phoneNumber = ?, position = ?, orgId = ? WHERE id = ?";

            // 3. Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fullName);
            pstmt.setDate(2, java.sql.Date.valueOf(birthDate)); // birthDate dạng 'YYYY-MM-DD'
            pstmt.setDate(3, java.sql.Date.valueOf(joinDate));  // joinDate dạng 'YYYY-MM-DD'
            pstmt.setString(4, address);
            pstmt.setString(5, email);
            pstmt.setString(6, phoneNumber);
            pstmt.setString(7, position);
            pstmt.setString(8, orgId);
            pstmt.setString(9, id);

            // 4. Thực thi câu lệnh
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật thành công.");
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
        PartyMemberEdit dao = new PartyMemberEdit();
        dao.updatePartyMember("PM004", "Hoàng Thị Thảo Nhi", "1985-05-15", "2022-08-01", 
                              "456 Đường XYZ", "nguyenvanb@example.com", "0987654321", "Yêu", "ORG02");
    }
}

