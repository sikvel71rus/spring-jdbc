package com.nyubin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("answers")
public class Answer {

    @Id
    private Long id;
    private String name;
    private boolean isRight;

    public Answer(){}

    public Answer(Long id, String name, Boolean isRight) {
        this.id = id;
        this.name = name;
        this.isRight = isRight;
    }

    public Answer(String name, Boolean isRight) {

        this.name = name;
        this.isRight = isRight;
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

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }
}
