package com.example.studytobyspring.user.dao;

import com.example.studytobyspring.user.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void add(User user) throws ClassNotFoundException, SQLException;

    User get(String id) throws ClassNotFoundException, SQLException;

    void deleteAll() throws SQLException;

    int getCount() throws SQLException;

    List<User> getAll();
}
