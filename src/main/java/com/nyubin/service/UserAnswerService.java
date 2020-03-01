package com.nyubin.service;

import com.nyubin.model.User;
import com.nyubin.model.UserAnswer;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface UserAnswerService {

    List<UserAnswer> findAll();

    Optional<UserAnswer> findById(Long id);

    UserAnswer save(UserAnswer newUserAnswer, User user);

    List<Long> findAllQuestionIdsByUser(Long id);

    Long countRightAnswersByUser(Long id);

    List<UserAnswer> findAllAnswerDataByUser(Long id);


}
