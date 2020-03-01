package com.nyubin.error;

public class WrongQuestionCompilationException extends RuntimeException {
    public WrongQuestionCompilationException(){
        super("Question need have 1 right answer or 3 false answers and 1 tru answer");
    }
}
