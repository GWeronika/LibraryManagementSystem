package com.library.librarysys.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The class represents a utility class for establishing a connection to a MariaDB database.
 * It provides a static method to obtain a database connection using the JDBC driver.
 */
public class DBConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/library_system_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    /**
     * Retrieves a connection to the MariaDB database.
     *
     * @return Connection object representing the established database connection.
     * @throws SQLException If a database access error occurs or the URL is null.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
