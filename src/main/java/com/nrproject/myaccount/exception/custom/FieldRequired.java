package com.nrproject.myaccount.exception.custom;

public class FieldRequired extends RuntimeException{

    public FieldRequired(String message) {
        super(message);
    }

    public FieldRequired(String message, Throwable cause) {
        super(message, cause);
    }

    public FieldRequired(Throwable cause) {
        super(cause);
    }

}
