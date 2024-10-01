package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author buingocduc
 */
public class Insert_TransferOut_InDatabase {
    private static DatabaseConfig dbconfig = new DatabaseConfig();

    // Kiểm tra xem ID đã tồn tại hay chưa
    private boolean isIdExist(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
            String checkSql = "SELECT id FROM TransferOut WHERE id = ?";
            pstmt = conn.prepareStatement(checkSql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            return rs.next();  // Trả về true nếu ID đã tồn tại
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return false;
    }

    // Phương thức thêm bản ghi chuyển thành viên ra ngoài
    public void addTransferOutRecord(String partyMemberId, String orgId, String status, String transferDate, String reason) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            // 2. Kết nối đến cơ sở dữ liệu
            conn = java.sql.DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());

            // 3. Tạo câu lệnh SQL INSERT
            String sql = "INSERT INTO TransferOut (partyMemberId, orgId, status, transferDate, reason) " +
                         "VALUES (?, ?, ?, ?, ?)";

            // 4. Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, partyMemberId);
            pstmt.setString(2, orgId);
            pstmt.setString(3, status);
            pstmt.setDate(4, java.sql.Date.valueOf(transferDate));  // transferDate dạng 'YYYY-MM-DD'
            pstmt.setString(5, reason);

            // 5. Thực thi câu lệnh
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Thành công!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. Đóng kết nối
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    
}
