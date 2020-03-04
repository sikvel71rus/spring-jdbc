package com.nyubin.error;

public class UserAnswerNotFoundException extends RuntimeException {
    public UserAnswerNotFoundException() {
        super("UserAnswer not found");
    }
}
