package managedangvien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class MySQLConnect {
    public static void main(String[] args) {
        // URL kết nối MySQL
        String jdbcURL = "jdbc:mysql://20.6.136.74:3306/PartyManagement";
        String username = "root";
<<<<<<< HEAD
        String password = "thanhnam";
=======
        String password = "Duong20012004";
>>>>>>> c10289a67dccb6e52264267f411142de8f72e9e2

        Connection connection = null;

        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected successfully");

            // Tạo statement để thực hiện truy vấn SQL
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM User";

            // Thực hiện truy vấn
            ResultSet resultSet = statement.executeQuery(sql);

            // Xử lý kết quả
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " " + resultSet.getString("username"));
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