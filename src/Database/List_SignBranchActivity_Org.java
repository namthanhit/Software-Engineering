/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;


import Class.SignBranchActivity;
import java.sql.Connection;
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
public class List_SignBranchActivity_Org {
    private static DatabaseConfig dbconfig = new DatabaseConfig();
    
    public static List<SignBranchActivity> getSignBranchActivity(String idBA) {
        List<SignBranchActivity> signBA = new ArrayList<>();
        String sql = "SELECT * FROM SignBranchActivity WHERE idActivity = ?";

        try (Connection connection = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, idBA);
            ResultSet resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return signBA;
    }
    
    
    public static List<SignBranchActivity> getBranchActivitiesByIdMember(String idBA) {
        List<SignBranchActivity> signBA = new ArrayList<>();
 
        String query = "SELECT \n" +
                        "    sba.id, \n" +
                        "    sba.idActivity, \n" +
                        "    sba.partyMemberId, \n" +
                        "    pm.fullName\n" +
                        "    sba.orgId, \n" +
                        "    sba.status, \n" +
                        "FROM \n" +
                        "    SignBranchActivity sba\n" +
                        "JOIN \n" +
                        "    PartyMember pm\n" +
                        "ON \n" +
                        "    sba.partyMemberId = pm.id\n" +
                        "WHERE \n" +
                        "    sba.idActivity = ? ";

        try (Connection connection = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
            Statement stmt = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, idBA);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            //id, idActivity, partyMemberId, orgId, status
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String idActivity = resultSet.getString("idActivity");
                String partyMemberId = resultSet.getString("partyMemberId");
                String nameMember = resultSet.getString("fullName");
                String orgId = resultSet.getString("orgId");
                String status = resultSet.getString("status");
                
                SignBranchActivity activity = new SignBranchActivity(id, idActivity, partyMemberId, orgId, status);
                signBA.add(activity);
                
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return signBA;
    }
    
    
    
    

    
    
}
