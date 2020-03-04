package com.nyubin.controller;


import com.nyubin.model.Question;
import com.nyubin.model.User;
import com.nyubin.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    List<Question> findAll() {
        return questionService.findAll();
    }


    @GetMapping("/questions/{id}")
    Optional<Question> findById(@PathVariable Long id) {
        return questionService.findById(id);
    }

    @PostMapping("/questions")
    @ResponseStatus(HttpStatus.CREATED)
    Question save(@RequestBody Question question) {
        return questionService.save(question);
    }

    @GetMapping("/questions/random")
    Optional<Question> findRandomQuestion(@AuthenticationPrincipal User user) {
        return questionService.findRandomQuestion(user);
    }


}
