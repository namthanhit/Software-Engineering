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
public class TransferOut {
    private String id;
    private String partyMemberId;
    private String orgId;
    private String status;
    private Date transferDate;
    private String reason;

    public TransferOut() {
    }

    public TransferOut(String id, String partyMemberId, String orgId, String status, Date transferDate, String reason) {
        this.id = id;
        this.partyMemberId = partyMemberId;
        this.orgId = orgId;
        this.status = status;
        this.transferDate = transferDate;
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getStatus() {
        return status;
    }

    public Date getTransferDate() {
        return transferDate;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    
    public void createTransferOut(){
        
    }
    public void updateTransferOut(){
        
    }
    public void searchTransferOut(){
        
    }
}
