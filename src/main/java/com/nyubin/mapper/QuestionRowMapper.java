package com.nyubin.mapper;

import com.nyubin.model.Question;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuestionRowMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet resultSet, int i) throws SQLException {

        return new Question(
                resultSet.getLong("id"),
                resultSet.getString("name"));
    }
}
