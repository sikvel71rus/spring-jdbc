package com.nyubin.service;

import com.nyubin.model.User;
import com.nyubin.model.UserScore;

public interface UserScoreService {
    /**
     *Получение числа пользователей, завершивших тестирование
     */
    Long countCompletedTesting();
    /**
     *Получение числа пользователей, ответивших верно на все вопросы тестирования
     */
    Long countCompletedAllQuestionRight();
    /**
     *Получение процента пользователей, ответивших лучше чем текущий пользователь,
     * определение текущего пользователя по id
     */
    Double percentageWithLargerScore(Long id);
    /**
     *Получение процента пользователей, ответивших лучше чем текущий пользователь,
     * определение текущего пользователя по id
     */
    Double percentageWithLowerScore(Long id);
    /**
     *Сохранение результатов пользователя
     */
    UserScore save(UserScore userScore);
    /**
     *Поиск результатов пользователя по id пользователя
     */
    Long findUserScoreByUserId(Long id);




}
