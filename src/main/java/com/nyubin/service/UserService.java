package com.nyubin.service;

import com.nyubin.model.User;
import com.nyubin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public String addUser(User user);
    public List<User> findAll();





}
