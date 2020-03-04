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
    /**
     *Добавить пользователя
     */
    String addUser(User user);
    /**
     *Получение списка всех пользователей
     */
    List<User> findAll();
//TODO check
//    UserDetails loadUserByUsername(String var1) throws UsernameNotFoundException;
    /**
     *Получение количества пользователей, зарегистрированных в системе
     */
    Long countUsers();
    /**
     *Получение id пользователя по имени пользователя
     */
    Long findIdByUserName(String name);




}
