package com.nyubin.controller;


import com.nyubin.model.Question;
import com.nyubin.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    //Find
    @GetMapping("/questions")
    List<Question> findAll(){
        return questionRepository.findAll2();
    }

    //Save
    @PostMapping("/questions")
    @ResponseStatus(HttpStatus.CREATED)
    int question(@RequestBody Question question){
        return questionRepository.save(question);
    }

}
