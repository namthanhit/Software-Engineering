/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author THANH DUONG
 */
public class PartyOrganization {
    private String id;
    private String username;
    private String description;
    private String status;

    public PartyOrganization(String id, String username, String description, String status) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void addOrganization(){
        
    }
    public void updateOrganization(){
        
    }
    public void searchOrganization(){
        
    }
}
