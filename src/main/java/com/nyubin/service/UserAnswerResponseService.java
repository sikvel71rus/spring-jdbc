package com.nyubin.service;

import com.nyubin.model.User;
import com.nyubin.model.UserAnswerResponse;

import java.util.List;

public interface UserAnswerResponseService {
    /**
     * Получение списка вопросов и ответов пользователя на эти вопросы,
     * с указанием верности ответа пользователя (в виде для отображения пользователю)
     */
    List<UserAnswerResponse> getUserAnswersResponse(User user);

}

