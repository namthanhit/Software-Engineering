package Database;

import Class.Discipline;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thanh Nam
 */
public class DisciplineList {

    // Phương thức lấy tất cả thông tin từ bảng Discipline
    public static List<Discipline> getAllDisciplines() {
        List<Discipline> disciplines = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/PartyManagement"; 
        String username = "root";  
        String password = "08012004";  

        // Truy vấn SQL để lấy tất cả dữ liệu từ bảng Discipline
        String query = "SELECT id, partyMemberId, orgId, decisionMaker, disciplineDate, description FROM Discipline";

        try (Connection connection = java.sql.DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Thực hiện truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();

            // Xử lý kết quả truy vấn
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String partyMember = resultSet.getString("partyMemberId");
                String orgId = resultSet.getString("orgId");
                Date disciplineDate = resultSet.getDate("disciplineDate");
                String decisionMaker = resultSet.getString("decisionMaker");
                String description = resultSet.getString("description");

                // Tạo đối tượng Discipline và thêm vào danh sách
                Discipline discipline = new Discipline(id, orgId, partyMember, decisionMaker, disciplineDate, description);
                disciplines.add(discipline);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return disciplines;
    }

  
}
