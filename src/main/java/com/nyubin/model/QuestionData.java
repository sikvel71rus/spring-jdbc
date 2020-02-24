package com.nyubin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("questions_data")
public class QuestionData {
    @Id
    private Long id;
    private String name;
    private String answer;
    private Set<AnswerData> answerDataSet;

    public QuestionData(){}

    public QuestionData(Long id, String name, String answer, Set<AnswerData> answerDataSet) {
        this.id = id;
        this.name = name;
        this.answer = answer;
        this.answerDataSet = answerDataSet;
    }

    public QuestionData(String name, String answer, Set<AnswerData> answerDataSet) {
        this.name = name;
        this.answer = answer;
        this.answerDataSet = answerDataSet;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Set<AnswerData> getAnswerDataSet() {
        return answerDataSet;
    }

    public void setAnswerDataSet(Set<AnswerData> answerDataSet) {
        this.answerDataSet = answerDataSet;
    }

}
