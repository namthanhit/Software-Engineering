/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Class.BranchActivity;
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
    
    public static List<BranchActivity> getBranchActivitiesByIdMember(String idMember) {
        List<BranchActivity> activities = new ArrayList<>();
 
        String query = "SELECT id, activityName, startDate, endDate, status, description FROM BranchActivity WHERE partyMemberId = ?";

        try (Connection connection = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
            Statement stmt = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, idMember);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String activityName = resultSet.getString("activityName");
                Date startDate = resultSet.getDate("startDate");
                Date endDate = resultSet.getDate("endDate");
                String status = resultSet.getString("status");
                String description = resultSet.getString("description");

                BranchActivity activity = new BranchActivity(id, activityName, startDate, endDate, status, idMember, description);
                activities.add(activity);
                
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return activities;
    }
    
    
    //đăng ký sinh hoạt cho đảng viên:
    public void  updateBranchActivity(String id, String partyMemberId, String activityName, 
                                  String startDate, String endDate, String status, 
                                  String description, String orgId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());

            // 2. Tạo câu lệnh SQL UPDATE
            String sql = "UPDATE BranchActivity SET activityName = ?, startDate = ?, endDate = ?, " +
                         "status = ?, description = ?, orgId = ? " +
                         "WHERE id = ? AND partyMemberId = ?";

            // 3. Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, activityName);
            pstmt.setDate(2, java.sql.Date.valueOf(startDate)); 
            pstmt.setDate(3, java.sql.Date.valueOf(endDate));
            pstmt.setString(4, status);
            pstmt.setString(5, description);
            pstmt.setString(6, orgId);
            pstmt.setString(7, id);
            pstmt.setString(8, partyMemberId);

            // 4. Thực thi câu lệnh
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật thành công.");
            } else {
                System.out.println("Không tìm thấy hoạt động với ID: " + id + " và partyMemberId: " + partyMemberId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Đóng kết nối
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    
}
