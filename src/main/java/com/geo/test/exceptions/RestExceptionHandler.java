package com.geo.test.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity handleNoStudentFoundException(){
        ApiError error= new ApiError(400,"No StudentFound",new Date());
        return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
    }
}
