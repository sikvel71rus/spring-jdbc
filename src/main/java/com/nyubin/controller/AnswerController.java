package com.nyubin.controller;


import com.nyubin.model.Answer;
import com.nyubin.model.Question;
import com.nyubin.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    //Save
    @PostMapping("/answers")
    @ResponseStatus(HttpStatus.CREATED)
    int answer(@RequestBody Answer newAnswer){
        return answerRepository.save(newAnswer);
    }

    //Find
    @GetMapping("/answers")
    List<Answer> findAll(){
        return answerRepository.findAll();
    }

}
