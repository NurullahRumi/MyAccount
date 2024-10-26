package com.nrproject.myaccount.controller;

import com.nrproject.myaccount.entity.UserRole;
import com.nrproject.myaccount.service.UserRoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userRole")
public class UserRoleController {

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping("/addUserRole")
    public UserRole addUserRole(@RequestBody UserRole userRole){
        UserRole userRole1 = new UserRole();
        userRole1.setUserId(userRole.getUserId());
        userRole1.setUserRole(userRole.getUserRole());
        return userRoleService.addRoleToUser(userRole1);
    }
}
