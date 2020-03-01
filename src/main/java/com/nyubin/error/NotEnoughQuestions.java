package com.nyubin.error;

public class NotEnoughQuestions extends RuntimeException {
    public NotEnoughQuestions(){super("Questions less than 5");}
}
