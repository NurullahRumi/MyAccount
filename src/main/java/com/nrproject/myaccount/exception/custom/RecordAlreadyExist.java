package com.nrproject.myaccount.exception.custom;

public class RecordAlreadyExist extends RuntimeException{

    public RecordAlreadyExist(String message) {
        super(message);
    }

    public RecordAlreadyExist(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordAlreadyExist(Throwable cause) {
        super(cause);
    }

}
