package com.example.HospitalMngbcd.exceptionHandler;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
