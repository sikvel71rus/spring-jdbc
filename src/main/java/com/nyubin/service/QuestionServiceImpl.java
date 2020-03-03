package com.nyubin.service;

import com.nyubin.error.NotEnoughQuestionsException;
import com.nyubin.error.UserAlreadyPassedTestException;
import com.nyubin.error.WrongQuestionCompilationException;
import com.nyubin.model.Answer;
import com.nyubin.model.Question;
import com.nyubin.model.User;
import com.nyubin.repository.QuestionDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDataRepo questionDataRepo;

    @Autowired
    private UserAnswerService userAnswerService;

    @Autowired
    private UserScoreService userScoreService;


    @Override
    public List<Question> findAll() {
        return (List<Question>) questionDataRepo.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionDataRepo.findById(id);
    }

    @Override
    public Question save(Question question) {


        Set<Answer> answerSet = question.getAnswerSet();


        if (!(answerSet.size() == 1 || answerSet.size() == 4)) {
            throw new WrongQuestionCompilationException();
        }

        if (answerSet.size() == 1 &&
                !(Boolean.TRUE).equals(answerSet.stream().findFirst().get().isRight())) {
            throw new WrongQuestionCompilationException();
        }

        int trueAnswersCount = 0;


        HashSet<String> answerNames = new HashSet<>();


        for (Answer answer : question.getAnswerSet()
        ) {
            if ((Boolean.TRUE).equals(answer.isRight())) {
                trueAnswersCount++;
            }

            if (answer.getName() == "") {
                throw new WrongQuestionCompilationException();
            }

            if (answerNames.contains(answer.getName())) {
                throw new WrongQuestionCompilationException();
            }
            answerNames.add(answer.getName());

        }

        if (trueAnswersCount != 1) {
            throw new WrongQuestionCompilationException();
        }

        return questionDataRepo.save(question);
    }

    public Optional<Question> findRandomQuestion(User user) {

        if (questionDataRepo.count() < 5) {
            throw new NotEnoughQuestionsException();
        }
        if (userScoreService.findUserScoreByUserId(user.getId()) != null) {
            throw new UserAlreadyPassedTestException();
        }

        Long userId = user.getId();

        List<Long> allIds = questionDataRepo.findAllIds();

        List<Long> allQuestionIdsByUser = userAnswerService.findAllQuestionIdsByUser(userId);

        if (allQuestionIdsByUser != null) {
            for (Long questionId : allQuestionIdsByUser
            ) {
                if (allIds.contains(questionId)) {
                    allIds.remove(questionId);
                }
            }
        }

        int maxIndex = allIds.size() - 1;

        int questionIndex = (int) (Math.random() * ++maxIndex);

        return deleteAnswersFromQuestion(questionDataRepo.findById(allIds.get(questionIndex)));
    }

    @Override
    public String getQuestionNameById(Long id) {
        return questionDataRepo.getQuestionNameById(id);
    }


    private Optional<Question> deleteAnswersFromQuestion(Optional<Question> questionData) {


        if (questionData.get().getAnswerSet().size() == 1) {
            questionData.get().setAnswerSet(null);
        } else {
            for (Answer answer : questionData.get().getAnswerSet()
            ) {
                answer.setRight(false);
            }
        }
        return questionData;
    }
}
