package com.nyubin.controller;

import com.nyubin.service.UserStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserStatisticController {

    @Autowired
    private UserStatisticService userStatisticService;

    @GetMapping("/userStatistic")
    public String getUserStatistic(@RequestParam String name) {
        return userStatisticService.getUserStatistic(name);
    }

}
