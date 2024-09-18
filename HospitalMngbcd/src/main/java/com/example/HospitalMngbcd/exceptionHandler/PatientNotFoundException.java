package com.example.HospitalMngbcd.exceptionHandler;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message){
        super(message);
    }
}
