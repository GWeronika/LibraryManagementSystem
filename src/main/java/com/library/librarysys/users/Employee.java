package com.library.librarysys.users;

import com.library.librarysys.account.Account;
import com.library.librarysys.account.Loan;
import com.library.librarysys.account.Order;
import com.library.librarysys.dbconnection.connection.*;
import com.library.librarysys.libcollection.Book;
import com.library.librarysys.libcollection.Copy;
import com.library.librarysys.libcollection.Library;
import com.library.librarysys.users.interfaces.IEmployee;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

/**
 * A class representing an employee in the library system.
 * Extends the LoggedUser class and implements the IEmployee interface.
 */
@ToString
@Getter
public class Employee extends LoggedUser implements IEmployee {
    private int employeeID;
    @Setter private Position position;
    @Setter private Library library;

    /**
     * Enumeration representing various employee positions in the library system.
     * Additional positions may be added in the future.
     */
    public enum Position {
        MANAGER,
        LIBRARIAN
    }

    /**
     * Constructor for the Employee class.
     *
     * @param employeeID integer number, employee id
     * @param firstname string value, employee first name
     * @param lastname string value, employee last name
     * @param address string value, employee address
     * @param phoneNum string value, employee phone number
     * @param account reference to an employee account
     * @param position employee position
     * @param library the library where the employee works
     */
    public Employee(int employeeID, String firstname, String lastname, String address, String phoneNum, Account account, Position position, Library library) {
        super(firstname, lastname, address, phoneNum, account);
        this.employeeID = employeeID;
        this.position = position;
        this.library = library;
    }

    /**
     * Constructor for the Employee class.
     *
     * @param firstname string value, employee first name
     * @param lastname string value, employee last name
     * @param address string value, employee address
     * @param phoneNum string value, employee phone number
     * @param account reference to an employee account
     * @param position employee position
     * @param library the library where the employee works
     */
    public Employee(String firstname, String lastname, String address, String phoneNum, Account account, Position position, Library library) {
        super(firstname, lastname, address, phoneNum, account);
        this.position = position;
        this.library = library;
    }

    @Override
    public void setID(int newID) {
        this.employeeID = newID;
    }


    //LOAN/ORDER functions/////////////////////////////////////////
    /**
     * Shows all loans that were ever created and not deleted.
     *
     * @see LoanDAO
     */
    @Override
    public void showLoans() {
        LoanDAO dao = new LoanDAO();
        dao.selectLoansFromDB();
    }
    /**
     * Shows all loans whose status is consistent with the given status.
     *
     * @param status enum value among: ACTIVE, RETURNED, OVERDUE
     * @see LoanDAO
     */
    @Override
    public void showLoans(Loan.Status status) {
        LoanDAO dao = new LoanDAO();
        dao.selectLoansFromDB(status);
    }
    /**
     * Shows all orders that are active.
     *
     * @see OrderDAO
     */
    @Override
    public void showOrders() {
        OrderDAO dao = new OrderDAO();
        dao.selectOrderFromDB();
    }
    /**
     * Shows only orders with a given id
     *
     * @param orderID an integer number denoting the id of the specific order which is to be found
     * @see OrderDAO
     */
    @Override
    public void showOrders(int orderID) {
        OrderDAO dao = new OrderDAO();
        dao.selectOrderFromDB(orderID);
    }
    /**
     * Shows all orders whose status is consistent with the given status.
     *
     * @param status enum value among: REMAINING, READY
     * @see OrderDAO
     */
    @Override
    public void showOrders(Order.Status status) {
        OrderDAO dao = new OrderDAO();
        dao.selectOrderFromDB(status);
    }
    /**
     * Transfers the necessary data from the row with the given id
     * from the orders table to the loan table.
     *
     * @param orderID id of the order that will be processed by the employee
     * @see OrderDAO LoanDAO
     */
    @Override
    public void orderToLoan(int orderID) {
        OrderDAO orderDAO = new OrderDAO();
        LoanDAO loanDAO = new LoanDAO();
        Order order = orderDAO.getOrderByID(orderID);
        Loan loan = new Loan(order.getCopy(), order.getReader(), this);
        System.out.println("W Employee 2");
        if(loanDAO.addLoanToDB(loan)) {
            orderDAO.deleteOrderFromDB(orderID);
        } else {
            System.out.println("Wystąpił błąd podczas dodawania wypożyczenia");
        }
    }

