package com.nyubin.error;


//TODO проверить зачем я это сделал????
public class  UserScoreUnAvailableException extends RuntimeException {
    public UserScoreUnAvailableException() {
        super("Userstatistic not avalible, ");
    }
}
