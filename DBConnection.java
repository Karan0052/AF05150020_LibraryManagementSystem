package com.lib;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Karan098@1"; // change

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
        return con;
    }
}