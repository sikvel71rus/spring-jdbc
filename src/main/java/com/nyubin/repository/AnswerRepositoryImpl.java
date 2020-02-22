package com.nyubin.repository;

import com.nyubin.mapper.AnswerRowMapper;
import com.nyubin.model.Answer;
import com.nyubin.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Answer answer) {
        return jdbcTemplate.update(
                "insert into answers (name, question_id, is_true) values(?,?,?)",
                answer.getName(),answer.getQuestionId(),answer.getIsRight());
    }

//    @Override
//    public List<Answer> getByQuestionId(Long id) {
//        return jdbcTemplate.query(
//                "select * from answers where id = ?",
//                new Object[]{id},
//                        new AnswerRowMapper());
//    }


    @Override
    public List<Answer> getByQuestionId(Long id) {
//        return jdbcTemplate.query(
//                "select * from answers where id = ?",
//                new Object[]{id},
//                i -> new AnswerRowMapper());
        return null;
    }




    @Override
    public List<Answer> findAll() {
        return jdbcTemplate.query(
                "select * from answers",
                new AnswerRowMapper());
    }
}

