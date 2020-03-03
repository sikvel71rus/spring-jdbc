package com.nyubin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table("questions")
public class Question {
    @Id
    private Long id;
    private String name;
    private Set<Answer> answerSet = new HashSet<>();

    public Question(){}

    public Question(Long id, String name, Set<Answer> answerSet) {
        this.id = id;
        this.name = name;
        this.answerSet = answerSet;
    }

    public Question(String name, Set<Answer> answerSet) {
        this.name = name;
        this.answerSet = answerSet;
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

    public Set<Answer> getAnswerSet() {
        return answerSet;
    }

    public void setAnswerSet(Set<Answer> answerSet) {
        this.answerSet = answerSet;
    }

}
