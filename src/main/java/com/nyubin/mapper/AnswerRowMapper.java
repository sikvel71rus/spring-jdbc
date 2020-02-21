package com.nyubin.mapper;

import com.nyubin.model.Answer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerRowMapper implements RowMapper<Answer> {
    @Override
    public Answer mapRow(ResultSet resultSet, int i) throws SQLException {

        Answer answer = new Answer();

        answer.setId(resultSet.getLong("id"));
        answer.setName(resultSet.getString("name"));
        answer.setQuestionId(resultSet.getLong("question_id"));
        answer.setIsRight(resultSet.getBoolean("is_true"));

        return answer;
    }
}
