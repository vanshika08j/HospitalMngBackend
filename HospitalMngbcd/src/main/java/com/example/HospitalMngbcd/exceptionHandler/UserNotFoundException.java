package com.example.HospitalMngbcd.exceptionHandler;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){
        super(message);
    }

}
