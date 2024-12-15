package com.autotest.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/mem:testdb";
    private static final String USER = "user";
    private static final String PASSWORD = "pass";

    // Метод для получения соединения с базой данных
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }
}
