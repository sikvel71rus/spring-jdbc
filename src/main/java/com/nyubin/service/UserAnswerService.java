package com.nyubin.service;

import com.nyubin.model.User;
import com.nyubin.model.UserAnswer;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface UserAnswerService {
    /**
     *Получение всех ответов пользователя
     */
    List<UserAnswer> findAll();
    /**
     *Получение ответа пользователя по id ответа пользователя
     */
    Optional<UserAnswer> findById(Long id);
    /**
     *Сохранение ответа пользователя
     */
    UserAnswer save(UserAnswer newUserAnswer, User user);
    /**
     *Получение списка id всех вопросов, на которые ответил пользователь
     */
    List<Long> findAllQuestionIdsByUser(Long id);
    /**
     *Получение числа правильных ответов по id пользователя
     */
    Long countRightAnswersByUser(Long id);
    /**
     *Получение всех ответов пользователя по id пользователя
     */
    List<UserAnswer> findAllAnswerByUser(Long id);


}
