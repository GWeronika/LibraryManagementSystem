package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.account.Loan;
import com.library.librarysys.dbconnection.GenericDAO;

public class LoanDAO extends GenericDAO<Loan> {
    public LoanDAO() {
        super("loan");
    }

    public void deleteLoanFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

    public void selectLoansFromDB() {
        String[] columns = {"loan_date", "return_date", "loan.status", "book.title", "book.author"};
        String join = "JOIN copy ON loan.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, null, join);
    }
    public void selectLoansFromDB(int id) {      //search by id
        String[] columns = {"loan_date", "return_date", "loan.status", "book.title", "book.author"};
        String condition = "loan_id = ?";
        String join = "JOIN copy ON loan.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, id);
    }
    public void selectLoansFromDB(Loan.Status status) {      //search by status
        String[] columns = {"loan_date", "return_date", "loan.status", "book.title", "book.author"};
        String condition = "loan.status = ?";
        String join = "JOIN copy ON loan.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, status);
    }

}
