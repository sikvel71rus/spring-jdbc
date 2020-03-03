package com.nyubin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("user_answers")
public class UserAnswer {

    @Id
    private Long id;

    private String userAnswer;
    private Boolean isRight;
    private Long userId;
    private Long questionId;

    public UserAnswer() {
    }


    public UserAnswer(Long id, String userAnswer, Boolean isRight, Long userId, Long questionId) {
        this.id = id;
        this.userAnswer = userAnswer;
        this.isRight = isRight;
        this.userId = userId;
        this.questionId = questionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getRight() {
        return isRight;
    }

    public void setRight(Boolean right) {
        isRight = right;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void addUser(User user) {
        this.userId = user.getId();
    }

    public void addQuestion(Question question) {
        this.questionId = question.getId();
    }

}
