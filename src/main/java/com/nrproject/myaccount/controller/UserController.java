package com.nrproject.myaccount.controller;

import com.nrproject.myaccount.entity.Users;
import com.nrproject.myaccount.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public Users addUsers(@RequestBody Users users){

        System.out.println(users.getUserName() + ' ' + users.getPassCode() + ' ' + users.getEnabled());
        Users ur = new Users();
        ur.setUserName(users.getUserName());
        ur.setPassCode(users.getPassCode());
        ur.setEnabled(users.getEnabled());
        ur.setUserEmail(users.getUserEmail());
        ur.setUserPhone(users.getUserPhone());
        ur.setUserAddress(users.getUserAddress());
        return userService.addUser(ur);
    }

    @GetMapping("/allUsers")
    public List<Users> getAllUsers(){
        return userService.getAll();
    }
}
