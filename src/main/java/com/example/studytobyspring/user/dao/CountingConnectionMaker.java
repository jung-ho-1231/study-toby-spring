package com.example.studytobyspring.user.dao;

import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

@RequiredArgsConstructor
public class CountingConnectionMaker implements ConnectionMaker {
    int count = 0;
    private final ConnectionMaker realConnectionMaker;


    @Override
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        count++;
        return realConnectionMaker.makeNewConnection();
    }
}
