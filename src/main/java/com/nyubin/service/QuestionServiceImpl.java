package com.nyubin.service;

import com.nyubin.model.AnswerData;
import com.nyubin.model.QuestionData;
import com.nyubin.model.User;
import com.nyubin.repository.QuestionDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDataRepo questionDataRepo;

    @Autowired
    private UserAnswerService userAnswerService;


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

//        if (questionDataRepo.count() < 5) {
//            System.out.println("Всё плохо");
//        }

        Set<AnswerData> answerDataSet = questionData.getAnswerDataSet();

        //TODO убрать костылец
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

    public Optional<QuestionData> findRandomQuestion(User user){

        Long userId = user.getId();

        List<Long> allIds = questionDataRepo.findAllIds();

        List<Long> allQuestionIdsbyUser = userAnswerService.findAllQuestionIdsByUser(userId);

        if(allQuestionIdsbyUser != null) {
            for (Long questionId : allQuestionIdsbyUser
            ) {
                if (allIds.contains(questionId)) {
                    allIds.remove(questionId);
                }
            }
        }
        int maxIndex = allIds.size() -1;

        int questionIndex = (int)(Math.random() * ++maxIndex);

        return deleteAnswersFromQuestion(questionDataRepo.findById(allIds.get(questionIndex)));
    }

    @Override
    public String getQuestionNameById(Long id) {
        return questionDataRepo.getQuestionNameById(id);
    }


    private Optional<QuestionData> deleteAnswersFromQuestion(Optional<QuestionData> questionData){



        if (questionData.get().getAnswerDataSet().size() == 1){
            questionData.get().setAnswerDataSet(null);
        }else{
            for (AnswerData answerData:questionData.get().getAnswerDataSet()
                 ) {
                answerData.setRight(false);
            }
        }
        return questionData;
    }
}
