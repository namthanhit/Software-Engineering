/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author THANH DUONG
 */
public class BranchActivity {
    private String id;
    private String partyMemberId;
    private String activityName;
    private String activityDate;
    private String location;
    private String remarks;

    public BranchActivity(String id, String partyMemberId, String activityName, String activityDate, String location, String remarks) {
        this.id = id;
        this.partyMemberId = partyMemberId;
        this.activityName = activityName;
        this.activityDate = activityDate;
        this.location = location;
        this.remarks = remarks;
    }

    public String getId() {
        return id;
    }

    public String getPartyMemberId() {
        return partyMemberId;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public String getLocation() {
        return location;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPartyMemberId(String partyMemberId) {
        this.partyMemberId = partyMemberId;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public void addBrandActivity(){
        
    }
    public void updateBrandActivity(){
        
    }
    public void searchBrandActivity(){
        
    }
    
}
