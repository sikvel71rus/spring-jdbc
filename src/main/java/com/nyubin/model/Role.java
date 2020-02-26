package com.nyubin.model;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {


    @Id
    private long id;
    private String authorityName  = "USER";

    public Role() {
    }

    public Role(long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return authorityName;
    }
}
