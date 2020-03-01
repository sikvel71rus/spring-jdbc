package com.nyubin.service;

import com.nyubin.model.User;
import com.nyubin.model.UserScore;

public interface UserScoreService {

    public Long countComplitedTesting();
    public Long countComplitedAllquestionRight();
    public Double percentageWithLargerScore(Long id);
    public Double percentageWithLowerScore(Long id);
    public Long count();
    public UserScore save(UserScore userScore);




}
