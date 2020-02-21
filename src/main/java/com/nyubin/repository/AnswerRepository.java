package com.nyubin.repository;

import com.nyubin.model.Answer;
import com.nyubin.model.Question;

import java.util.List;

public interface AnswerRepository {

    int save(Answer answer);

    List<Answer> getByQuestionId();
}