    /**
     * Changes the status of the prepared order.
     *
     * @param orderID id of the order that will be processed by the employee
     * @see OrderDAO
     */
    @Override
    public void prepareOrder(int orderID) {
        OrderDAO dao = new OrderDAO();
        Order order = dao.getOrderByID(orderID);
        order.setStatus(Order.Status.READY);
        dao.alterStatusInDB(order, Order.Status.READY);
    }

    //COPY functions//////////////////////////////////////////////////////
    public void handleReturn(Copy copy) {
        CopyDAO copyDAO = new CopyDAO();
        LoanDAO loanDAO = new LoanDAO();

        ArrayList<Loan> loans = loanDAO.getLoanByCopyID(copy.getCopyID());
        Loan activeLoan = null;
        for(Loan loan : loans) {
            if(loan.getStatus() == Loan.Status.ACTIVE) {
                activeLoan = loan;
            }
        }
        if(activeLoan != null) {
            loanDAO.alterStatusInDB(activeLoan, Loan.Status.RETURNED);
            copyDAO.alterStatusCopyInDB(copy, Copy.Status.AVAILABLE);
        }
    }
    /**
     * Replaces the id of the library in which the book is located with the id
     * of another library.
     *
     * @param copy copy of the book to be transferred
     * @param library the library where the copy is to be found
     * @see CopyDAO
     */
    @Override
    public void moveCopyToLibrary(Copy copy, Library library) {
        CopyDAO dao = new CopyDAO();
        dao.alterLibraryCopyInDB(copy, library);
        copy.setLibrary(library);
    }
    /**
     * Changes the blurb assigned to the copy to another one.
     *
     * @param copy copy of the book whose blurb will be changed
     * @param blurb string value denoting the description of the book
     * @see CopyDAO
     */
    @Override
    public void changeCopyBlurb(Copy copy, String blurb) {
        CopyDAO dao = new CopyDAO();
        dao.alterBlurbCopyInDB(copy, blurb);
        copy.setBlurb(blurb);
    }
    /**
     * Changes the status of the copy.
     *
     * @param copy copy whose status is to be changed
     * @param status enum value among: AVAILABLE, UNAVAILABLE
     * @see CopyDAO
     */
    @Override
    public void changeCopyStatus(Copy copy, Copy.Status status) {
        CopyDAO dao = new CopyDAO();
        dao.alterStatusCopyInDB(copy, status);
        copy.setStatus(status);
    }

    //PERSONAL DATA functions   ////////////////////////////////////////////
    /**
     * Changes the last name of the employee.
     *
     * @param lastName new value of the lastName attribute
     * @see EmployeeDAO
     */
    @Override
    public void changeLastName(String lastName) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.alterLastNameInDB(this, lastName);
        this.setLastname(lastName);
    }
    /**
     * Changes the address of the employee.
     *
     * @param address new value of the address attribute
     * @see EmployeeDAO
     */
    @Override
    public void changeAddress(String address) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.alterAddressInDB(this, address);
        this.setAddress(address);
    }
    /**
     * Changes the phone number of the employee.
     *
     * @param number new value of the phoneNumber attribute
     * @see EmployeeDAO
     */
    @Override
    public void changePhoneNumber(String number) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.alterPhoneNumInDB(this, number);
        this.setPhoneNum(number);
    }

    /**
     * Adds a new copy (and a book if it does not exist) to the collection.
     *
     * @see CopyDAO BookDAO
     */
    @Override
    public void orderNewBook(String title, String author, String publisher, String isbn, String releaseYear,
                               Copy.Format format, String language, String blurb, Library library) {      //buy new book
        BookDAO bookDAO = new BookDAO();
        CopyDAO copyDAO = new CopyDAO();
        Copy copy;

        int duplicate = bookDAO.checkDuplicate(title, author);
        if(duplicate == 0) {
            Book book = new Book(title, author);
            copy = new Copy(book, publisher, isbn, format, releaseYear, language, blurb, Copy.Status.AVAILABLE, library);
            bookDAO.addBookToDB(book);
        } else {
            copy = new Copy(bookDAO.getBookByID(duplicate), publisher, isbn, format, releaseYear, language, blurb,
                    Copy.Status.AVAILABLE, library);
        }
        copyDAO.addCopyToDB(copy);
    }

    public String accessToAnalysis() {
        //you can see the books that were searched for but not found in the db (to buy it later)
        return "No implementation";
    }
}
