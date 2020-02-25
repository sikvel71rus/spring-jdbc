package com.nyubin.controller;


import com.nyubin.model.QuestionData;
import com.nyubin.repository.QuestionDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

//    @Autowired
//    private QuestionRepository questionRepository;
//
    @Autowired
    private QuestionDataRepo questionDataRepo;
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
    List<QuestionData> findThetAll(){
    return (List<QuestionData>) questionDataRepo.findAll();
    }


    @GetMapping("/questions/{id}")
    Optional<QuestionData> getById(@PathVariable Long id){
        return questionDataRepo.findById(id);
    }

    @PostMapping("/questions")
    @ResponseStatus(HttpStatus.CREATED)
    QuestionData answer(@RequestBody QuestionData questionData){
        return questionDataRepo.save(questionData);
    }



}
