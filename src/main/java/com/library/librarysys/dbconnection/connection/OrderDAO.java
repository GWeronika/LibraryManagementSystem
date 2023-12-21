package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.account.Order;
import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.openingformat.Result;

import java.time.LocalDate;
import java.util.List;

/**
 * A class that is responsible for connecting to the "orders" table in the library system.
 * It provides methods that execute basic operations on the orders table.
 * Extends the GenericDAO class.
 *
 * @see GenericDAO
 */
public class OrderDAO extends GenericDAO<Order> {
    public OrderDAO() {
        super("orders");
    }

    /**
     * Adds a new row to the "orders" table.
     *
     * @param order Orders object to be added
     * @see GenericDAO
     */
    public void addOrderToDB(Order order) {
        String query = "INSERT INTO orders (order_date, status, reader_id, copy_id) VALUES (?, ?, ?, ?)";
        super.addObjectToDB(order, query, order.getOrderDate(), order.getStatus().name(), order.getReader().getReaderID(),
                order.getCopy().getCopyID());
    }

    /**
     * Deletes a row with a specific id from the "orders" table.
     *
     * @param deleteID integer number, describing the id of the order to be deleted
     * @see GenericDAO
     */
    public void deleteOrderFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

    /**
     * Selects all rows from the "orders" table.
     *
     * @see GenericDAO
     */
    public void selectOrderFromDB() {
        String[] columns = {"order_date", "orders.status", "book.title", "book.author"};
        String join = "JOIN copy ON orders.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, null, join);
    }
    /**
     * Selects all rows from the "orders" table with the specific id.
     *
     * @param id integer number, id of the order to be found
     * @see GenericDAO
     */
    public void selectOrderFromDB(int id) {
        String[] columns = {"order_date", "orders.status", "book.title", "book.author"};
        String condition = "order_id = ?";
        String join = "JOIN copy ON orders.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, id);
    }
    /**
     * Selects all rows from the "orders" table with the given status.
     *
     * @param status Order.Status object, status of the order to be found
     * @see GenericDAO
     */
    public void selectOrderFromDB(Order.Status status) {
        String[] columns = {"order_date", "orders.status", "book.title", "book.author"};
        String condition = "status = ?";
        String join = "JOIN copy ON orders.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, status);
    }

    /**
     * Gets the Order object with a specific id from the database.
     *
     * @param orderID integer number, id of the order
     * @return Order object extracted from the database
     * @see GenericDAO
     */
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

    /**
     * Changes the status of a specific order.
     *
     * @param order an order whose status is to be changed
     * @param status Order.Status object, status to be changed
     */
    public void alterStatusInDB(Order order, Order.Status status) {
        String[] set = {"status = ".concat(status.name())};
        String condition = "order_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, order.getOrderID());
    }
    /**
     * Extracts the order data with the specific id from the database.
     *
     * @param id integer number, id of the order
     * @return the list with the order data
     * @see GenericDAO
     */
    private List<Result> extractFromDB(int id) {
        String[] columns = {"order_id", "order_date", "status", "reader_id", "copy_id"};
        String condition = "order_id = ?";
        return super.extractObjectFromDB(getTableName(), columns, condition, null, id);
    }
}
