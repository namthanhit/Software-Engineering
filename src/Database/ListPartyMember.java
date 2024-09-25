package Database;

import Class.PartyMember;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class ListPartyMember {

    // Phương thức lấy danh sách PartyMember từ CSDL
    public static List<PartyMember> getAllPartyMembers() {
        List<PartyMember> partyMembers = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/PartyManagement"; // URL cơ sở dữ liệu
        String user = "root"; // Username MySQL
        String password = "08012004"; // Password MySQL

        // Câu lệnh SQL để lấy dữ liệu từ bảng PartyMember
        String sql = "SELECT id, fullName, birthDate, joinDate, address, email, phoneNumber, status, avatar FROM PartyMember";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Lặp qua các hàng dữ liệu trong ResultSet
            while (rs.next()) {
                String id = rs.getString("id");
                String fullName = rs.getString("fullName");
                Date birthDate = rs.getDate("birthDate");
                Date joinDate = rs.getDate("joinDate");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                String status = rs.getString("status");
                byte[] avatarBytes = rs.getBytes("avatar");

                // Chuyển byte[] avatar thành Icon (ImageIcon)
                ImageIcon avatar = null;
                if (avatarBytes != null) {
                    avatar = new ImageIcon(avatarBytes);
                }

                // Tạo một đối tượng PartyMember và thêm vào danh sách
                PartyMember partyMember = new PartyMember(avatar, id, fullName, birthDate, joinDate, address, email, phoneNumber, status);
                partyMembers.add(partyMember);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Bắt lỗi SQL
        }
        return partyMembers;
    }
    
    
    
}
