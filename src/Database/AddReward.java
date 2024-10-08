package Database;

/**
 *
 * @author Thanh Nam
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AddReward {
    private static DatabaseConfig dbconfig = new DatabaseConfig();
    
    public class DatabaseConnection {

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
        }
    }
    
    // Hàm thêm thông tin vào bảng Reward
    public void addReward(String id, String partyMemberId, String orgId, String decisionMaker, String rewardDate, String description) {
        String query = "INSERT INTO Reward (id, partyMemberId, orgId, decisionMaker, rewardDate, description) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
             
            // Thiết lập các tham số cho câu lệnh INSERT
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, partyMemberId);
            preparedStatement.setString(3, orgId);
            preparedStatement.setString(4, decisionMaker);
            preparedStatement.setDate(5, java.sql.Date.valueOf(rewardDate));
            preparedStatement.setString(6, description);
            
            // Thực thi câu lệnh INSERT
            int rowsInserted = preparedStatement.executeUpdate();
            
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Thêm thông tin khen thưởng thành công!");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm thông tin khen thưởng: " + e.getMessage());
        }
    }
}
