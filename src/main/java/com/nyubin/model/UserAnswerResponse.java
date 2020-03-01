package com.nyubin.model;

public class UserAnswerResponse {
    private String questionName;
    private String userAnswerName;
    private Boolean isRight;

    public UserAnswerResponse() {
    }

    public UserAnswerResponse(String questionName, String userAnswerName, Boolean isRight) {
        this.questionName = questionName;
        this.userAnswerName = userAnswerName;
        this.isRight = isRight;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getUserAnswerName() {
        return userAnswerName;
    }

    public void setUserAnswerName(String userAnswerName) {
        this.userAnswerName = userAnswerName;
    }

    public Boolean getRight() {
        return isRight;
    }

    public void setRight(Boolean right) {
        isRight = right;
    }
}
