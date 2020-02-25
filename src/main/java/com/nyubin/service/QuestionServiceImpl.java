package com.nyubin.service;

import com.nyubin.model.AnswerData;
import com.nyubin.model.QuestionData;
import com.nyubin.repository.QuestionDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDataRepo questionDataRepo;


    @Override
    public List<QuestionData> findAll() {
        return (List<QuestionData>) questionDataRepo.findAll();
    }

    @Override
    public Optional<QuestionData> findById(Long id) {
        return questionDataRepo.findById(id);
    }

    @Override
    public QuestionData save(QuestionData questionData) {

        if (questionDataRepo.count() >= 5) {
            System.out.println("Всё плохо");
        }

        Set<AnswerData> answerDataSet = questionData.getAnswerDataSet();

        if (answerDataSet.size() == 0 || answerDataSet.size() > 4) {
            System.out.println("Всё плохо");
        }

        if (answerDataSet.size() == 1 &&
                !(Boolean.TRUE).equals(answerDataSet.stream().findFirst().get().isRight())) {
            System.out.println("Всё плохо");
        }

        int trueAnswersCount = 0;

        for (AnswerData answerData : questionData.getAnswerDataSet()
        ) {
            if ((Boolean.TRUE).equals(answerData.isRight())){
                trueAnswersCount++;
            }
        }
        if (trueAnswersCount !=1){
            System.out.println("Всё плохо");
        }

        return questionDataRepo.save(questionData);
    }
}
