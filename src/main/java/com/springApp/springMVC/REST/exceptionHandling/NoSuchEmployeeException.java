package com.springApp.springMVC.REST.exceptionHandling;

public class NoSuchEmployeeException extends RuntimeException{

    public NoSuchEmployeeException(String message){
        super(message);
    }
}
