package com.example.studytobyspring.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Driver;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() throws ClassNotFoundException {
        return new UserDao(datasource());
    }
    @Bean
    public DataSource datasource() throws ClassNotFoundException {
        SimpleDriverDataSource datasource = new SimpleDriverDataSource();
        datasource.setDriverClass((Class<? extends Driver>) Class.forName("org.postgresql.Driver"));
        datasource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        datasource.setUsername("postgres");
        datasource.setPassword("postgres");
        return datasource;
    }

    @Bean
    public JdbcContext jdbcContext() throws ClassNotFoundException {
        return new JdbcContext(datasource());
    }
}
