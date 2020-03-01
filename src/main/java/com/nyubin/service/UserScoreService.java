package com.nyubin.service;

import com.nyubin.model.User;
import com.nyubin.model.UserScore;

public interface UserScoreService {

    Long countComplitedTesting();

    Long countComplitedAllQuestionRight();

    Double percentageWithLargerScore(Long id);

    Double percentageWithLowerScore(Long id);

    Long count();

    UserScore save(UserScore userScore);

    Long findUserScoreByUserId(Long id);




}
