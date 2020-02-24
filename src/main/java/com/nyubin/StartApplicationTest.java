package com.nyubin;

import com.nyubin.model.*;
import com.nyubin.repository.QuestionDataRepo;
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
public class StartApplicationTest implements CommandLineRunner {

        private static final Logger log = LoggerFactory.getLogger(StartApplicationTest.class);

        @Autowired
        JdbcTemplate jdbcTemplate;


        @Autowired
        private QuestionDataRepo questionDataRepo;

        @Bean
        public LobHandler lobHandler() {
        return new DefaultLobHandler();
        }

        public static void main(String[] args) {
            SpringApplication.run(StartApplicationTest.class, args);
        }



        @Override
        public void run(String... args) throws Exception {

            log.info("StartApplication...");
            startQuestionApp();

        }

        private void startQuestionApp(){

            QuestionData questionData = new QuestionData();

            questionData.setName("testname");
            questionData.setAnswer("asd");
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
            questionData.setQuestionType(questionType);

            questionDataRepo.save(questionData);

            QuestionData questionData1 = new QuestionData();

            questionData1.setName("testname1");
            questionData1.setAnswer("asd");

            questionDataRepo.save(questionData);

            questionDataRepo.save(questionData1);

            Iterable<QuestionData> all3 = questionDataRepo.findAll();
            Iterable<QuestionData> allById = questionDataRepo.findAllById(Collections.singleton(1L));


        }

    }

