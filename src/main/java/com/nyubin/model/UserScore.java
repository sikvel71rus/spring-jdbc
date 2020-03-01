package com.nyubin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("userscore")
public class UserScore {

    @Id
    private Long id;
    private Long userId;
    private Long userScore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserScore() {
        return userScore;
    }

    public void setUserScore(Long userScore) {
        this.userScore = userScore;
    }

    public UserScore() {
    }

    public UserScore(Long userScore) {
        this.userScore = userScore;
    }

    public UserScore(Long userId, Long userScore) {
        this.userId = userId;
        this.userScore = userScore;
    }
}
