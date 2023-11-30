package com.library.librarysys.account;

import com.library.librarysys.dbconnection.libcollectiondb.OrderDAO;
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
public class Order {
    @Setter private int orderID;
    private final Copy copy;
    private final LocalDate orderDate;
    @Setter private Status status;
    private final Reader reader;

    public enum Status {
        REMAINING,
        READY
    }

    public Order(Copy copy, LocalDate orderDate, Status status, Reader reader) {
        this.copy = copy;
        this.orderDate = orderDate;
        this.status = Status.REMAINING;
        this.reader = reader;
    }

    public void addOrderDB(OrderDAO order) {
        order.addOrderDB(this);
    }

    public void deleteOrderDB(OrderDAO order) {
        order.deleteOrderDB(this);
    }
}
