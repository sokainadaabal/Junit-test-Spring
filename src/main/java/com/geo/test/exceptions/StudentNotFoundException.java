package com.geo.test.exceptions;


public class StudentNotFoundException extends Exception{

    public StudentNotFoundException(){
         super("Student Not Found");
     }

    public StudentNotFoundException(String message){
        super(message);
    }

    // Constructor with message adn cause

    public StudentNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

    // Constructor with cause
    public StudentNotFoundException(Throwable cause){
        super(cause);
    }
}
