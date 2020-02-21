package com.nyubin.mapper;

import com.nyubin.model.Question;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRowMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet resultSet, int i) throws SQLException {

        Question question = new Question();
        question.setId(resultSet.getLong("id"));
        question.setName(resultSet.getString("name"));

        return question;
    }
}
