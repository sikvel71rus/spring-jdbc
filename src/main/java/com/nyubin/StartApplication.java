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
public class StartApplication{

//        @Bean
//        public LobHandler lobHandler() {
//        return new DefaultLobHandler();
//        }

        public static void main(String[] args) {
            SpringApplication.run(StartApplication.class, args);
        }


    }

