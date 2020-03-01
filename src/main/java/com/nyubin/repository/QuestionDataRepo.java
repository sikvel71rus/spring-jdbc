package com.nyubin.repository;

import com.nyubin.model.QuestionData;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionDataRepo extends CrudRepository<QuestionData, Long> {

    @Query("select id from questions_data")
    List<Long> findAllIds();

    @Query("select name from questions_data " +
            "where id = :id")
    String getQuestionNameById(@Param("id") Long id);
}
