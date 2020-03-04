package com.nyubin.service;

import com.nyubin.model.Question;
import com.nyubin.model.User;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    /**
     * Получение списка из всех вопросов и ответов в системе
     */
    List<Question> findAll();
    /**
     * Поиск вопроса по id вопроса
     */
    Optional<Question> findById(Long id);
    /**
     * Сохранение вопроса с ответаи на него в бд
     */
    Question save(Question question);
    /**
     * Получение случайного вопроса из списка вопросов в системе,
     * на которые пользователь ещё не отвечал
     */
    Optional<Question> findRandomQuestion(User user);
    /**
     * Получение наиментования вопроса по id вопроса
     */
    String getQuestionNameById(Long id);


}
