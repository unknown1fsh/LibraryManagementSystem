package com.example.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = PropertiesLoader.getProperty("db.url", "jdbc:mysql://localhost:3306/library");
    private static final String DB_USER = PropertiesLoader.getProperty("db.username", "root");
    private static final String DB_PASSWORD = PropertiesLoader.getProperty("db.password", "12345");
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found", e);
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}

