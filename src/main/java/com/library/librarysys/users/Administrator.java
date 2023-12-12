package com.library.librarysys.users;

import com.library.librarysys.account.Account;
import com.library.librarysys.dbconnection.connection.*;
import com.library.librarysys.interfaces.Identifiable;
import com.library.librarysys.libcollection.Library;
import com.library.librarysys.users.interfaces.EmployeeManagement;
import com.library.librarysys.users.interfaces.LibraryManagement;
import com.library.librarysys.users.interfaces.ReaderManagement;
import lombok.Getter;
import lombok.ToString;

/**
 * A class representing an administrator in the library system.
 * Extends the LoggedUser class and implements the Identifiable, EmployeeManagement, ReaderManagement
 * and LibraryManagement interfaces.
 */
@ToString
@Getter
public class Administrator extends LoggedUser implements Identifiable, EmployeeManagement, ReaderManagement, LibraryManagement {
    private int adminID;

    /**
     * Constructor for the Administrator class.
     *
     * @param adminID integer number representing admin id
     * @param firstname string value, admin first name
     * @param lastname string value, admin last name
     * @param address string value, admin address
     * @param phoneNum string value, admin phone number
     * @param account reference to an admin account
     */
    public Administrator(int adminID, String firstname, String lastname, String address, String phoneNum, Account account) {
        super(firstname, lastname, address, phoneNum, account);
        this.adminID = adminID;
    }

    @Override
    public void setID(int newID) {
        this.adminID = newID;
    }


    //READER functions///////////////////////////////////////////////////
    /**
     * Removes the reader with the given id from the database.
     * This also involves deleting all orders and loans of the reader
     * with the given ID and their library account.
     *
     * @param readerID id of the reader that will be deleted
     * @see ReaderDAO
     */
    @Override
    public void deleteReader(int readerID) {
        CopyDAO copyDAO = new CopyDAO();
        LoanDAO loanDAO = new LoanDAO();
        ReaderDAO readerDAO = new ReaderDAO();
        AccountDAO accountDAO = new AccountDAO();
        Reader reader = readerDAO.getReaderByID(readerID);

        //delete loans and orders


        //delete account
        accountDAO.getAccountByID(reader.getAccount().getAccountID());

        readerDAO.deleteReaderFromDB(readerID);
        System.out.println("Half implemented");
    }
    /**
     * Shows all readers from the database.
     *
     * @see ReaderDAO
     */
    @Override
    public void showReaders() {
        ReaderDAO dao = new ReaderDAO();
        dao.selectReaderFromDB();
    }
    /**
     * Shows readers with the specific first- or last name from the database.
     *
     * @param name string value, phrase that is compared to reader's first- or last name
     * @see ReaderDAO
     */
    @Override
    public void showReaders(String name) {
        ReaderDAO dao = new ReaderDAO();
        dao.selectReaderFromDB(name);
    }
    /**
     * Shows reader with the specific id.
     *
     * @param readerID integer number, id of the reader to be found
     * @see ReaderDAO
     */
    @Override
    public void showReaders(int readerID) {
        ReaderDAO dao = new ReaderDAO();
        dao.selectReaderFromDB(readerID);
    }

    //EMPLOYEE functions///////////////////////////////////////////////////
    /**
     * Deletes employee with the specific id.
     *
     * @param employeeID integer number, id of the employee to be deleted
     * @see EmployeeDAO
     */
    @Override
    public void deleteEmployee(int employeeID) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.deleteEmployeeFromDB(employeeID);
    }
    /**
     * Shows all employees from the database..
     *
     * @see EmployeeDAO
     */
    @Override
    public void showEmployees() {
        EmployeeDAO dao = new EmployeeDAO();
        dao.selectEmployeeFromDB();
    }
    /**
     * Shows employee with the specific id.
     *
     * @param employeeID integer number, id of the employee to be deleted
     * @see EmployeeDAO
     */
    @Override
    public void showEmployees(int employeeID) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.selectEmployeeFromDB(employeeID);
    }
    /**
     * Shows employee with the specific first- or last name.
     *
     * @param name string value, first- or last name of the reader to be found
     * @see EmployeeDAO
     */
    @Override
    public void showEmployees(String name) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.selectEmployeeFromDB(name);
    }
    /**
     * Shows employee hired on a specific position.
     *
     * @param position Employee.Position value describing the position of the employees to be found
     * @see EmployeeDAO Employee.Position
     */
    @Override
    public void showEmployees(Employee.Position position) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.selectEmployeeFromDB(position);
    }
    /**
     * Changes the position of the given employee.
     *
     * @param employee Employee type value describing the specific employee
     * @param position Employee.Position describes the position of the reader to be found
     * @see EmployeeDAO Employee.Position
     */
    @Override
    public void changeEmployeePosition(Employee employee, Employee.Position position) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.alterPositionInDB(employee, position);
        employee.setPosition(position);
    }
    /**
     * Adds the new-hired employee's password to the database.
     *
     * @param firstName string value, first name of the employee
     * @param lastName string value, last name of the employee
     * @see AccountDAO
     */
    @Override
    public void confirmEmployee(String firstName, String lastName) {
        Account account = new Account(0, firstName + "." + lastName + "@example.com",
                firstName.toLowerCase() + "." + lastName.toLowerCase() + ".EMPLOYEE");
        AccountDAO dao = new AccountDAO();
        dao.addAccountToDB(account);
    }

    //LIBRARY functions///////////////////////////////////////////////////
    /**
     * Changes the location of the library object.
     *
     * @param library Library type value, describing the specific library
     * @param location string value, location to be changed
     * @see LibraryDAO
     */
    @Override
    public void changeLibraryLocation(Library library, String location) {
        LibraryDAO dao = new LibraryDAO();
        dao.alterLocationInDB(library, location);
        library.setLocation(location);
    }
    /**
     * Changes the phone number of the library object.
     *
     * @param library Library type value, describing the specific library
     * @param phoneNumber string value, phone number to be changed
     * @see LibraryDAO
     */
    @Override
    public void changeLibraryPhoneNum(Library library, String phoneNumber) {
        LibraryDAO dao = new LibraryDAO();
        dao.alterPhoneNumInDB(library, phoneNumber);
        library.setPhoneNum(phoneNumber);
    }
    /**
     * Changes the email of the library object.
     *
     * @param library Library type value, describing the specific library
     * @param email string value, email to be changed
     * @see LibraryDAO
     */
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
    public String deleteAccount() {
        //delete the account and the reader/employee from the db
        return "No implementation";
    }
}
