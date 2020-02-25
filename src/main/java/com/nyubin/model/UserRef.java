package com.nyubin.model;


import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Table("answer_user")
public class UserRef {
    private Long user;

    public UserRef(Long user) {
        this.user = user;
    }
}
