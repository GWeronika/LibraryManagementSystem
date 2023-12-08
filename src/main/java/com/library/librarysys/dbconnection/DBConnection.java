package com.library.librarysys.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/library_system_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

//    private static final BasicDataSource dataSource = new BasicDataSource();
//
//    static {
//        dataSource.setUrl(URL);
//        dataSource.setUsername(USERNAME);
//        dataSource.setPassword(PASSWORD);
//        dataSource.setMinIdle(5);
//        dataSource.setMaxIdle(10);
//        dataSource.setMaxTotal(20);
//    }
//
//    public static Connection getConnection() throws SQLException {
//        return dataSource.getConnection();
//    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
