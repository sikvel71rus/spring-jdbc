package com.nyubin.controller;

import com.nyubin.model.User;
import com.nyubin.repository.UserRepo;
import com.nyubin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    List<User> findAll(){
        return userService.findAll();
    }

}
