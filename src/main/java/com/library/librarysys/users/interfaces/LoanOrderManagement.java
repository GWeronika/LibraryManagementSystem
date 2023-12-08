package com.library.librarysys.users.interfaces;

import com.library.librarysys.account.Loan;
import com.library.librarysys.account.Order;

public interface LoanOrderManagement {
    void showLoans();
    void showLoans(Loan.Status status);
    void showOrders();
    void showOrders(int orderID);
    void showOrders(Order.Status status);
    String orderToLoan();
}
