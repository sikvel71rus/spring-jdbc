package com.nyubin.service;

import com.nyubin.model.Question;
import com.nyubin.model.User;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> findAll();

    Optional<Question> findById(Long id);

    Question save(Question question);

    Optional<Question> findRandomQuestion(User user);

    String getQuestionNameById(Long id);


}
