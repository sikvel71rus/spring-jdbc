package com.nyubin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralStatisticServiceImpl implements GeneralStatisticService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserScoreService userScoreService;

    public String getGeneralStatistic() {

        Long countUsers = userService.countUsers();

        Long countUsersCompletedTest = userScoreService.countCompletedTesting();

        Long countUsersCompletedAllQuestionRight = userScoreService.countCompletedAllQuestionRight();

        String resultStatistic = "Пользователей зарегистрированно :" + countUsers + "\n"
                + "Пользователей, закончивших тестирование:" + countUsersCompletedTest + "\n"
                + "Пользователей, ответивших на все вопросы правильно:" + countUsersCompletedAllQuestionRight;

        return resultStatistic;
    }
}
