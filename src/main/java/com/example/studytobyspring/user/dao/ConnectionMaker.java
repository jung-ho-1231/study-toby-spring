package com.example.studytobyspring.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    Connection makeNewConnection() throws ClassNotFoundException, SQLException;
}
