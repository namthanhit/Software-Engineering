/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.Date;
import javax.swing.Icon;

/**
 *
 * @author THANH DUONG
 */
public class PartyMember {
    private Icon avatar;
    private String id;
    private String fullName;
    private Date birthDate;
    private Date joinDate;
    private String address;
    private String email;
    private String phoneNumber;
    private String position;
    private String orgId;
    private String detail;

    public PartyMember() {
    }
    
    public PartyMember(Icon avatar, String id, String fullName, Date birthDate, Date joinDate, String address, String email, String phoneNumber, String position, String orgId, String detail) {
        this.avatar = avatar;
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.joinDate = joinDate;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.orgId = orgId;
        this.detail = detail;
    }

    public Icon getAvatar() {
        return avatar;
    }

    public void setAvatar(Icon avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    
    
    @Override
    public String toString() {
        return "PartyMember{" +
               "id='" + id + '\'' +
               ", fullName='" + fullName + '\'' +
               ", birthDate='" + birthDate + '\'' +
               ", joinDate='" + joinDate + '\'' +
               ", address='" + address + '\'' +
               ", email='" + email + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", position='" + position + '\'' +
               ", detail='" + detail + '\'' +
               '}';
    }
    
}
