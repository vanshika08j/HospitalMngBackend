package com.example.HospitalMngbcd.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<String> handleDoctorNotFoundException(PatientNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<String> handleAppointmentNotFoundException(PatientNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<String> handleDepartmentNotFoundException(PatientNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MedicalRecordNotFoundException.class)
    public ResponseEntity<String> handleMedicalNotFoundException(PatientNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(PatientNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException ex,WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(OperationFailedException.class)
    public ResponseEntity<?> handleOperationFailedException(OperationFailedException ex,WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex,WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}


