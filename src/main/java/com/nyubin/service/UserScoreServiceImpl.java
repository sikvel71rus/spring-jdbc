package com.nyubin.service;

import com.nyubin.model.UserScore;
import com.nyubin.repository.UserScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
public class UserScoreServiceImpl implements UserScoreService {

    @Autowired
    private UserScoreRepo userScoreRepo;

    public Long countCompletedTesting() {
        return userScoreRepo.count();
    }

    @Override
    public Long countCompletedAllQuestionRight() {
        return userScoreRepo.countCompletedAllQuestionRight();
    }

    public Long findUserScoreByUserId(Long id) {
        return userScoreRepo.findUserScoreByUserId(id);
    }

    public Double percentageWithLargerScore(Long id) {

        Long countWithLargerUserScore = userScoreRepo.findCountWithLargerUserScore(id);
        long count = userScoreRepo.count();
        if (count == 0){
            return Double.valueOf(0);
        }

        return roundDoubleValue(((double)countWithLargerUserScore / (double)count) * 100);

    }
    public Double percentageWithLowerScore(Long id) {

        Long countWithLargerUserScore = userScoreRepo.findCountWithLowerUserScore(id);

        long count = userScoreRepo.count();

        if (count == 0){
            return Double.valueOf(0);
        }

        return roundDoubleValue(((double)countWithLargerUserScore / (double)count) * 100);
    }

//    public Long count(){
//        return userScoreRepo.count();
//    }
    public UserScore save(UserScore userScore){
        return userScoreRepo.save(userScore);
    }



    private Double roundDoubleValue(Double doubleValue){
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return Double.valueOf(df.format(doubleValue));
    }


}
