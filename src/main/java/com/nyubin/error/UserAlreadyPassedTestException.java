package com.nyubin.error;

public class UserAlreadyPassedTestException extends RuntimeException {
    public UserAlreadyPassedTestException(){
        super("User already passed test");
    }
}
