package com.library.librarysys.dbconnection.libcollectiondb;

import com.library.librarysys.account.Order;
import com.library.librarysys.dbconnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDAO {
    public void addOrderDB(Order order) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "INSERT INTO orders (order_date, status, reader_id, copy_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setDate(1, java.sql.Date.valueOf(order.getOrderDate()));
                preparedStatement.setString(2, order.getStatus().name());
                preparedStatement.setInt(3, order.getReader().getReaderID());
                preparedStatement.setInt(4, order.getCopy().getCopyID());

                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {     //jeśli zapytanie się powiodło, to pobieramy orderID
                    try (var generatedKeys = preparedStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            order.setOrderID(generatedKeys.getInt(1));
                        } else {
                            throw new SQLException("Creating order failed, no ID.");
                        }
                    }
                }

                System.out.println("Order added to the database.");
            }
        } catch (SQLException e) {
            System.out.println("No connection to the db");
            e.printStackTrace();
        }
    }

    public void deleteOrderDB(Order order) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "DELETE FROM orders WHERE order_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, order.getOrderID());

                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Order deleted from the database.");
                } else {
                    System.out.println("Order with ID " + order.getOrderID() + " not found in the database.");
                }
            }
        } catch (SQLException e) {
            System.out.println("No connection to the db");
            e.printStackTrace();
        }
    }
}
