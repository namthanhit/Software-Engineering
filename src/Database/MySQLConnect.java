  package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class MySQLConnect {
    public static void main(String[] args) {
        // URL kết nối MySQL
        String jdbcURL = "jdbc:mysql://localhost:3306/PartyManagement";
        String username = "root";
        String password = "12345678";
        Connection connection = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected successfully");

            // Tạo statement để thực hiện truy vấn SQL
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM PartyMember";

            // Thực hiện truy vấn
            ResultSet resultSet = statement.executeQuery(sql);

            // Xử lý kết quả
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " " + resultSet.getString("avatar"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}