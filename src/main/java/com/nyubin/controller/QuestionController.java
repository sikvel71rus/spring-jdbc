package com.nyubin.controller;


import com.nyubin.model.QuestionData;
import com.nyubin.repository.QuestionDataRepo;
import com.nyubin.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;
//
//    //Find
//    @GetMapping("/questions")
//    List<Question> findAll(){
//        return questionRepository.findAllQuestionsWithAnswers();
//    }
//
//    //Save
//    @PostMapping("/questions")
//    @ResponseStatus(HttpStatus.CREATED)
//    int question(@RequestBody Question question){
//        return questionRepository.save(question);
//    }

    @GetMapping("/questions")
    List<QuestionData> findAll(){
        return questionService.findAll();
    }


    @GetMapping("/questions/{id}")
    Optional<QuestionData> findById(@PathVariable Long id){
        return questionService.findById(id);
    }

    @PostMapping("/questions")
    @ResponseStatus(HttpStatus.CREATED)
    QuestionData save(@RequestBody QuestionData questionData){
        return questionService.save(questionData);
    }



}
