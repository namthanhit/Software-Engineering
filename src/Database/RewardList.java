/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

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
 * @author Thanh Nam
 */
public class RewardList {

    // Phương thức lấy tất cả thông tin từ bảng Reward
    public static List<Reward> getAllRewards() {
        List<Reward> rewards = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/PartyManagement"; 
        String username = "root";  
        String password = "08012004";  

        // Truy vấn SQL để lấy tất cả dữ liệu từ bảng Reward
        String query = "SELECT id, partyMemberId, rewardDate, decisionMaker, description, orgId FROM Reward";

        try (Connection connection = java.sql.DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Thực hiện truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();

            // Xử lý kết quả truy vấn
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String partyMemberId = resultSet.getString("partyMemberId");
                Date rewardDate = resultSet.getDate("rewardDate");
                String decisionMaker = resultSet.getString("decisionMaker");
                String description = resultSet.getString("description");
                String orgId = resultSet.getString("orgId");

                // Tạo đối tượng Reward và thêm vào danh sách
                Reward reward = new Reward(id, partyMemberId,orgId, rewardDate, decisionMaker, description );
                rewards.add(reward);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rewards;
    }
}

