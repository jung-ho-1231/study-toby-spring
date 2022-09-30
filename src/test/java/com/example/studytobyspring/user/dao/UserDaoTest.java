package com.example.studytobyspring.user.dao;

import com.example.studytobyspring.user.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class UserDaoTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

    @Test
    void userDaoTest() throws Exception{
        UserDao userDao = context.getBean("userDao", UserDao.class);
        assertThat(userDao).isNotNull();
    }

    @Test
    void addAndGet() throws Exception{
        UserDao dao = context.getBean("userDao", UserDao.class);
        dao.deleteAll();

        assertThat(dao.getCount()).isEqualTo(0);

        User savedUser = new User();
        savedUser.setId("park");
        savedUser.setName("jungho");
        savedUser.setPassword("1231");

        dao.add(savedUser);

        User findUser = dao.get(savedUser.getId());

        assertThat(findUser.getName()).isEqualTo(savedUser.getName());
    }

}