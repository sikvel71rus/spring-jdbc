package com.nyubin.service;

import com.nyubin.model.User;
import com.nyubin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    public String addUser(User user){
        User userFromDb = userRepo.findByUsername(user.getUserName());

        if(userFromDb != null){
        return "User exist";
        }
        userRepo.save(user);
        return "User added";

    }

    public List<User> findAll(){
        return (List<User>) userRepo.findAll();
    }




}
