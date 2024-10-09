package Database;

import Class.EvalRequest; // Đảm bảo bạn đã tạo lớp EvalRequest
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class List_EvalRequest_By_OrgId {
    public static List<EvalRequest> getEvalRequestByOrgId(String orgId) {
        List<EvalRequest> evalRequests = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/PartyManagement"; 
        String username = "root";  
        String password = "08012004";  

        String query = "SELECT id, partyMemberId, orgId, date, status, reason FROM EvalRequest WHERE orgId = ?";

        try (Connection connection = java.sql.DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, orgId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String partyMemberId = resultSet.getString("partyMemberId");
                String orgIdResult = resultSet.getString("orgId");
                Date date = resultSet.getDate("date");
                String status = resultSet.getString("status");
                String reason = resultSet.getString("reason");
                
                // Tạo đối tượng EvalRequest và thêm vào danh sách
                EvalRequest evalRequest = new EvalRequest(id, partyMemberId, orgIdResult, date, status, reason);
                evalRequests.add(evalRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return evalRequests;
    }
}
