package com.nrproject.myaccount.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nr_roles")
@IdClass(UserRolePK.class)
public class UserRole {
@Id
    @Column(name = "ur_id")
    private String userId;

@Id
    @Column(name = "roles")
    private String userRole;

    public UserRole(){}

    public UserRole(String userName, String userRole) {
        this.userId = userName;
        this.userRole = userRole;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userName) {
        this.userId = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
