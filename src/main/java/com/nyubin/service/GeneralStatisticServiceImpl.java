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

        Long countUsersComplitedTest = userScoreService.count();

        Long countUsersComplitedAllQuestionRight = userScoreService.countComplitedAllQuestionRight();

        String resultStatistic = "Пользователей зарегистрированно :" + countUsers + "\n"
                + "Пользователей, закончивших тестирование:" + countUsersComplitedTest + "\n"
                + "Пользователей, ответивших на все вопросы правильно:" + countUsersComplitedAllQuestionRight;

        return resultStatistic;
    }
}
