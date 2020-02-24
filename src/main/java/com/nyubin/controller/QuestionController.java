package com.nyubin.controller;


import com.nyubin.model.QuestionData;
import com.nyubin.repository.QuestionDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/questionsData")
    Iterable<QuestionData> findThetAll(){

    List<QuestionData> targetCollection = new ArrayList<>();
    for (QuestionData questionData:questionDataRepo.findAll()) {
        targetCollection.add(questionData);
    }
    return targetCollection;

    };

}
