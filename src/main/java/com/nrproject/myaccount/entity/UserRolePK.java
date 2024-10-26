package com.nrproject.myaccount.entity;

import java.io.Serializable;

public class UserRolePK implements Serializable {
    private String userId;
    private String userRole;

    public UserRolePK(){}

    public UserRolePK(String userId, String userRole) {
        this.userId = userId;
        this.userRole = userRole;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
