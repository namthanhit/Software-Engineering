/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Class.BranchActivity;
import Class.PartyMember;
import Class.Reward;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author buingocduc
 */
public class ListRewardPartyMember {
    public static List<Reward> getBranchActivitiesByOrgId(String orgId) {
        List<Reward> rewards = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/PartyManagement"; 
        String username = "root";  
        String password = "12345678";  

        String query = "SELECT id, partyMemberId, rewardDate, decisionMaker, description FROM Reward WHERE partyMemberId = ?;";

        try (Connection connection = java.sql.DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, orgId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String partyMember = resultSet.getString("partyMemberId");
                Date rewardDate = resultSet.getDate("rewardDate");
                String decisionMaker = resultSet.getString("decisionMaker");
                String description = resultSet.getString("description");
                
                Reward reward = new Reward(id, partyMember, orgId, rewardDate, decisionMaker, description);
                rewards.add(reward);
                
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return rewards;
    }
}
