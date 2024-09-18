package com.example.HospitalMngbcd.exceptionHandler;


public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(String message){
        super(message);
    }

}

