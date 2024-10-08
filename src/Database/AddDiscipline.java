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

public class AddDiscipline {
    private static DatabaseConfig dbconfig = new DatabaseConfig();
    
    public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(),dbconfig.getPassword());
        }
    }
    
    public void addDiscipline(String id, String partyMemberId, String orgId, String decisionMaker, String disciplineDate, String description) {
        String query = "INSERT INTO Discipline (id, partyMemberId, orgId, decisionMaker, disciplineDate, description) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
             
            // Thiết lập các tham số cho câu lệnh INSERT
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, partyMemberId);
            preparedStatement.setString(3, orgId);
            preparedStatement.setString(4, decisionMaker);
            preparedStatement.setDate(5, java.sql.Date.valueOf(disciplineDate));
            preparedStatement.setString(6, description);
            
            // Thực thi câu lệnh INSERT
            int rowsInserted = preparedStatement.executeUpdate();
            
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Thêm thành công!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting discipline record: " + e.getMessage());
        }
    }
    
    
    public static void main(String[] args) {
        AddDiscipline disciplineDAO = new AddDiscipline();

        // Gọi hàm để thêm một bản ghi vào bảng Discipline
        disciplineDAO.addDiscipline("12", "PM004", "ORG01", "John Doe", "2024-10-07", "Vi phạm kỷ luật nghiêm trọng");
    }

}