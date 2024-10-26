package com.nrproject.myaccount.service;

import com.nrproject.myaccount.entity.Users;
import com.nrproject.myaccount.exception.custom.NotFoundException;
import com.nrproject.myaccount.exception.custom.NotValidEmail;
import com.nrproject.myaccount.repo.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

import static com.nrproject.myaccount.constant.EntityConstant.validateEmail;

@Service
public class UserService {

    private final UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }



    public List<Users> getAll(){
        return userRepository.findAll();
    }

    public Users addUser(Users users){

        boolean isValid = validateEmail(users.getUserEmail());
        if (isValid == false){
            throw new NotValidEmail("Email is not valid - " + users.getUserEmail());
        }

        String email = users.getUserEmail();
        int index = email.indexOf('@');
        String genUserId = email.substring(0,index).toUpperCase();

        Users userToDb = new Users();
        String encodedPasscode = this.passwordEncoder.encode(users.getPassCode());
        userToDb.setUserId(genUserId);
        userToDb.setUserName(users.getUserName());
        userToDb.setPassCode("{bcrypt}" + encodedPasscode);
        userToDb.setEnabled(users.getEnabled());
        userToDb.setUserEmail(users.getUserEmail());
        userToDb.setUserPhone(users.getUserPhone());
        userToDb.setUserAddress(users.getUserAddress());

        return userRepository.save(userToDb);
    }

}
