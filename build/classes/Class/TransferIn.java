/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author THANH DUONG
 */
public class TransferIn {
    private String id;
    private String partyMemberId;
    private String source;
    private String date;
    private String status;

    public TransferIn(String id, String partyMemberId, String source, String date, String status) {
        this.id = id;
        this.partyMemberId = partyMemberId;
        this.source = source;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getPartyMemberId() {
        return partyMemberId;
    }

    public String getSource() {
        return source;
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

    public void setSource(String source) {
        this.source = source;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void createTransferIn(){
        
    }
    public void updateTransferIn(){
        
    }
    public void searchTransferIn(){
        
    }
}
