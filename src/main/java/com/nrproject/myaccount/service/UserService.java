package com.nrproject.myaccount.service;

import com.nrproject.myaccount.entity.Users;
import com.nrproject.myaccount.exception.custom.FieldRequired;
import com.nrproject.myaccount.exception.custom.NotValidEmail;
import com.nrproject.myaccount.exception.custom.RecordAlreadyExist;
import com.nrproject.myaccount.repo.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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

        if(users.getUserName() == null || users.getUserName().isEmpty()){
            throw new FieldRequired("User name is required.");
        }

        if(users.getPassCode() == null || users.getPassCode().isEmpty()){
            throw new FieldRequired("Password is required.");
        }

        if(users.getUserEmail() == null || users.getUserEmail().isEmpty()){
            throw new FieldRequired("Email is required.");
        }

        boolean isValid = validateEmail(users.getUserEmail());
        if (isValid == false){
            throw new NotValidEmail("Email is not valid - " + users.getUserEmail());
        }

        String email = users.getUserEmail();
        int index = email.indexOf('@');
        String genUserId = email.substring(0,index).toUpperCase();

        Users emailAlreadyExist = userRepository.getUsersByUserEmail(users.getUserEmail());
        System.out.println(emailAlreadyExist);
        if(emailAlreadyExist.getUserEmail() != null || !emailAlreadyExist.getUserEmail().isEmpty()){
            throw new RecordAlreadyExist("Email Already exist - " + users.getUserEmail());
        }

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
