package com.nyubin.controller;

import com.nyubin.model.UserAnswer;
import com.nyubin.repository.UserAnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserAnswerController {

    @Autowired
    private UserAnswerRepo userAnswerRepo;

    @GetMapping("/useranswers")
    List<UserAnswer> findAll(){
        return (List<UserAnswer>) userAnswerRepo.findAll();
    }

    @GetMapping("/useranswers/{id}")
    Optional<UserAnswer> findById(@PathVariable Long id){
        return userAnswerRepo.findById(id);
    }

    @PostMapping("/useranswers")
    @ResponseStatus(HttpStatus.CREATED)
    UserAnswer answer(@RequestBody UserAnswer newUserAnswer){
        return userAnswerRepo.save(newUserAnswer);
    }


}
//    int answer(@RequestBody Answer newAnswer){
//        return answerRepository.save(newAnswer);
//    }