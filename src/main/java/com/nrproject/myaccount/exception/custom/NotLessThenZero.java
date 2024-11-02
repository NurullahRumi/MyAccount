package com.nrproject.myaccount.exception.custom;

public class NotLessThenZero extends RuntimeException{

    public NotLessThenZero(String message) {
        super(message);
    }

    public NotLessThenZero(String message, Throwable cause) {
        super(message, cause);
    }

    public NotLessThenZero(Throwable cause) {
        super(cause);
    }
}
