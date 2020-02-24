package com.nyubin.repository;

import com.nyubin.model.QuestionData;
import org.springframework.data.repository.CrudRepository;

public interface QuestionDataRepo extends CrudRepository<QuestionData, Long> {
}
