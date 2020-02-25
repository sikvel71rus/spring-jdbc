package com.nyubin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table("questions_data")
public class QuestionData {
    @Id
    private Long id;
    private String name;
    private Set<AnswerData> answerDataSet = new HashSet<>();
//    private QuestionType questionType;

    public QuestionData(){}

    public QuestionData(Long id, String name, Set<AnswerData> answerDataSet, QuestionType questionType) {
        this.id = id;
        this.name = name;
        this.answerDataSet = answerDataSet;
//        this.questionType = questionType;
    }

    public QuestionData(String name, Set<AnswerData> answerDataSet, QuestionType questionType) {
        this.name = name;
        this.answerDataSet = answerDataSet;
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

    public Set<AnswerData> getAnswerDataSet() {
        return answerDataSet;
    }

    public void setAnswerDataSet(Set<AnswerData> answerDataSet) {
        this.answerDataSet = answerDataSet;
    }

//    public QuestionType getQuestionType() {
//        return questionType;
//    }
//
//    public void setQuestionType(QuestionType questionType) {
//        this.questionType = questionType;
//    }
}
