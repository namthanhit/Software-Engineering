package Class;

public class User {
    private String id;
    private String partyMemberId;
    private String partOrgId;
    private String password;
    private String role;

    public User() {
    }

    public User(String id, String partyMemberId, String partOrgId, String password, String role) {
        this.id = id;
        this.partyMemberId = partyMemberId;
        this.partOrgId = partOrgId;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
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

    public String getRole() {
        return role;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setRole(String role) {
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
