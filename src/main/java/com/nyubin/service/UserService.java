package com.nyubin.service;

import com.nyubin.model.User;
import com.nyubin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService extends UserDetailsService {

    public String addUser(User user);
    public List<User> findAll();
    public UserDetails loadUserByUsername(String var1) throws UsernameNotFoundException;





}
