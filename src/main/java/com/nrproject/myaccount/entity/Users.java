package com.nrproject.myaccount.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nr_users")
public class Users {
    @Id
    @Column(name = "ur_id")
    private String userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "pw")
    private String passCode;
    @Column(name = "enabled")
    private int enabled;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_ph")
    private String userPhone;
    @Column(name = "user_address")
    private String userAddress;


    public Users(String userId,String userName, String passCode, int enabled, String userEmail, String userPhone, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.passCode = passCode;
        this.enabled = enabled;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
    }

    public Users(){}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", passCode='" + passCode + '\'' +
                ", enabled=" + enabled +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
