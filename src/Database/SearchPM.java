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

public class SearchPM {
    private static DatabaseConfig dbconfig = new DatabaseConfig();
    
    public static boolean checkIdInDatabase(String id) {
        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(dbconfig.getUrl(),dbconfig.getUsername(), dbconfig.getPassword());
            String query = "SELECT COUNT(*) FROM PartyMember WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0; // Trả về true nếu ID tồn tại
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Trả về false nếu có lỗi hoặc ID không tồn tại
    }
}
