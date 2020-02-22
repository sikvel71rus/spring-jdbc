package com.nyubin.mapper;

import com.nyubin.model.Question;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRowMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet resultSet, int i) throws SQLException {

        return new Question(
                resultSet.getLong("id"),
                resultSet.getString("name"));
    }
}
