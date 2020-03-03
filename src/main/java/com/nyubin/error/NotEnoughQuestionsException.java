package com.nyubin.error;

public class NotEnoughQuestionsException extends RuntimeException {
    public NotEnoughQuestionsException(){
        super("Number of questions less than 5");
    }
}
