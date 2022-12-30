package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {

        String jbdcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "!6Seniaxk";

        try {
            System.out.println("Connecting to database: " + jbdcURL);
            Connection connection = DriverManager.getConnection(jbdcURL, user, password);
            System.out.println("Connection successful.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}