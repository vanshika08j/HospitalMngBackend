package com.example.HospitalMngbcd.exceptionHandler;


public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
