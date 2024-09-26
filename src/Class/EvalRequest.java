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
public class EvalRequest {
    private String id;
    private String partyMemberId;
    private String orgId;
    private Date date;
    private String reason;
    private String status;
    public EvalRequest() {
    }

    public EvalRequest(String id, String partyMemberId, String orgId, Date date, String reason, String status) {
        this.id = id;
        this.partyMemberId = partyMemberId;
        this.orgId = orgId;
        this.date = date;
        this.reason = reason;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getId() {
        return id;
    }

    public String getPartyMemberId() {
        return partyMemberId;
    }

    public String getOrgId() {
        return orgId;
    }

    public Date getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPartyMemberId(String partyMemberId) {
        this.partyMemberId = partyMemberId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
    
    
}
