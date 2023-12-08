package com.library.librarysys.users;

import com.library.librarysys.account.Account;
import com.library.librarysys.dbconnection.connection.AccountDAO;
import com.library.librarysys.dbconnection.connection.EmployeeDAO;
import com.library.librarysys.dbconnection.connection.LibraryDAO;
import com.library.librarysys.dbconnection.connection.ReaderDAO;
import com.library.librarysys.interfaces.Identifiable;
import com.library.librarysys.libcollection.Library;
import com.library.librarysys.users.interfaces.EmployeeManagement;
import com.library.librarysys.users.interfaces.LibraryManagement;
import com.library.librarysys.users.interfaces.ReaderManagement;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Administrator extends LoggedUser implements Identifiable, EmployeeManagement, ReaderManagement, LibraryManagement {
    private int adminID;

    public Administrator(String firstname, String lastname, String address, String phoneNum, Account account, int adminID) {
        super(firstname, lastname, address, phoneNum, account);
        this.adminID = adminID;
    }

    @Override
    public void setID(int newID) {
        this.adminID = newID;
    }


    //READER functions///////////////////////////////////////////////////
    @Override
    public void deleteReader(int readerID) {
        ReaderDAO dao = new ReaderDAO();
        dao.deleteReaderFromDB(readerID);
    }
    @Override
    public void showReaders() {
        ReaderDAO dao = new ReaderDAO();
        dao.selectReaderFromDB();
    }
    @Override
    public void showReaders(String name) {
        ReaderDAO dao = new ReaderDAO();
        dao.selectReaderFromDB(name);
    }
    @Override
    public void showReaders(int readerID) {
        ReaderDAO dao = new ReaderDAO();
        dao.selectReaderFromDB(readerID);
    }

    //EMPLOYEE functions///////////////////////////////////////////////////
    @Override
    public void deleteEmployee(int employeeID) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.deleteEmployeeFromDB(employeeID);
    }
    @Override
    public void showEmployees() {
        EmployeeDAO dao = new EmployeeDAO();
        dao.selectEmployeeFromDB();
    }
    @Override
    public void showEmployees(int employeeID) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.selectEmployeeFromDB(employeeID);
    }
    @Override
    public void showEmployees(String name) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.selectEmployeeFromDB(name);
    }
    @Override
    public void showEmployees(Employee.Position position) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.selectEmployeeFromDB(position);
    }
    @Override
    public void changeEmployeePosition(Employee employee, Employee.Position position) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.alterPositionInDB(employee, position);
        employee.setPosition(position);
    }
    @Override
    public void confirmEmployee(String firstName, String secondName) {
        Account account = new Account(0, firstName + "." + secondName + "@example.com",
                firstName.toLowerCase() + "." + secondName.toLowerCase() + ".EMPLOYEE");
        AccountDAO dao = new AccountDAO();
        dao.addAccountToDB(account);
    }

    //LIBRARY functions///////////////////////////////////////////////////
    @Override
    public void changeLibraryLocation(Library library, String location) {
        LibraryDAO dao = new LibraryDAO();
        dao.alterLocationInDB(library, location);
        library.setLocation(location);
    }
    @Override
    public void changeLibraryPhoneNum(Library library, String phoneNumber) {
        LibraryDAO dao = new LibraryDAO();
        dao.alterPhoneNumInDB(library, phoneNumber);
        library.setPhoneNum(phoneNumber);
    }
    @Override
    public void changeLibraryEmail(Library library, String email) {
        LibraryDAO dao = new LibraryDAO();
        dao.alterEmailInDB(library, email);
        library.setEmail(email);
    }
    @Override
    public String establishRules() {
        //bookmark with rules, make new posts
        return "No implementation";
    }
    @Override
    public String changeLibraryOpenings() {
        //could be made for each library, just use setters
        return "No implementation";
    }


    public String confirmPurchase() {
        //you get the note from the librarian (this textbox in Employee class) and confirm that the library can acquire the book
        return "No implementation";
    }
    public String deleteAccount() {
        //delete the account and the reader/employee from the db
        return "No implementation";
    }
}
