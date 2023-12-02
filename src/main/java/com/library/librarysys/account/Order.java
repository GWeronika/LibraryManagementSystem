package com.library.librarysys.account;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.interfaces.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.library.librarysys.libcollection.Copy;
import com.library.librarysys.users.Reader;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@Getter
public class Order implements Identifiable {
    private int orderID;
    private final Copy copy;
    private final LocalDate orderDate;
    @Setter private Status status;
    private final Reader reader;

    public enum Status {
        REMAINING,
        READY
    }

    public Order(Copy copy, Reader reader) {
        this.copy = copy;
        this.orderDate = LocalDate.now();
        this.status = Status.REMAINING;
        this.reader = reader;
    }

    @Override
    public void setID(int newID) {
        this.orderID = newID;
    }

    public void addOrderToDB() {
        GenericDAO<Order> orderDAO = new GenericDAO<>("orders");

        String query = "INSERT INTO orders (order_date, status, reader_id, copy_id) VALUES (?, ?, ?, ?)";
        orderDAO.addObjectToDB(this, query, getOrderDate(), status.name(), reader.getReaderID(), copy.getCopyID());
    }

    public void deleteOrderFromDB(int deleteID) {
        GenericDAO<Order> orderDAO = new GenericDAO<>("orders");
        orderDAO.deleteObjectFromDB(deleteID);
    }
}
