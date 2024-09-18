package com.example.HospitalMngbcd.exceptionHandler;


public class OperationFailedException extends RuntimeException{
    public OperationFailedException(String message){
        super(message);
    }
}
