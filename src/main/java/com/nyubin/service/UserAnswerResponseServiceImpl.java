package com.nyubin.service;

import com.nyubin.model.User;
import com.nyubin.model.UserAnswer;
import com.nyubin.model.UserAnswerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAnswerResponseServiceImpl implements UserAnswerResponseService {

    @Autowired
    private UserAnswerService userAnswerService;

    @Autowired
    private QuestionService questionService;

    public List<UserAnswerResponse> getUserAnswersResponse(User user) {

        Long userId = user.getId();

        List<UserAnswer> allAnswerDataByUser = userAnswerService.findAllAnswerDataByUser(userId);

        List<UserAnswerResponse> userAnswerResponses = new ArrayList<>();

        for (UserAnswer userAnswer : userAnswerService.findAllAnswerDataByUser(userId)
        ) {
            userAnswerResponses.add(new UserAnswerResponse(questionService.getQuestionNameById(userAnswer.getQuestionId()),
                    userAnswer.getUserAnswer(), userAnswer.getRight()));
        }

        return userAnswerResponses;
    }
}
