package com.library.librarysys.account;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Order {
    private int orderID;
    private LocalDate orderData;
    private enum Status {
        REMAINING,
        READY_TO_COLLECT,
        CANCELLED
    }


}
