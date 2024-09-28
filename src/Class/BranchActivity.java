/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.Date;

/**
 *
 * @author THANH DUONG
 */
public class BranchActivity {
    private String id;
    private String activityName;
    private Date startDate;
    private Date endDate;
    private String status;
    private String description;

    public BranchActivity(String id, String activityName, Date startDate, Date endDate, String status, String description) {
        this.id = id;
        this.activityName = activityName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.description = description;
    }

    public BranchActivity() {
    }

    public String getId() {
        return id;
    }

    public String getActivityName() {
        return activityName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void addBranchActivity(){
        
    }
    public void updateBranchActivity(){
        
    }
    public void searchBranchActivity(){
        
    }

    public String getFullName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
