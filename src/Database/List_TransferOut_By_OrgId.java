package Database;

import Class.TransferOut;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buingocduc
 */
public class List_TransferOut_By_OrgId {
    public static List<TransferOut> getTransferOutByOrgId(String orgId) {
        List<TransferOut> transferOuts = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/PartyManagement"; 
        String username = "root";  
        String password = "08012004";  

        // Câu lệnh SQL lấy thông tin TransferOut dựa trên orgId
        String query = "select id, partyMemberId, orgId, status, transferDate, reason from TransferOut where orgId = ?";

        try (Connection connection = java.sql.DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Thiết lập giá trị cho orgId
            preparedStatement.setString(1, orgId);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            // Duyệt kết quả trả về từ câu truy vấn và tạo danh sách TransferOut
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String partyMember = resultSet.getString("partyMemberId");
                String orgID = resultSet.getString("orgId");
                String status = resultSet.getString("status");
                Date transferDate = resultSet.getDate("transferDate");
                String reason = resultSet.getString("reason");

                // Tạo đối tượng TransferOut và thêm vào danh sách
                TransferOut transferOut = new TransferOut(id, partyMember, orgID, status, transferDate, reason);
                transferOuts.add(transferOut);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return transferOuts;
    }
}
