package com.nyubin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Table("users")
//TODO delete if unnecessary
public class User implements UserDetails {

    @Id
    private Long id;
    @Column("user_name")
    private String username;
    private String password;
    private Float userScore;

    private Role roles;


    public User() {
    }

    public User(Long id, String username, String password, Float userScore, Role roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userScore = userScore;
        this.roles = roles;
    }

    public User(String username, String password, Float userScore, Role roles) {
        this.username = username;
        this.password = password;
        this.userScore = userScore;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getUserScore() {
        return userScore;
    }

    public void setUserScore(Float userScore) {
        this.userScore = userScore;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }


    //TODO переделать костыль
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role());
        return roles;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
