package com.nyubin.error;

public class WrongQuestionCompilationException extends RuntimeException {
    public WrongQuestionCompilationException(){
        super("Question need have 1 right answer or 4 different answers (3 false answers and 1 true answer)");
    }
}
