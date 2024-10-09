package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Update_EvalRequest {
    public static String updateEvalRequestStatus(String id, String newStatus) {
        String url = "jdbc:mysql://localhost:3306/PartyManagement"; 
        String username = "root";  
        String password = "08012004";  

        String query = "UPDATE EvalRequest SET status = ? WHERE id = ?";

        try (Connection connection = java.sql.DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newStatus);
            preparedStatement.setString(2, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Thành công!");
                return "Cập nhật thành công!";
            } else {
                return "Không tìm thấy EvalRequest với ID: " + id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Cập nhật thất bại: " + e.getMessage(); // Trả về thông báo lỗi
        }
    }
}
