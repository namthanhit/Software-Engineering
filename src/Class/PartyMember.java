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
public class PartyMember {
    private String id;
    private String fullName;
    private Date birthDate;
    private Date joinDate;
    private String address;
    private String email;
    private String phoneNumber;
    private String status;

    public PartyMember() {
    }

    public PartyMember(String id, String fullName, Date birthDate, Date joinDate, String address, String email, String phoneNumber, String status) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.joinDate = joinDate;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public void addPartyMember(){
        
    }
    public void updatePartyMember(){
        
    }
    public void searchPartyMember(){
        
    }
}
