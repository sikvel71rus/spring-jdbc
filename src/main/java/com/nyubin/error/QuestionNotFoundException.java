package com.nyubin.error;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(){super("Question not found");}
}
