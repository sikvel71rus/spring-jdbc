package com.nyubin.repository;

import com.nyubin.mapper.QuestionRowMapper;
import com.nyubin.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from questions", Integer.class);
    }

    @Override
    public int save(Question question) {
        return jdbcTemplate.update(
                "insert into questions (name) values(?)",
                question.getName());
    }

    @Override
    public List<Question> findAll() {
        return jdbcTemplate.query(
                "select * from questions",
                (rs, rowNum) ->
                        new Question(
                                rs.getLong("id"),
                                rs.getString("name")
                        )
        );
    }

    @Override
    public List<Question> findAll2() {
        return jdbcTemplate.query(
                "select * from questions",
                new QuestionRowMapper());
    }
}
