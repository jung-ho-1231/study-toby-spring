package com.example.studytobyspring.user.dao;

import com.example.studytobyspring.user.domain.User;

import java.sql.*;

public class DUserDao extends UserDao {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        return c;
    }
}
