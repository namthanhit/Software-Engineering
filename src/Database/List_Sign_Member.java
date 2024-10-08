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
public class List_Sign_Member {
    private static DatabaseConfig dbconfig = new DatabaseConfig();
    
    public static List<SignBranchActivity> getBranchActivitiesByIdMember(String idBA) {
        
        List<SignBranchActivity> signBA = new ArrayList<>();
 
        String query = "SELECT id, idActivity, partyMemberId, orgId, status \n" +
                        "FROM SignBranchActivity\n" +
                        "WHERE partyMemberId = ? ";

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
    
    public static String getDateStartByIdBA(String idBA) {
        String date = null;
        // Câu lệnh SQL để lấy fullName từ bảng PartyMember theo id
        String sql = "SELECT startDate FROM BranchActivity WHERE id = ?";

        try (Connection conn = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Đặt giá trị cho tham số id trong câu lệnh SQL
            stmt.setString(1, idBA);

            // Thực thi truy vấn và nhận kết quả
            try (ResultSet rs = stmt.executeQuery()) {
                // Nếu tồn tại kết quả, lấy fullName
                if (rs.next()) {
                    date = rs.getString("startDate");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Bắt lỗi SQL
        }
        return date;
    }
    public static String getDateEndByIdBA(String idBA) {
        String date = null;
        // Câu lệnh SQL để lấy fullName từ bảng PartyMember theo id
        String sql = "SELECT endDate FROM BranchActivity WHERE id = ?";

        try (Connection conn = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Đặt giá trị cho tham số id trong câu lệnh SQL
            stmt.setString(1, idBA);

            // Thực thi truy vấn và nhận kết quả
            try (ResultSet rs = stmt.executeQuery()) {
                // Nếu tồn tại kết quả, lấy fullName
                if (rs.next()) {
                    date = rs.getString("endDate");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Bắt lỗi SQL
        }
        return date;
    }
    
    public static String getNameAByIdBA(String idBA) {
        String date = null;
        // Câu lệnh SQL để lấy fullName từ bảng PartyMember theo id
        String sql = "SELECT activityName FROM BranchActivity WHERE id = ?";

        try (Connection conn = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Đặt giá trị cho tham số id trong câu lệnh SQL
            stmt.setString(1, idBA);

            // Thực thi truy vấn và nhận kết quả
            try (ResultSet rs = stmt.executeQuery()) {
                // Nếu tồn tại kết quả, lấy fullName
                if (rs.next()) {
                    date = rs.getString("activityName");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Bắt lỗi SQL
        }
        return date;
    }
    
    public static String getDetailByIdBA(String idBA) {
        String date = null;
        // Câu lệnh SQL để lấy fullName từ bảng PartyMember theo id
        String sql = "SELECT description FROM BranchActivity WHERE id = ?";

        try (Connection conn = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Đặt giá trị cho tham số id trong câu lệnh SQL
            stmt.setString(1, idBA);

            // Thực thi truy vấn và nhận kết quả
            try (ResultSet rs = stmt.executeQuery()) {
                // Nếu tồn tại kết quả, lấy fullName
                if (rs.next()) {
                    date = rs.getString("description");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Bắt lỗi SQL
        }
        return date;
    }
    
    public void updateSignBranchActivity(String idActivity, String partyMemberId, String orgId, String status) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. Kết nối đến cơ sở dữ liệu
            conn = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());

            // 2. Tạo câu lệnh SQL UPDATE
            String sql = "UPDATE SignBranchActivity SET orgId = ?, status = ? " +
                         "WHERE idActivity = ? AND partyMemberId = ?";

            // 3. Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, orgId);
            pstmt.setString(2, status);
            pstmt.setString(3, idActivity);
            pstmt.setString(4, partyMemberId);

            // 4. Thực thi câu lệnh
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật thành công.");
            } else {
                System.out.println("Không tìm thấy hoạt động với idActivity: " + idActivity + " và partyMemberId: " + partyMemberId);
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
