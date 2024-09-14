/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author THANH DUONG
 */
public class Reward {
    private String id;
    private String organizationId;
    private String partyMemberId;
    private String rewardDate;
    private String description;

    public Reward(String id, String organizationId, String partyMemberId, String rewardDate, String description) {
        this.id = id;
        this.organizationId = organizationId;
        this.partyMemberId = partyMemberId;
        this.rewardDate = rewardDate;
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

    public String getRewardDate() {
        return rewardDate;
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

    public void setRewardDate(String rewardDate) {
        this.rewardDate = rewardDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void createTransferReward(){
        
    }
    public void updateTransferReward(){
        
    }
    public void searchTransferReward(){
        
    }
    
    public void addReward(){
        
    }
    public void updateReward(){
        
    }
    public void searchReward(){
        
    }
}
