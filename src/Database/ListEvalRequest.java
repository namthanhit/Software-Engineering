/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Class.EvalRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
/**
 *
 * @author buingocduc
 */
public class ListEvalRequest {
    private static DatabaseConfig dbconfig = new DatabaseConfig();

    // Phương thức lấy danh sách EvalRequest từ CSDL dựa trên partyMemberId
    public static List<EvalRequest> getEvalRequestsByMemberId(String partyMemberId) {
        List<EvalRequest> evalRequests = new ArrayList<>();
        // Câu lệnh SQL để lấy dữ liệu từ bảng EvalRequest theo partyMemberId
        String sql = "SELECT id, partyMemberId, orgId, date, status, reason FROM EvalRequest WHERE partyMemberId = ?";

        try (Connection conn = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Thiết lập giá trị cho tham số trong câu lệnh SQL
            pstmt.setString(1, partyMemberId);

            try (ResultSet rs = pstmt.executeQuery()) {
                // Lặp qua các hàng dữ liệu trong ResultSet
                while (rs.next()) {
                    String id = rs.getString("id");
                    String orgId = rs.getString("orgId");
                    Date date = rs.getDate("date");
                    String status = rs.getString("status");
                    String reason = rs.getString("reason");

                    // Tạo một đối tượng EvalRequest và thêm vào danh sách
                    EvalRequest evalRequest = new EvalRequest(id, partyMemberId, orgId, date, status, reason);
                    evalRequests.add(evalRequest);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Bắt lỗi SQL
        }
        return evalRequests;
    }

}
