package com.example.studytobyspring.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public CountingConnectionMaker connectionMaker(){
        return new CountingConnectionMaker(realConnectionMake());
    }

    @Bean
    public DConnectionMaker realConnectionMake() {
        return new DConnectionMaker();
    }


}
