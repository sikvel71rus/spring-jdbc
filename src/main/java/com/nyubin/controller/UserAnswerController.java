package com.nyubin.controller;

import com.nyubin.model.User;
import com.nyubin.model.UserAnswer;
import com.nyubin.model.UserAnswerResponse;
import com.nyubin.repository.UserAnswerRepo;
import com.nyubin.service.UserAnswerResponseService;
import com.nyubin.service.UserAnswerService;
import com.nyubin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserAnswerController {

    @Autowired
    private UserAnswerService userAnswerService;

    @Autowired
    private UserAnswerResponseService userAnswerResponseService;

    @GetMapping("/useranswers")
    List<UserAnswer> findAll(){
        return userAnswerService.findAll();
    }


    @GetMapping("/useranswers/{id}")
    Optional<UserAnswer> findById(@PathVariable Long id){
        return userAnswerService.findById(id);
    }
    //TODO Add check "id_question in questionIds"
    @PostMapping("/useranswers")
    @ResponseStatus(HttpStatus.CREATED)
    UserAnswer save(@RequestBody UserAnswer newUserAnswer, @AuthenticationPrincipal User user){
        //TODO удалить
        newUserAnswer.setUserId(user.getId());
        return userAnswerService.save(newUserAnswer, user);
    }


    @GetMapping("/useranswerresponse")
    List<UserAnswerResponse> getUserAnswersResponse(@AuthenticationPrincipal User user){
        return userAnswerResponseService.getUserAnswersResponse(user);
    }



}
//    int answer(@RequestBody Answer newAnswer){
//        return answerRepository.save(newAnswer);
//    }