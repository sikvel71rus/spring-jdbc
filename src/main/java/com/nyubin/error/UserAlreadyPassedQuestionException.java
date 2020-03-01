package com.nyubin.error;

public class UserAlreadyPassedQuestionException extends RuntimeException {
    public UserAlreadyPassedQuestionException(){
        super("User already passed this question");
    }
}
