package com.nyubin.controller;

import com.nyubin.model.UserAnswer;
import com.nyubin.repository.UserAnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAnswerController {

    @Autowired
    private UserAnswerRepo userAnswerRepo;

    @GetMapping("/useranswers")
    List<UserAnswer> findAll(){
        Iterable<UserAnswer> all = userAnswerRepo.findAll();
        List<UserAnswer> all1 = (List<UserAnswer>) userAnswerRepo.findAll();

        return (List<UserAnswer>) userAnswerRepo.findAll();
    }


}
