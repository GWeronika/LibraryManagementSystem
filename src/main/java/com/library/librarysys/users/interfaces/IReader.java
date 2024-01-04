package com.library.librarysys.users.interfaces;

import com.library.librarysys.account.Loan;
import com.library.librarysys.interfaces.Identifiable;
import com.library.librarysys.users.interfaces.management.PersonalData;

public interface IReader extends Identifiable, PersonalData, ILoggedUser {
    void cancelOrder(int orderID);
    void orderBook(int copyID);
    void viewLoan();
    void viewLoan(Loan.Status status);
    void prolong(int loanID);
    void deleteReader();
    void changeEmail(String email);
    double calculatePenalty();
}
