package com.nyubin;

import com.nyubin.model.Answer;
import com.nyubin.model.Question;
import com.nyubin.repository.AnswerRepository;
import com.nyubin.repository.QuestionRepository;
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

import java.util.List;

@SpringBootApplication
public class StartApplicationTest implements CommandLineRunner {

        private static final Logger log = LoggerFactory.getLogger(StartApplicationTest.class);

        @Autowired
        JdbcTemplate jdbcTemplate;

        @Autowired
        private QuestionRepository questionRepository;

        @Autowired
        private AnswerRepository answerRepository;
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
            jdbcTemplate.execute("DROP TABLE questions IF EXISTS");
            jdbcTemplate.execute("CREATE TABLE questions(" +
                    "id SERIAL, name VARCHAR(255))");


            //TODO исправить istrue на isright
            jdbcTemplate.execute("DROP TABLE answers IF EXISTS");
            jdbcTemplate.execute("CREATE TABLE answers(" +
                    "id SERIAL, name VARCHAR(255), is_true boolean, question_id LONG  )");


            Question question = new Question();
            question.setName("test1");

            Question question1 = new Question();
            question1.setName("test2");

            questionRepository.save(question);
            questionRepository.save(question1);


            List<Question> all = questionRepository.findAll();


            List<Question> all2 = questionRepository.findAll2();

            for (Question quest:all
                 ) {
                System.out.println(quest.getName());

            }

            Answer answer = new Answer();
            answer.setName("answer1");
            answer.setQuestionId(1L);
            answer.setIsRight(Boolean.TRUE);

            Answer answer1 = new Answer();
            answer1.setName("answer2");
            answer1.setQuestionId(1L);
            answer1.setIsRight(Boolean.FALSE);


            answerRepository.save(answer);
            answerRepository.save(answer1);

            List<Answer> byQuestionId = answerRepository.getByQuestionId(1L);

            List<Answer> all1 = answerRepository.findAll();


        }

    }

