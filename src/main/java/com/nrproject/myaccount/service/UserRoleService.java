package com.nrproject.myaccount.service;

import com.nrproject.myaccount.entity.UserRole;
import com.nrproject.myaccount.repo.UserRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }


    public UserRole addRoleToUser(UserRole userRole){
        return userRoleRepository.save(userRole);
    }
}
