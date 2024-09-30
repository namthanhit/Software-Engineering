/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Class.Discipline;
import Class.Reward;
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
public class ListDisciplinePartyMember {
    public static List<Discipline> getBranchActivitiesByOrgId(String orgId) {
        List<Discipline> disciplines = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/PartyManagement"; 
        String username = "root";  
        String password = "12345678";  

        String query = "SELECT id, partyMemberId, decisionMaker, disciplineDate, description FROM Discipline WHERE partyMemberId = ? ";

        try (Connection connection = java.sql.DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, orgId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String partyMember = resultSet.getString("partyMemberId");
                Date disciplineDate = resultSet.getDate("disciplineDate");
                String decisionMaker = resultSet.getString("decisionMaker");
                String description = resultSet.getString("description");
                
                Discipline discipline = new Discipline(id, orgId, partyMember, decisionMaker, disciplineDate, description);
                disciplines.add(discipline);
                
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return disciplines;
    }
}
