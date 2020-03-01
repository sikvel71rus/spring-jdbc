package com.nyubin.service;

import com.nyubin.model.User;
import com.nyubin.model.UserAnswer;
import com.nyubin.model.UserScore;
import com.nyubin.repository.UserScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class UserScoreServiceImpl implements UserScoreService {

    @Autowired
    private UserScoreRepo userScoreRepo;

    public Long countComplitedTesting() {
        return userScoreRepo.count();
    }

    @Override
    public Long countComplitedAllquestionRight() {
        return userScoreRepo.countComplitedAllQuestionRight();
    }

    public Long countRightAnswers(User user) {
        return userScoreRepo.findUserScoreByUserId(user.getId());
    }

    public Double percentageWithLargerScore(Long id) {

//        Long countWithLargerUserScore = userScoreRepo.findCountWithLargerUserScore(user.getId());
        Long countWithLargerUserScore = userScoreRepo.findCountWithLargerUserScore(id);
        long count = userScoreRepo.count();

        return ((double)countWithLargerUserScore / (double)count) * 100;

    }
    public Double percentageWithLowerScore(Long id) {

//        Long countWithLargerUserScore = userScoreRepo.findCountWithLowerUserScore(user.getId());
        Long countWithLargerUserScore = userScoreRepo.findCountWithLowerUserScore(id);

        long count = userScoreRepo.count();


        return ((double)countWithLargerUserScore / (double)count) * 100;
    }

    public Long count(){
        return userScoreRepo.count();
    }
    public UserScore save(UserScore userScore){
        return userScoreRepo.save(userScore);
    }




//    public BigDecimal pessentegeWithLowerScore(User user) {
//        return BigDecimal.valueOf(userScoreRepo.findCountWithLowerUserScore(user.getId()))
//                .divide(getCount())
//                .multiply(BigDecimal.valueOf(100));
//    }

//    private Long getCount() {
//        return BigDecimal.valueOf(userScoreRepo.count());
//    }


}
