package com.nyubin.service;

import com.nyubin.error.UserNotFoundException;
import com.nyubin.model.Role;
import com.nyubin.model.User;
import com.nyubin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public String addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return "User exist";
        }

        user.getRoles().add(new Role());
        userRepo.save(user);
        return "User added";

    }

    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepo.findByUsername(userName);
    }

    public Long countUsers() {
        return userRepo.count();
    }

    public Long findIdByUserName(String name) {

        Long userId = userRepo.findIdByUserName(name);
        if (userId == null) {
            throw new UserNotFoundException();
        }
        return userId;
    }

}
