package com.nyubin.exctractor;

import com.nyubin.mapper.AnswerRowMapper;
import com.nyubin.mapper.QuestionRowMapper;
import com.nyubin.model.Answer;
import com.nyubin.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class QuestionSetExtractor implements ResultSetExtractor<List<Question>> {

    @Autowired
    private QuestionRowMapper questionRowMapper;

    @Autowired
    private AnswerRowMapper answerRowMapper;


    @Override
    public List<Question> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Question> questions = new ArrayList<>();
        Long id =null;
        Question currentQuestion = null;
        int questionIdx = 0;
        int answerIdx = 0;
        while(resultSet.next()){
            if (currentQuestion == null || id.equals(resultSet.getLong("question_id"))){
                id = resultSet.getLong("id");
                currentQuestion = questionRowMapper.mapRow(resultSet,questionIdx++);
                answerIdx = 0;
                questions.add(currentQuestion);
            }
            currentQuestion.getAnswerList().add(answerRowMapper.mapRow(resultSet, answerIdx++));
        }

        return questions;
    }
}

