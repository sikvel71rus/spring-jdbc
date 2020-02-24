package com.nyubin.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Question {

    private Long id;
    private String name;
    private List<Answer> answerList = new ArrayList<>();

    public Question(){}

    public Question(String name) {
        this.name = name;
    }

    public Question(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Question(String name, List<Answer> answerList) {
        this.name = name;
        this.answerList = answerList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }
//
//    public void setAnswerList(List<Answer> answerList) {
//        this.answerList = answerList;
//    }
}
