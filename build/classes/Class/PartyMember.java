/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author THANH DUONG
 */
public class PartyMember {
    private String id;
    private String fullName;
    private String birthDate;
    private String address;
    private String phoneNumber;
    private String email;
    private String status;

    public PartyMember(String id, String fullName, String birthDate, String address, String phoneNumber, String email, String status) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
    }
    
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
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

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
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
