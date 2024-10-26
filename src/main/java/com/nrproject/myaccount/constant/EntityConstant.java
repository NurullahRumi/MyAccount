package com.nrproject.myaccount.constant;

import java.util.regex.Pattern;

public final class EntityConstant {

    public static final String USER = "users";


    public static boolean validateEmail(String email){

        if(email == null || email.isEmpty()){
            return false;
        }

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);

        if(pattern.matcher(email).matches()){
            return true;
        }else {
            return false;
        }
    }

    private EntityConstant(){}


}
