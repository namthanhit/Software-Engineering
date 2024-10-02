package Database;

import Class.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author THANH DUONG
 */
public class CheckOrg {
    private static final String jdbcURL = AdminDatabase.DATABASE_URL;
    private static final String username = AdminDatabase.DATABASE_USERNAME;
    private static final String password = AdminDatabase.DATABASE_PASSWORD;
    public static boolean check(User user) {

        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "SELECT * FROM User WHERE partyMemberId = ? "
                    + "AND password = ? AND role = ? ";
            
            
            // Tạo PreparedStatement để truyền tham số
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getPartyMemberId());  // Thiết lập giá trị cho partyMemberId
            statement.setString(2, user.getPassword());    // Thiết lập giá trị cho password
            statement.setBoolean(3, user.getRole());

            // Thực hiện truy vấn
            resultSet = statement.executeQuery();

            // Nếu có kết quả trả về, tức là người dùng hợp lệ
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng ResultSet
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // Đóng PreparedStatement
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // Đóng Connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Nếu không có kết quả, trả về false
        return false;
    }
}
