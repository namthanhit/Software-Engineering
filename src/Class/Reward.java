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
public class Reward {
    private String id;
    private String partyMemberId;
    private String orgId;
    private Date rewardDate;
    private String decisionMaker;
    private String description;

    public Reward() {
    }

    public Reward(String id, String partyMemberId, String orgId, Date rewardDate, String decisionMaker, String description) {
        this.id = id;
        this.partyMemberId = partyMemberId;
        this.orgId = orgId;
        this.rewardDate = rewardDate;
        this.decisionMaker = decisionMaker;
        this.description = description;
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

    public Date getRewardDate() {
        return rewardDate;
    }

    public String getDecisionMaker() {
        return decisionMaker;
    }

    public String getDescription() {
        return description;
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

    public void setRewardDate(Date rewardDate) {
        this.rewardDate = rewardDate;
    }

    public void setDecisionMaker(String decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
    public void addReward(){
        
    }
    public void updateReward(){
        
    }
    public void searchReward(){
        
    }
}
