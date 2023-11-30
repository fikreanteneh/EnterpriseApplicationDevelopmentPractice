package com.itsc.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBManager {
//	private static final ServletContext context = getServletContext(); 
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/onlineregistrationsystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "241128";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load JDBC driver. Make sure the driver JAR is in the classpath.", e);
        }
    }

    public static Connection getConnection() {
        try {
        	Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create employee table.", e);
        }
    }
    public static void createTable() {
        try (Connection connection = getConnection()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "password VARCHAR(255) NOT NULL" +
                    ")";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
                preparedStatement.execute();
                System.out.println("User table created successfully.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create employee table.", e);
        }
    } 

    public static void main(String[] args) {
        createTable();
    }
    }

