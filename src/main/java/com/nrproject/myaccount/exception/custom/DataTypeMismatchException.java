package com.nrproject.myaccount.exception.custom;

public class DataTypeMismatchException extends RuntimeException{

    public DataTypeMismatchException(String message) {
        super(message);
    }

    public DataTypeMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataTypeMismatchException(Throwable cause) {
        super(cause);
    }
}
