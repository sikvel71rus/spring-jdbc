package com.nyubin.repository;

import com.nyubin.model.Question;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionDataRepo extends CrudRepository<Question, Long> {

    @Query("select id from questions")
    List<Long> findAllIds();

    @Query("select name from questions " +
            "where id = :id")
    String getQuestionNameById(@Param("id") Long id);
}
