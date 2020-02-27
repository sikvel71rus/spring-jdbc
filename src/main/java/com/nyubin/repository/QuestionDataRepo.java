package com.nyubin.repository;

import com.nyubin.model.QuestionData;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionDataRepo extends CrudRepository<QuestionData, Long> {

    @Query("select id from questions_data")
    List<Long> findAllIds();
}
