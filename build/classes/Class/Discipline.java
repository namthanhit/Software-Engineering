/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author THANH DUONG
 */
public class Discipline {
    private String id;
    private String organizationId;
    private String partyMemberId;
    private String disciplineDate;
    private String description;

    public Discipline(String id, String organizationId, String partyMemberId, String disciplineDate, String description) {
        this.id = id;
        this.organizationId = organizationId;
        this.partyMemberId = partyMemberId;
        this.disciplineDate = disciplineDate;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public String getPartyMemberId() {
        return partyMemberId;
    }

    public String getDisciplineDate() {
        return disciplineDate;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public void setPartyMemberId(String partyMemberId) {
        this.partyMemberId = partyMemberId;
    }

    public void setDisciplineDate(String disciplineDate) {
        this.disciplineDate = disciplineDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void addDiscipline(){
        
    }
    public void updateDiscipline(){
        
    }
    public void searchDiscipline(){
        
    }
}
