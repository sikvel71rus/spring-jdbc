package com.nyubin.repository;

import com.nyubin.model.Question;

import java.util.List;

public interface QuestionRepository {


    int count();

    int save(Question question);

    List<Question> findAll();

    List<Question> findAll2();

    List<Question> findAllQuestionsWithAnswers();

}
