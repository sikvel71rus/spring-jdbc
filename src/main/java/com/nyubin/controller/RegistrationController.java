package com.nyubin.controller;

import com.nyubin.model.User;
import com.nyubin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("registration")
    User getUser(){
        return new User();
    }


    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    String addUser(@RequestBody User user){
        return userService.addUser(user);
    }




}
