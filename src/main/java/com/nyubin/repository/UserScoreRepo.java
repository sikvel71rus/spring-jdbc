package com.nyubin.repository;

import com.nyubin.model.UserScore;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserScoreRepo extends CrudRepository<UserScore,Long> {

    @Query("select count(*) from user_scores " +
            "where user_score = 5")
    Long countCompletedAllQuestionRight();

    @Query("select user_score from user_scores where user_id = :id")
    Long findUserScoreByUserId(@Param("id") Long id);

    @Query("select count(*) from user_scores " +
            "where user_score < :inUserscore")
    Long findCountWithLowerUserScore(@Param("inUserscore") Long userscore);

    @Query("select count(*) from user_scores " +
            "where user_score > :inUserscore")
    Long findCountWithLargerUserScore(@Param("inUserscore") Long userscore);
}
