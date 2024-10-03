package Database;

import Class.PartyMember;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.sql.DriverManager;

public class ListPartyMember {
    private static DatabaseConfig dbconfig = new DatabaseConfig();
    
    public static List<PartyMember> getAllPartyMembers() {
        List<PartyMember> partyMembers = new ArrayList<>();
        String sql = "SELECT id, fullName, birthDate, joinDate, address, email, phoneNumber, position, avatar, orgId, detail FROM PartyMember";

        try (Connection conn = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
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
                String position = rs.getString("position");
                String orgId = rs.getString("orgId");
                byte[] avatarBytes = rs.getBytes("avatar");
                String detail = rs.getString("detail");
                // Chuyển byte[] avatar thành Icon (ImageIcon)
                ImageIcon avatar = null;
                if (avatarBytes != null) {
                    avatar = new ImageIcon(avatarBytes);
                }

                // Tạo một đối tượng PartyMember và thêm vào danh sách
                PartyMember partyMember = new PartyMember(avatar, id, fullName, birthDate, joinDate, address, email, phoneNumber, position, orgId, detail);
                partyMembers.add(partyMember);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Bắt lỗi SQL
        }
        return partyMembers;
    }
    
    public static String getMemberNameById(String memberId) {
        String fullName = null;
        // Câu lệnh SQL để lấy fullName từ bảng PartyMember theo id
        String sql = "SELECT fullName FROM PartyMember WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Đặt giá trị cho tham số id trong câu lệnh SQL
            stmt.setString(1, memberId);

            // Thực thi truy vấn và nhận kết quả
            try (ResultSet rs = stmt.executeQuery()) {
                // Nếu tồn tại kết quả, lấy fullName
                if (rs.next()) {
                    fullName = rs.getString("fullName");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Bắt lỗi SQL
        }
        return fullName;
    }

    
    
}
