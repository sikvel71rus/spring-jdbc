package com.nyubin.service;

import com.nyubin.model.*;
import com.nyubin.repository.QuestionDataRepo;
import com.nyubin.repository.UserAnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    @Autowired
    private UserAnswerRepo userAnswerRepo;

    @Autowired
    private QuestionDataRepo questionDataRepo;

    @Autowired
    private UserScoreService userScoreService;


    @Override
    public List<UserAnswer> findAll() {
        return (List<UserAnswer>) userAnswerRepo.findAll();
    }

    @Override
    public Optional<UserAnswer> findById(Long id) {
        return userAnswerRepo.findById(id);
    }

    @Override
    public UserAnswer save(UserAnswer newUserAnswer, User user) {

        newUserAnswer.setUserId(user.getId());
        //TODO нужна ли эта проверка

        if(!questionDataRepo.findAllIds().contains(newUserAnswer.getQuestionId())){
            System.out.println("Всё плохо!");
        }
        //TODO обработать optional
        Optional<QuestionData> byId = questionDataRepo.findById(newUserAnswer.getQuestionId());

        for (AnswerData answerData:byId.get().getAnswerDataSet()
             ) {
            if (Boolean.TRUE.equals(answerData.isRight())){
                if (newUserAnswer.getUserAnswer().toLowerCase().equals(answerData.getName())){
                    newUserAnswer.setRight(Boolean.TRUE);
                }else{
                    newUserAnswer.setRight(Boolean.FALSE);
                }
            }
        }

        if (userAnswerRepo.countAnswersByUser(user.getId()) == 4){
            Long countRightAnswer =countRightAnswersByUser(user.getId());
            if (Boolean.TRUE.equals(newUserAnswer.getRight())){
                countRightAnswer++;
            }
            UserScore userScore = new UserScore();
            userScore.setUserId(user.getId());
            userScore.setUserScore(countRightAnswer);
            userScoreService.save(userScore);
        }

        return userAnswerRepo.save(newUserAnswer);
    }

    public List<Long> findAllQuestionIdsByUser(Long id){
        return userAnswerRepo.findAllQuestionIdsbyUser(id);
    }

    public Long countRightAnswersByUser(Long id){
        return userAnswerRepo.countRightAnswersByUser(id);
    }

    public List<UserAnswer> findAllAnswerDataByUser(Long id){

        return userAnswerRepo.findAllUserAnswersbyUser(id);
    }



//    public List<Map<String,String>> getQuestionAndAnswerList(User user){
//        Map<String, String> stringMap = new HashMap<String, String>();
//        List<Long> allQuestionIdsbyUser = userAnswerRepo.findAllQuestionIdsbyUser(user.getId());
//
//
//
//    }
//
//
//    private List<QuestionData> findAllQuestionsbyUser(Long id){
//
//        return userAnswerRepo.findAllQuestionsbyUser(id);
//    }

}


