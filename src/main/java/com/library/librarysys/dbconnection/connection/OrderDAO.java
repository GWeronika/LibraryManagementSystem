package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.account.Order;
import com.library.librarysys.dbconnection.GenericDAO;

import java.time.LocalDate;
import java.util.List;

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
    public List<Result> extractOrderFromDB(int id) {
        String[] columns = {"copy_id, reader_id"};
        String condition = "order_id = ?";
        String join = "JOIN copy ON orders.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        return super.extractObjectFromDB(getTableName(), columns, condition, join, id);
    }

    public Order getOrderByID(int orderID) {
        List<Result> resultList = extractFromDB(orderID);
        ReaderDAO readerDAO = new ReaderDAO();
        CopyDAO copyDAO = new CopyDAO();
        for (Result result : resultList) {
            int resultCopyID = Integer.parseInt(result.getColumnValues().get("order_id"));

            if (resultCopyID == orderID) {
                LocalDate orderDate = LocalDate.parse(result.getColumnValues().get("order_date"));
                Order.Status status = Order.Status.valueOf(result.getColumnValues().get("status"));
                int readerID = Integer.parseInt(result.getColumnValues().get("reader_id"));
                int copyID = Integer.parseInt(result.getColumnValues().get("copy_id"));

                return new Order(copyDAO.getCopyByID(copyID), readerDAO.getReaderByID(readerID));
            }
        }
        return null;
    }

    public void alterStatusInDB(Order order, Order.Status status) {
        String[] set = {"status = ".concat(status.name())};
        String condition = "order_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, order.getOrderID());
    }

    private List<Result> extractFromDB(int id) {
        String[] columns = {"order_id", "order_date", "status", "reader_id", "copy_id"};
        String condition = "order_id = ?";
        return super.extractObjectFromDB(getTableName(), columns, condition, null, id);
    }
}
