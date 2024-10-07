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
    private String description;
    private String idOrg;

    public BranchActivity() {
    }

    public BranchActivity(String id, String activityName, Date startDate, Date endDate, String description, String idOrg) {
        this.id = id;
        this.activityName = activityName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.idOrg = idOrg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdOrg() {
        return idOrg;
    }

    public void setIdOrg(String idOrg) {
        this.idOrg = idOrg;
    }

    
}
