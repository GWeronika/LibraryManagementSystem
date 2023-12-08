package com.library.librarysys.users;

import com.library.librarysys.account.Account;
import com.library.librarysys.account.Loan;
import com.library.librarysys.account.Order;
import com.library.librarysys.dbconnection.connection.*;
import com.library.librarysys.interfaces.Identifiable;
import com.library.librarysys.libcollection.Copy;
import com.library.librarysys.libcollection.Library;
import com.library.librarysys.users.interfaces.CopyManagement;
import com.library.librarysys.users.interfaces.LoanOrderManagement;
import com.library.librarysys.users.interfaces.PersonalData;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
public class Employee extends LoggedUser implements Identifiable, PersonalData, LoanOrderManagement, CopyManagement {
    private int employeeID;
    @Setter private Position position;
    @Setter private Library library;

    public enum Position {     //additional positions may be added later
        MANAGER,
        LIBRARIAN
    }

    public Employee(int employeeID, String firstname, String lastname, String address, String phoneNum, Account account, Position position, Library library) {
        super(firstname, lastname, address, phoneNum, account);
        this.employeeID = employeeID;
        this.position = position;
        this.library = library;
    }

    @Override
    public void setID(int newID) {
        this.employeeID = newID;
    }


    //LOAN/ORDER functions/////////////////////////////////////////
    @Override
    public void showLoans() {
        LoanDAO dao = new LoanDAO();
        dao.selectLoansFromDB();
    }
    @Override
    public void showLoans(Loan.Status status) {
        LoanDAO dao = new LoanDAO();
        dao.selectLoansFromDB(status);
    }
    @Override
    public void showOrders() {
        OrderDAO dao = new OrderDAO();
        dao.selectOrderFromDB();
    }
    @Override
    public void showOrders(int orderID) {
        OrderDAO dao = new OrderDAO();
        dao.selectOrderFromDB(orderID);
    }
    @Override
    public void showOrders(Order.Status status) {
        OrderDAO dao = new OrderDAO();
        dao.selectOrderFromDB(status);
    }
    @Override
    public void orderToLoan(int orderID) {
        OrderDAO orderDAO = new OrderDAO();
        LoanDAO loanDAO = new LoanDAO();
        CopyDAO copyDAO = new CopyDAO();
        ReaderDAO readerDAO = new ReaderDAO();
        Order order = orderDAO.getOrderByID(orderID);
    }

    //COPY functions//////////////////////////////////////////////////////
    @Override
    public void moveCopyToLibrary(Copy copy, Library library) {
        CopyDAO dao = new CopyDAO();
        dao.alterLibraryCopyInDB(copy, library);
        copy.setLibrary(library);
    }
    @Override
    public void changeCopyBlurb(Copy copy, String blurb) {
        CopyDAO dao = new CopyDAO();
        dao.alterBlurbCopyInDB(copy, blurb);
        copy.setBlurb(blurb);
    }
    @Override
    public void changeCopyStatus(Copy copy, Copy.Status status) {
        CopyDAO dao = new CopyDAO();
        dao.alterStatusCopyInDB(copy, status);
        copy.setStatus(status);
    }
    @Override
    public String addBookToResources() {
        //create new book (there will be an automatic option to add to the database in the constructor) and add it to the 'newest' bookmark
        return "No implementation";
    }

    //PERSONAL DATA functions   ////////////////////////////////////////////
    @Override
    public void changeLastName(String lastName) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.alterLastNameInDB(this, lastName);
        this.setLastname(lastName);
    }
    @Override
    public void changeAddress(String address) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.alterAddressInDB(this, address);
        this.setAddress(address);
    }
    @Override
    public void changePhoneNumber(String number) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.alterPhoneNumInDB(this, number);
        this.setPhoneNum(number);
    }
    public void changeLibrary(Library library) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.alterLibraryInDB(this, library);
        this.setLibrary(library);
    }

    public String confirmPayment() {
        //in case of penalty for overdue the book, you mark that there is no penalty anymore, maybe listArray for penalties
        return "No implementation";
    }
    public String createEvent() {
        //add an image and text to the 'newest' bookmark
        return "No implementation";
    }
    public String accessToAnalysis() {
        //you can see the books that were searched for but not found in the db (to buy it later)
        return "No implementation";
    }
    public String orderNewBook() {      //buy new book
        //still have no idea, maybe a window for entering a link or sth
        return "No implementation";
    }
}
