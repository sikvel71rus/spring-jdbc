package com.nyubin;

import com.nyubin.model.*;
import com.nyubin.repository.QuestionDataRepo;
import com.nyubin.repository.UserAnswerRepo;
import com.nyubin.repository.UserRepo;
import com.nyubin.repository.UserScoreRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

        private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

        @Autowired
        JdbcTemplate jdbcTemplate;


        @Autowired
        private QuestionDataRepo questionDataRepo;

        @Autowired
        private UserRepo userRepo;

        @Autowired
        private UserAnswerRepo userAnswerRepo;

        @Autowired
        private UserScoreRepo userScoreRepo;

        @Bean
        public LobHandler lobHandler() {
        return new DefaultLobHandler();
        }

        public static void main(String[] args) {
            SpringApplication.run(StartApplication.class, args);
        }



        @Override
        public void run(String... args) throws Exception {

            log.info("StartApplication...");
//            startQuestionApp();

        }

        private void startQuestionApp(){

            QuestionData questionData = new QuestionData();

            questionData.setName("testname");

            AnswerData answerData = new AnswerData();
            answerData.setName("asd1");
            answerData.setRight(Boolean.TRUE);
            AnswerData answerData1 = new AnswerData();
            answerData1.setName("asd2");
            HashSet<AnswerData> answerDataHashSet = new HashSet<>();
            answerDataHashSet.add(answerData);
            answerDataHashSet.add(answerData1);
            questionData.setAnswerDataSet(answerDataHashSet);

            QuestionType questionType = new QuestionType();
            questionType.setName("Свободный выбор ответа");
            questionType.setId(1L);
//            questionData.setQuestionType(questionType);

            questionDataRepo.save(questionData);

            QuestionData questionData1 = new QuestionData();

            questionData1.setName("testname1");


            questionDataRepo.save(questionData);

            questionDataRepo.save(questionData1);

            Iterable<QuestionData> all3 = questionDataRepo.findAll();
            Iterable<QuestionData> allById = questionDataRepo.findAllById(Collections.singleton(1L));

            User user = new User();
            user.setUsername("1");
            user.setPassword("12");
            Role role = new Role();
            user.getRoles().add(new Role());
            userRepo.save(user);

            UserAnswer userAnswer = new UserAnswer();

            userAnswer.setUserAnswer("Bryak");
//            userAnswer.addUserRef(user);
//            userAnswer.addQuestionRef(questionData);
            UserAnswer userAnswer1 = new UserAnswer();
            userAnswer1.setUserAnswer("Смешной ответ");
            userAnswer1.addUser(user);
            userAnswerRepo.save(userAnswer1);
            userAnswer.addUser(user);
            userAnswer.addQuestion(questionData);
            userAnswerRepo.save(userAnswer);


            Iterable<UserAnswer> all = userAnswerRepo.findAll();
            Iterable<User> all1 = userRepo.findAll();

            User funnyUser = userRepo.findByUsername("funnyUser");

            List<Long> allIds = questionDataRepo.findAllIds();



            UserScore userScore = new UserScore();
            userScore.setUserId(1L);
            userScore.setUserScore(0L);
            userScoreRepo.save(userScore);

            Iterable<UserScore> all2 = userScoreRepo.findAll();


        }

    }

