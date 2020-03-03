package com.nyubin.service;

import com.nyubin.error.QuestionNotFoundException;
import com.nyubin.error.UserAlreadyPassedQuestionException;
import com.nyubin.error.UserAlreadyPassedTestException;
import com.nyubin.model.*;
import com.nyubin.repository.QuestionDataRepo;
import com.nyubin.repository.UserAnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    @Autowired
    private UserAnswerRepo userAnswerRepo;

    @Autowired
    private QuestionDataRepo questionDataRepo;

    @Autowired
    private UserScoreService userScoreService;


    @Override
    public List<UserAnswer> findAll() {
        return (List<UserAnswer>) userAnswerRepo.findAll();
    }

    @Override
    public Optional<UserAnswer> findById(Long id) {
        Optional<UserAnswer> userAnswer = userAnswerRepo.findById(id);

        //TODO Check
        if (userAnswer == null) {
            throw new QuestionNotFoundException();
        }

        return userAnswerRepo.findById(id);
    }

    @Override
    public UserAnswer save(UserAnswer newUserAnswer, User user) {

        newUserAnswer.setUserId(user.getId());

        if (userScoreService.findUserScoreByUserId(user.getId()) != null) {
            throw new UserAlreadyPassedTestException();
        }


        if (!questionDataRepo.findAllIds().contains(newUserAnswer.getQuestionId())) {
            throw new QuestionNotFoundException();
        }

        if (findAllQuestionIdsByUser(user.getId()).contains(newUserAnswer.getQuestionId())) {
            throw new UserAlreadyPassedQuestionException();
        }

        Optional<Question> byId = questionDataRepo.findById(newUserAnswer.getQuestionId());

        for (Answer answer : byId.get().getAnswerSet()
        ) {
            if (Boolean.TRUE.equals(answer.isRight())) {
                if (newUserAnswer.getUserAnswer().toLowerCase().equals(answer.getName())) {
                    newUserAnswer.setRight(Boolean.TRUE);
                } else {
                    newUserAnswer.setRight(Boolean.FALSE);
                }
            }
        }

        if (userAnswerRepo.countAnswersByUser(user.getId()) == 4) {
            Long countRightAnswer = countRightAnswersByUser(user.getId());
            if (Boolean.TRUE.equals(newUserAnswer.getRight())) {
                countRightAnswer++;
            }
            UserScore userScore = new UserScore();
            userScore.setUserId(user.getId());
            userScore.setUserScore(countRightAnswer);
            userScoreService.save(userScore);
        }

        return userAnswerRepo.save(newUserAnswer);
    }

    public List<Long> findAllQuestionIdsByUser(Long id) {
        return userAnswerRepo.findAllQuestionIdsByUser(id);
    }

    public Long countRightAnswersByUser(Long id) {
        return userAnswerRepo.countRightAnswersByUser(id);
    }

    public List<UserAnswer> findAllAnswerDataByUser(Long id) {

        return userAnswerRepo.findAllUserAnswersByUser(id);
    }


}


