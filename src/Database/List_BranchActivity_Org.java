/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Class.BranchActivity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author buingocduc
 */
public class List_BranchActivity_Org {
    
    private static DatabaseConfig dbconfig = new DatabaseConfig();
    
    public static List<BranchActivity> getBranchActivities() {
        List<BranchActivity> activities = new ArrayList<>();
 
        String query = "SELECT id, activityName, startDate, endDate, description, orgId FROM BranchActivity";

        try (Connection connection = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
            Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(query)) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String activityName = resultSet.getString("activityName");
                Date startDate = resultSet.getDate("startDate");
                Date endDate = resultSet.getDate("endDate");
                String description = resultSet.getString("description");
                String orgId = resultSet.getString("orgId");

                BranchActivity activity = new BranchActivity(id, activityName, startDate, endDate, description, orgId);
                activities.add(activity);
                
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return activities;
    }
    
    public static String getPartOrgIdByMemberId(String partyMemberId) {
        String orgId = null;

        String query = "SELECT partOrgId FROM User WHERE partyMemberId = ?";

        try (Connection connection = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
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
    
    public static void deleteBranchActivityById(String id) {
        String query = "DELETE FROM BranchActivity WHERE id = ?";

        try (Connection connection = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Gán giá trị của id vào câu truy vấn
            preparedStatement.setString(1, id);

            // Thực thi câu lệnh DELETE
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Deleted successfully.");
                
            } else {
                System.out.println("No activity found with the given id.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertBranchActivity(BranchActivity activity) {
        String query = "INSERT INTO BranchActivity (id, activityName, startDate, endDate, description) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Thiết lập các giá trị cho câu lệnh INSERT
            preparedStatement.setString(1, activity.getId());
            preparedStatement.setString(2, activity.getActivityName());
            preparedStatement.setDate(3, new java.sql.Date(activity.getStartDate().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(activity.getEndDate().getTime()));
            preparedStatement.setString(5, activity.getDescription());

            // Thực thi câu lệnh INSERT
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Bạn đã thêm thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi thêm sinh hoạt");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBranchActivity(String activityName, Date startDate, Date endDate, String description, String id) {
        String query = "UPDATE BranchActivity SET activityName = ?, startDate = ?, endDate = ?, description = ? WHERE id = ?";

        try (Connection connection = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Thiết lập các giá trị cho câu lệnh UPDATE
            preparedStatement.setString(1, activityName);
            preparedStatement.setDate(2, new java.sql.Date(startDate.getTime()));
            preparedStatement.setDate(3, new java.sql.Date(endDate.getTime()));
            preparedStatement.setString(4, description);
            preparedStatement.setString(5, id);

            // Thực thi câu lệnh UPDATE
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Bạn đã sửa thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi sửa sinh hoạt!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
}
