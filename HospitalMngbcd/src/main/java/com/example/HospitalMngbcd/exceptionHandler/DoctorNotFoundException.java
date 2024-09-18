package com.example.HospitalMngbcd.exceptionHandler;



public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException(String message){
        super(message);
    }

}

