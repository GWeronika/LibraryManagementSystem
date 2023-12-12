package com.library.librarysys.account;

import com.library.librarysys.interfaces.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.library.librarysys.libcollection.Copy;
import com.library.librarysys.users.Reader;

import java.time.LocalDate;

/**
 * A class representing an order in the library system.
 * Implements the Identifiable interface.
 */
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

    /**
     * First constructor for the Order class.
     *
     * @param copy Copy object, a copy for which the order applies
     * @param reader Reader object, a reader who made the order
     */
    public Order(Copy copy, Reader reader) {
        this.copy = copy;
        this.orderDate = LocalDate.now();
        this.status = Status.REMAINING;
        this.reader = reader;
    }

    /**
     * Second constructor for the Order class.
     *
     * @param orderID integer number, id of the order
     * @param copy Copy object, a copy for which the order applies
     * @param orderDate LocalDate object, order date of the loan
     * @param status Status object, status of the order
     * @param reader Reader object, a reader who made the order
     */
    public Order(int orderID, Copy copy, LocalDate orderDate, Status status, Reader reader) {
        this.orderID = orderID;
        this.copy = copy;
        this.orderDate = orderDate;
        this.status = status;
        this.reader = reader;
    }

    @Override
    public void setID(int newID) {
        this.orderID = newID;
    }
}
