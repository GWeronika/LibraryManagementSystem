package com.library.librarysys.users;

import com.library.librarysys.account.Account;
import com.library.librarysys.account.Loan;
import com.library.librarysys.account.Order;
import com.library.librarysys.dbconnection.connection.CopyDAO;
import com.library.librarysys.dbconnection.connection.EmployeeDAO;
import com.library.librarysys.dbconnection.connection.LoanDAO;
import com.library.librarysys.dbconnection.connection.OrderDAO;
import com.library.librarysys.interfaces.Identifiable;
import com.library.librarysys.libcollection.Copy;
import com.library.librarysys.libcollection.Library;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
public class Employee extends LoggedUser implements Identifiable {
    private int employeeID;
    @Setter private Position position;
    @Setter private Library library;

    public enum Position {     //additional positions may be added later
        MANAGER,
        LIBRARIAN
    }

    public Employee(String firstname, String lastname, String address, String phoneNum, Account account, int employeeID, Position position, Library library) {
        super(firstname, lastname, address, phoneNum, account);
        this.employeeID = employeeID;
        this.position = position;
        this.library = library;
    }

    @Override
    public void setID(int newID) {
        this.employeeID = newID;
    }


    //LOAN functions
    public void showLoans() {
        LoanDAO dao = new LoanDAO();
        dao.selectLoansFromDB();
    }
    public void showLoans(Loan.Status status) {
        LoanDAO dao = new LoanDAO();
        dao.selectLoansFromDB(status);
    }

    //ORDER functions
    public void showOrders() {
        OrderDAO dao = new OrderDAO();
        dao.selectOrderFromDB();
    }
    public void showOrders(int orderID) {
        OrderDAO dao = new OrderDAO();
        dao.selectOrderFromDB(orderID);
    }
    public void showOrders(Order.Status status) {
        OrderDAO dao = new OrderDAO();
        dao.selectOrderFromDB(status);
    }

    public void moveCopyToLibrary(Copy copy, Library library) {
        CopyDAO dao = new CopyDAO();
        dao.alterLibraryCopyInDB(copy, library);
    }
    public void changeCopyBlurb(Copy copy, String blurb) {
        CopyDAO dao = new CopyDAO();
        dao.alterBlurbCopyInDB(copy, blurb);
    }
    public void changeCopyStatus(Copy copy, Copy.Status status) {
        CopyDAO dao = new CopyDAO();
        dao.alterStatusCopyInDB(copy, status);
    }

    public void changeLastName(String lastName) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.alterLastNameInDB(this, lastName);
    }
    public void changeAddress(String address) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.alterAddressInDB(this, address);
    }
    public void changePhoneNumber(String number) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.alterPhoneNumInDB(this, number);
    }
    public void changeLibrary(Library library) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.alterLibraryInDB(this, library);
    }

    public String orderNewBook() {
        //still have no idea, maybe a window for entering a link or sth
        return "No implementation";
    }
    public String addBookToResources() {
        //create new book (there will be an automatic option to add to the database in the constructor) and add it to the 'newest' bookmark
        return "No implementation";
    }
    public String confirmPayment() {
        //in case of penalty for overdue the book, you mark that there is no penalty anymore, maybe listArray for penalties
        return "No implementation";
    }
    public String orderToLoan() {
        //delete from order table and add to the loan table in db, could use a trigger in sql
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
}
