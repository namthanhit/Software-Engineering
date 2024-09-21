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
public class Discipline {
    private String id;
    private String orgId;
    private String partyMemberId;
    private String decisionMaker;
    private Date disciplineDate;
    private String description;

    public Discipline() {
    }

    public Discipline(String id, String orgId, String partyMemberId, String decisionMaker, Date disciplineDate, String description) {
        this.id = id;
        this.orgId = orgId;
        this.partyMemberId = partyMemberId;
        this.decisionMaker = decisionMaker;
        this.disciplineDate = disciplineDate;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getOrgId() {
        return orgId;
    }

    public String getPartyMemberId() {
        return partyMemberId;
    }

    public String getDecisionMaker() {
        return decisionMaker;
    }

    public Date getDisciplineDate() {
        return disciplineDate;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public void setPartyMemberId(String partyMemberId) {
        this.partyMemberId = partyMemberId;
    }

    public void setDecisionMaker(String decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public void setDisciplineDate(Date disciplineDate) {
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
