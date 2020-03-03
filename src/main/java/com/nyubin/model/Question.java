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
//    private QuestionType questionType;

    public Question(){}

    public Question(Long id, String name, Set<Answer> answerSet, QuestionType questionType) {
        this.id = id;
        this.name = name;
        this.answerSet = answerSet;
//        this.questionType = questionType;
    }

    public Question(String name, Set<Answer> answerSet, QuestionType questionType) {
        this.name = name;
        this.answerSet = answerSet;
//        this.questionType = questionType;
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

//    public QuestionType getQuestionType() {
//        return questionType;
//    }
//
//    public void setQuestionType(QuestionType questionType) {
//        this.questionType = questionType;
//    }
}
