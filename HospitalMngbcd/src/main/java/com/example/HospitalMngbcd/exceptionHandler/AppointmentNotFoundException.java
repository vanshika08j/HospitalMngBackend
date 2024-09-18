package com.example.HospitalMngbcd.exceptionHandler;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(String message){
        super(message);
    }
}

