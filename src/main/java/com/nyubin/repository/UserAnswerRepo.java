package com.nyubin.repository;

import com.nyubin.model.UserAnswer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserAnswerRepo extends CrudRepository<UserAnswer,Long> {

    @Query("select question_id from user_answers " +
            "where user_id = :id")
    List<Long> findAllQuestionIdsByUser(@Param("id") Long id);

    @Query("select * from user_answers " +
            "where user_id = :id")
    List<UserAnswer> findAllUserAnswersByUser(@Param("id") Long id);


    @Query("select count(*) from user_answers " +
            "where user_id = :id")
    Long countAnswersByUser(@Param("id") Long id);

    @Query("select count(*) from user_answers " +
            "where user_id = :id and is_right = 1")
    Long countRightAnswersByUser(@Param("id") Long id);

}
