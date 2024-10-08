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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PartyMemberAdd {

    private static DatabaseConfig dbconfig = new DatabaseConfig();

    // Kiểm tra xem ID đã tồn tại hay chưa
    private boolean isIdExist(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
            String checkSql = "SELECT id FROM PartyMember WHERE id = ?";
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

    // Phương thức thêm thành viên mới
    public void addPartyMember(byte[] avatar, String id, String fullName, String birthDate, String joinDate, 
                               String address, String email, String phoneNumber, String position, String orgId, String detail) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. Kiểm tra nếu ID đã tồn tại
            if (isIdExist(id)) {
                JOptionPane.showMessageDialog(null, "ID đã tồn tại, vui lòng nhập ID khác.");
                return;  // Dừng lại nếu ID đã tồn tại
            }

            // 2. Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());

            // 3. Tạo câu lệnh SQL INSERT
            String sql = "INSERT INTO PartyMember (avatar, id, fullName, birthDate, joinDate, address, email, phoneNumber, position, orgId, detail) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // 4. Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setBytes(1, avatar);
            pstmt.setString(2, id);
            pstmt.setString(3, fullName);
            pstmt.setDate(4, java.sql.Date.valueOf(birthDate)); // birthDate dạng 'YYYY-MM-DD'
            pstmt.setDate(5, java.sql.Date.valueOf(joinDate));  // joinDate dạng 'YYYY-MM-DD'
            pstmt.setString(6, address);
            pstmt.setString(7, email);
            pstmt.setString(8, phoneNumber);
            pstmt.setString(9, position);
            pstmt.setString(10, orgId);
            pstmt.setString(11, detail);

            // 5. Thực thi câu lệnh
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Thêm thành công!");
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

    public static void main(String[] args) {
        // Ví dụ sử dụng
        PartyMemberAdd dao = new PartyMemberAdd();
        // Avatar: để null nếu không có
        dao.addPartyMember(null, "PM005", "Nguyen Van A", "1990-01-01", "2024-01-01", 
                           "123 Đường ABC", "nguyenvana@example.com", "0912345678", "Member", "ORG01", "2024 lam ctn");
    }
}
