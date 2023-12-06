package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.account.Order;
import com.library.librarysys.dbconnection.GenericDAO;

public class OrderDAO extends GenericDAO<Order> {
    public OrderDAO() {
        super("orders");
    }

    public void addOrderToDB(Order order) {
        String query = "INSERT INTO orders (order_date, status, reader_id, copy_id) VALUES (?, ?, ?, ?)";
        super.addObjectToDB(order, query, order.getOrderDate(), order.getStatus().name(), order.getReader().getReaderID(),
                order.getCopy().getCopyID());
    }

    public void deleteOrderFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

    public void selectOrderFromDB() {
        String[] columns = {"order_date", "orders.status", "book.title", "book.author"};
        String join = "JOIN copy ON orders.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, null, join);
    }
    public void selectOrderFromDB(int id) {
        String[] columns = {"order_date", "orders.status", "book.title", "book.author"};
        String condition = "order_id = ?";
        String join = "JOIN copy ON orders.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, id);
    }
    public void selectOrderFromDB(Order.Status status) {
        String[] columns = {"order_date", "orders.status", "book.title", "book.author"};
        String condition = "status = ?";
        String join = "JOIN copy ON orders.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, status);
    }
}
