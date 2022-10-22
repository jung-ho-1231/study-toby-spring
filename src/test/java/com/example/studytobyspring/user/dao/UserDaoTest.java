package com.example.studytobyspring.user.dao;

import com.example.studytobyspring.user.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoTest {
    UserDao dao;
    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        dao = context.getBean("userDao", UserDao.class);

        user1 = new User("gyumme", "박성철", "springno1");
        user2 = new User("leegw700", "이길원", "springno2");
        user3 = new User("bumjin", "박범진", "springno3");
    }

    @Test
    void userDaoTest() throws Exception {
        assertThat(dao).isNotNull();
    }

    @Test
    void addAndGet() throws Exception {
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
    void count() throws Exception {

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user1);
        assertThat(dao.getCount()).isEqualTo(1);

        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        dao.add(user3);
        assertThat(dao.getCount()).isEqualTo(3);
    }

    @Test
    void getUserFailure() throws Exception {
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        assertThrows(EmptyResultDataAccessException.class, () -> {
            dao.get("unknown_id");
        });
    }
}