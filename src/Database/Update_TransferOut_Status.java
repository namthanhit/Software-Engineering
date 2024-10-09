package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author thanhnam
 */
public class Update_TransferOut_Status {
    
    public static void updateTransferOutStatus(String id, String newStatus) {
        String url = "jdbc:mysql://localhost:3306/PartyManagement"; // Thay đổi thông tin kết nối nếu cần
        String username = "root";  // Tên đăng nhập
        String password = "08012004";  // Mật khẩu

        // Câu lệnh SQL để cập nhật cột status dựa trên id
        String query = "UPDATE TransferOut SET status = ? WHERE id = ?";

        try (Connection connection = java.sql.DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Thiết lập giá trị cho tham số (status và id)
            preparedStatement.setString(1, newStatus);
            preparedStatement.setString(2, id);

            // Thực thi câu lệnh update
            int rowsUpdated = preparedStatement.executeUpdate();

            // Kiểm tra xem có bao nhiêu dòng đã được cập nhật
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Thành công!");
            } else {
                System.out.println("Không tìm thấy bản ghi với id: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
