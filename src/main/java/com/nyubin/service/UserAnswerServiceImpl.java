package com.nyubin.service;

import com.nyubin.model.User;
import com.nyubin.model.UserAnswer;
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

    @Override
    public List<UserAnswer> findAll() {
        return (List<UserAnswer>) userAnswerRepo.findAll();
    }

    @Override
    public Optional<UserAnswer> findById(Long id) {
        return userAnswerRepo.findById(id);
    }

    @Override
    public UserAnswer save(UserAnswer newUserAnswer, User user) {
        newUserAnswer.setUserId(user.getId());

        //TODO нужна ли эта проверка

//        if(questionDataRepo.findAllIds().contains(newUserAnswer.getId())){
//
//        }

        return userAnswerRepo.save(newUserAnswer);

    }

}


