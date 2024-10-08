/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author buingocduc
 */
public class SignBranchActivity {
    private String id;
    private String idBA;
    private String idMember;
    private String idOrg;
    private String status;

    public SignBranchActivity() {
    }

    public SignBranchActivity(String id, String idBA, String idMember, String idOrg, String status) {
        this.id = id;
        this.idBA = idBA;
        this.idMember = idMember;
        this.idOrg = idOrg;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdBA() {
        return idBA;
    }

    public void setIdBA(String idBA) {
        this.idBA = idBA;
    }

    public String getIdMember() {
        return idMember;
    }

    public void setIdMember(String idMember) {
        this.idMember = idMember;
    }

    public String getIdOrg() {
        return idOrg;
    }

    public void setIdOrg(String idOrg) {
        this.idOrg = idOrg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
