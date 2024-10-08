/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Class.Reward;
import Class.TransferOut;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buingocduc
 */
public class List_TransferOut_By_PartymemberID {
    public static List<TransferOut> getTransferOutByPartymemberID(String orgId) {
        List<TransferOut> transferOuts = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/PartyManagement"; 
        String username = "root";  
        String password = "08012004";  

        String query = "select id, partyMemberId, orgId, status, transferDate, reason from TransferOut where partyMemberId = ?";

        try (Connection connection = java.sql.DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, orgId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String partyMember = resultSet.getString("partyMemberId");
                String orgID = resultSet.getString("orgId");
                String status = resultSet.getString("status");
                Date transferDate = resultSet.getDate("transferDate");
                String reason = resultSet.getString("reason");
                
                TransferOut transferOut = new TransferOut(id, partyMember, orgID, status, transferDate, reason);
                transferOuts.add(transferOut);
                
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return transferOuts;
    }
}
