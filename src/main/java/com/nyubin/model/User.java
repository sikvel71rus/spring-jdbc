package com.nyubin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class User {

    @Id
    private Long id;
    private String userName;
    private String password;
    private Float userScore;


    public User() {
    }

    public User(Long id, String userName, String password, Float userScore) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userScore = userScore;
    }

    public User(String userName, String password, Float userScore) {
        this.userName = userName;
        this.password = password;
        this.userScore = userScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getUserScore() {
        return userScore;
    }

    public void setUserScore(Float userScore) {
        this.userScore = userScore;
    }
}
