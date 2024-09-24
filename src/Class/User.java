package Class;

public class User {
    private String partyMemberId;
    private String partOrgId;
    private String password;
    private boolean role;

    public User() {
    }

    public User(String partyMemberId, String partOrgId, String password, boolean role) {
        this.partyMemberId = partyMemberId;
        this.partOrgId = partOrgId;
        this.password = password;
        this.role = role;
    }

    public String getPartyMemberId() {
        return partyMemberId;
    }

    public String getPartOrgId() {
        return partOrgId;
    }

    public String getPassword() {
        return password;
    }

    public boolean getRole() {
        return role;
    }

    public void setPartyMemberId(String partyMemberId) {
        this.partyMemberId = partyMemberId;
    }

    public void setPartOrgId(String partOrgId) {
        this.partOrgId = partOrgId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
    
    
    public void addUser() {
        // Thêm mới người dùng
    }

    public void updateUser() {
        // Cập nhật thông tin người dùng
    }

    public void searchUser() {
        
    }
}
