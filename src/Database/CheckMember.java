/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class CheckMember {
    public static boolean check(User user) {
        // URL kết nối MySQL
        String jdbcURL = "jdbc:mysql://localhost:3306/PartyManagement";
        String username = "root";
        String password = "12345678";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "SELECT * FROM User WHERE partyMemberId = ? "
                    + "AND password = ?";
            
            
            // Tạo PreparedStatement để truyền tham số
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getPartyMemberId());  // Thiết lập giá trị cho partyMemberId
            statement.setString(2, user.getPassword());    // Thiết lập giá trị cho password

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
