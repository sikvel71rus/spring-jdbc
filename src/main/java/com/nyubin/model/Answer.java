package com.nyubin.model;

public class Answer {

    private Long id;
    private Long questionId;
    private String name;
    private String isRight;


    public Answer() {
    }

    public Answer(String name, String isRight) {
        this.name = name;
        this.isRight = isRight;
    }

    public Answer(Long questionId, String name, String isRight) {
        this.questionId = questionId;
        this.name = name;
        this.isRight = isRight;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsRight() {
        return isRight;
    }

    public void setIsRight(String isRight) {
        this.isRight = isRight;
    }
}
