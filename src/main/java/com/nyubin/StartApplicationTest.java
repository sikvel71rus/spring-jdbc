package com.nyubin;

import com.nyubin.model.Question;
import com.nyubin.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class StartApplicationTest implements CommandLineRunner {

        private static final Logger log = LoggerFactory.getLogger(com.nyubin.StartApplicationTest.class);

        @Autowired
        JdbcTemplate jdbcTemplate;

        @Autowired
        private QuestionRepository questionRepository;

        public static void main(String[] args) {
            SpringApplication.run(StartApplication.class, args);
        }



        @Override
        public void run(String... args) throws Exception {

            log.info("StartApplication...");
            startQuestionApp();

        }

        private void startQuestionApp(){
            jdbcTemplate.execute("DROP TABLE questions IF EXISTS");
            jdbcTemplate.execute("CREATE TABLE questions(" +
                    "id SERIAL, name VARCHAR(255))");


            Question question = new Question();
            question.setName("test1");

            Question question1 = new Question();
            question.setName("test2");

            questionRepository.save(question);
            questionRepository.save(question1);


            List<Question> all = questionRepository.findAll();


            List<Question> all2 = questionRepository.findAll2();

            for (Question quest:all
                 ) {
                System.out.println(quest.getName());

            }


        }

    }

