package com.nyubin.repository;

import com.nyubin.model.UserAnswer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserAnswerRepo extends CrudRepository<UserAnswer,Long> {

    @Query("select question_id from user_answer " +
            "where user_id = :id")
    List<Long> findAllQuestionIdsbyUser(@Param("id") Long id);

}
