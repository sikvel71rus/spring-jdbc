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

            Question question = new Question();

            question.setName("testname");

            Answer answer = new Answer();
            answer.setName("asd1");
            answer.setRight(Boolean.TRUE);
            Answer answer1 = new Answer();
            answer1.setName("asd2");
            HashSet<Answer> answerHashSet = new HashSet<>();
            answerHashSet.add(answer);
            answerHashSet.add(answer1);
            question.setAnswerSet(answerHashSet);


            questionDataRepo.save(question);

            Question question1 = new Question();

            question1.setName("testname1");


            questionDataRepo.save(question);

            questionDataRepo.save(question1);

            Iterable<Question> all3 = questionDataRepo.findAll();
            Iterable<Question> allById = questionDataRepo.findAllById(Collections.singleton(1L));

            User user = new User();
            user.setUsername("1");
            user.setPassword("12");
            Role role = new Role();
            user.getRoles().add(new Role());
            userRepo.save(user);

            UserAnswer userAnswer = new UserAnswer();

            userAnswer.setUserAnswer("Bryak");
//            userAnswer.addUserRef(user);
//            userAnswer.addQuestionRef(question);
            UserAnswer userAnswer1 = new UserAnswer();
            userAnswer1.setUserAnswer("Смешной ответ");
            userAnswer1.addUser(user);
            userAnswerRepo.save(userAnswer1);
            userAnswer.addUser(user);
            userAnswer.addQuestion(question);
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

