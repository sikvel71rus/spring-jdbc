package com.nyubin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class UserStatisticServiceImpl implements UserStatisticService {

    @Autowired
    private UserAnswerService userAnswerService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserScoreService userScoreService;


    public String getUserStatistic(String name){
        Long userId = userService.findIdByUserName(name);

        Long CountRightQuestion = userAnswerService.countRightAnswersByUser(userId);

        Double percentageWithLargerScore = userScoreService.percentageWithLargerScore(CountRightQuestion);
        Double percentageWithLowerScore = userScoreService.percentageWithLowerScore(CountRightQuestion);

        String resultUserStatistic = "Правильных ответов у "+name+": "+CountRightQuestion+"\n"
                +"Процентов пользователей справилось с тестом лучше "+name+": "+percentageWithLargerScore+"\n"
                +"Процентов пользователей справилось с тестом хуже "+name+": "+percentageWithLowerScore;

        return resultUserStatistic;
    }
}
