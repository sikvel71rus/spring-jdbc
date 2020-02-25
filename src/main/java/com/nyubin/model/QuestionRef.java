package com.nyubin.model;

import org.springframework.data.relational.core.mapping.Table;

@Table("question_answer")
public class QuestionRef {
    private Long question;

    public QuestionRef(Long question) {
        this.question = question;
    }
}
