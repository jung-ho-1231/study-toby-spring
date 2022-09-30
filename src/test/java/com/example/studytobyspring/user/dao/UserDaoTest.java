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
    UserDao dao = context.getBean("userDao", UserDao.class);

    @Test
    void userDaoTest() throws Exception{
        assertThat(dao).isNotNull();
    }

    @Test
    void addAndGet() throws Exception{
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

    @Test
    void count() throws Exception{
        User user1 = new User("gyumme", "박성철", "springno1");
        User user2 = new User("leegw700", "이길원", "springno2");
        User user3 = new User("bumjin", "박범진", "springno3");

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user1);
        assertThat(dao.getCount()).isEqualTo(1);

        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        dao.add(user3);
        assertThat(dao.getCount()).isEqualTo(3);
    }
}