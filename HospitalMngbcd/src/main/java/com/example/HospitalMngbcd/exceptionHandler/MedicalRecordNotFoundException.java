package com.example.HospitalMngbcd.exceptionHandler;

public class MedicalRecordNotFoundException extends RuntimeException {
    public MedicalRecordNotFoundException(String message){
        super(message);
    }

}
