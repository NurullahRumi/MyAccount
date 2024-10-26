package com.nrproject.myaccount.exception.custom;

public class NotValidEmail extends RuntimeException{

    public NotValidEmail(String message) {
        super(message);
    }

    public NotValidEmail(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidEmail(Throwable cause) {
        super(cause);
    }

}
