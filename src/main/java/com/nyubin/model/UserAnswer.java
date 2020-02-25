package com.nyubin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table("user_answer")
public class UserAnswer {

    @Id
    private Long id;
    private Set<UserRef> users = new HashSet<>();
//    private UserRef users;
    private Set<QuestionRef> questions = new HashSet<>();
    private String userAnswer;
    private Boolean isRight;
    private Long userId;
    private Long questionId;

    public UserAnswer() {
    }


    public UserAnswer(Long id, Set<UserRef> users, Set<QuestionRef> questions, String userAnswer, Boolean isRight, Long userId, Long questionId) {
        this.id = id;
        this.users = users;
        this.questions = questions;
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

    public Set<UserRef> getUsers() {
        return users;
    }

    public void setUsers(Set<UserRef> users) {
        this.users = users;
    }

//    public UserRef getUsers() {
//        return users;
//    }
//
//    public void setUsers(UserRef users) {
//        this.users = users;
//    }


//    public QuestionData getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(QuestionData question) {
//        this.question = question;
//    }

    public Boolean getRight() {
        return isRight;
    }

    public void setRight(Boolean right) {
        isRight = right;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public Set<QuestionRef> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionRef> questions) {
        this.questions = questions;
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

    public void addUserRef(User user){
        this.users.add(new UserRef(user.getId()));
    }
//    public void addUserRef(User user){
//        this.users = new UserRef(user.getId());
//    }


    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void addUser(User user){
        this.userId = user.getId();
    }

    public void addQuestionRef(QuestionData questionData){
        this.questions.add(new QuestionRef(questionData.getId()));
    }
    public void addQuestion(QuestionData questionData){
        this.questionId = questionData.getId();
    }

}
