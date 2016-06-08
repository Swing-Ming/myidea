package com.company;


import org.junit.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil_Connection {
    @org.junit.Test
    public static Connection getconnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql:///library", "root", "123456liming");
            Assert.assertNotNull(connection);
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
