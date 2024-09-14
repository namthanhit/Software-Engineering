/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author THANH DUONG
 */
public class TransferOut {
    private String id;
    private String partyMemberId;
    private String destination;
    private String date;
    private String status;

    public TransferOut(String id, String partyMemberId, String destination, String date, String status) {
        this.id = id;
        this.partyMemberId = partyMemberId;
        this.destination = destination;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getPartyMemberId() {
        return partyMemberId;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
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

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void createTransferOut(){
        
    }
    public void updateTransferOut(){
        
    }
    public void searchTransferOut(){
        
    }
}
