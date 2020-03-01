package com.nyubin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class GeneralStatisticServiceImpl implements GeneralStatisticService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserScoreService userScoreService;

    public String getGeneralStatisric(Long id) {

        Long countUsers = userService.countUsers();

        Long countUsersComplitedTest = userScoreService.count();

        Long countUsersComplitedAllQuestionRight = userScoreService.countComplitedAllquestionRight();

        String resultStatistic = "Пользователей зарегистрированно :" + countUsers + "\n"
                + "Пользователей, закончивших тестирование:" + countUsersComplitedTest + "\n"
                + "Пользователей, ответивших на все вопросы правильно:" + countUsersComplitedAllQuestionRight;

        return resultStatistic;
    }
}
