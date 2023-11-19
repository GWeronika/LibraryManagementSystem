package com.library.librarysys.account;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.library.librarysys.libcollection.Copy;
import com.library.librarysys.users.Reader;
import com.library.librarysys.users.Employee;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@Getter
public class Order {
    private final int orderID;
    private final Copy copy;
    private final LocalDate orderData;
    @Setter private Status status;
    private final Employee employee;
    private final Reader reader;

    public enum Status {
        REMAINING,
        READY_TO_COLLECT,
        CANCELLED
    }

    public Order(int orderID, Copy copy, LocalDate orderData, Status status, Employee employee, Reader reader) {
        this.orderID = orderID;
        this.copy = copy;
        this.orderData = orderData;
        this.status = status;
        this.employee = employee;
        this.reader = reader;
    }

    public String cancel() {
        //delete the Order from db
        return "No implementation";
    }
}
