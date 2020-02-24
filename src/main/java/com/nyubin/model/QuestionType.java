package com.nyubin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("question_type")
public class QuestionType {

    @Id
    private Long id;
    private String name;

    public QuestionType() {
    }

    public QuestionType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public QuestionType(String name) {
        this.name = name;
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
}
