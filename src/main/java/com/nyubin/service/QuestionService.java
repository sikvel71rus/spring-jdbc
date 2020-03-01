package com.nyubin.service;

import com.nyubin.model.QuestionData;
import com.nyubin.model.User;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<QuestionData> findAll();

    Optional<QuestionData> findById(Long id);

    QuestionData save(QuestionData questionData);

    public Optional<QuestionData> findRandomQuestion(User user);


}
