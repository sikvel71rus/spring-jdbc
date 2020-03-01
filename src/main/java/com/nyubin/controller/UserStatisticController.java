package com.nyubin.controller;

import com.nyubin.model.UserAnswer;
import com.nyubin.model.UserScore;
import com.nyubin.service.UserAnswerService;
import com.nyubin.service.UserScoreService;
import com.nyubin.service.UserService;
import com.nyubin.service.UserStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserStatisticController {

    @Autowired
    private UserStatisticService userStatisticService;

    @GetMapping("/userStatistic/{name}")
    public String getUserStatistic(@PathVariable String name){
        return userStatisticService.getUserStatistic(name);
    }

}
