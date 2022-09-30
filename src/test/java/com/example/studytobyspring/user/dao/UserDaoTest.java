package com.example.studytobyspring.user.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

    @Test
    void userDaoTest() throws Exception{
        UserDao userDao = context.getBean("userDao", UserDao.class);
        Assertions.assertThat(userDao).isNotNull();
    }
}