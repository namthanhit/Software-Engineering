/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author THANH DUONG
 */
public class ExitRequest {
    private String id;
    private String partyMemberId;
    private String requestDate;
    private String reason;
    private String status;

    public ExitRequest(String id, String partyMemberId, String requestDate, String reason, String status) {
        this.id = id;
        this.partyMemberId = partyMemberId;
        this.requestDate = requestDate;
        this.reason = reason;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getPartyMemberId() {
        return partyMemberId;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPartyMemberId(String partyMemberId) {
        this.partyMemberId = partyMemberId;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void createRequest(){
        
    }
    public void updateRequest(){
        
    }
    public void searchRequest(){
        
    }
}
