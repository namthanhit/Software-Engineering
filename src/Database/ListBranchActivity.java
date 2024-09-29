/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Class.BranchActivity;
import Class.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

/**
 *
 * @author buingocduc
 */
public class ListBranchActivity {
    private static DatabaseConfig dbconfig = new DatabaseConfig();
    public static String getPartOrgIdByMemberId(String partyMemberId) {
        String orgId = null;

        String query = "SELECT partOrgId FROM User WHERE partyMemberId = ?";

        try (Connection connection = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, partyMemberId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                orgId = resultSet.getString("partOrgId");
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return orgId;
    }
    
    public static List<BranchActivity> getBranchActivitiesByOrgId(String orgId) {
        List<BranchActivity> activities = new ArrayList<>();
 

        String query = "SELECT id, activityName, startDate, endDate, status, description FROM BranchActivity WHERE orgId = ?";

        try (Connection connection = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
            Statement stmt = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, orgId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String activityName = resultSet.getString("activityName");
                Date startDate = resultSet.getDate("startDate");
                Date endDate = resultSet.getDate("endDate");
                String status = resultSet.getString("status");
                String description = resultSet.getString("description");

                BranchActivity activity = new BranchActivity(id, activityName, startDate, endDate, status, description);
                activities.add(activity);

                // In ra để kiểm tra
                System.out.println("Found activity: " + activityName + " for orgId: " + orgId);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return activities;
    }

    
}
