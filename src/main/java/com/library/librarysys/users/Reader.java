package com.library.librarysys.users;

import com.library.librarysys.account.Account;
import com.library.librarysys.dbconnection.connection.AccountDAO;
import com.library.librarysys.dbconnection.connection.LoanDAO;
import com.library.librarysys.dbconnection.connection.OrderDAO;
import com.library.librarysys.dbconnection.connection.ReaderDAO;
import com.library.librarysys.interfaces.Identifiable;
import com.library.librarysys.users.interfaces.PersonalData;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A class representing a reader in the library system.
 * Extends the LoggedUser class and implements the Identifiable and PersonalData,
 */
@ToString
@Getter @Setter
public class Reader extends LoggedUser implements Identifiable, PersonalData {
    private int readerID;
    private final LibraryCard libraryCard;

/**
 * Represents a library card used for library membership.
 *
 * <p>A library card is associated with a unique identification number.
 * It is used to borrow and return library materials and access library services.
 * Instances of this class are created with a specified card number.</p>
 *
 * <p>This class is an inner static class of the outer class where it is declared.</p>
 */
    @Getter @Setter
    public static class LibraryCard {
        private String number;
        public LibraryCard(String number) {
            this.number = number;
        }
    }

    /**
     * Constructor for the Reader class.
     *
     * @param readerID integer number, reader id
     * @param firstname string value, reader first name
     * @param lastname string value, reader last name
     * @param address string value, reader address
     * @param phoneNum string value, reader phone number
     * @param account reference to a reader account
     * @param libraryCard library card with a unique number that the reader has
     */
    public Reader(int readerID, String firstname, String lastname, String address, String phoneNum, Account account, LibraryCard libraryCard) {
        super(firstname, lastname, address, phoneNum, account);
        this.readerID = readerID;
        this.libraryCard = libraryCard;
    }

    @Override
    public void setID(int newID) {
        this.readerID = newID;
    }

    /**
     * removes the order with the given id from the database
     *
     * @param orderID id of the order that will be canceled
     * @see OrderDAO
     */
    public void cancelOrder(int orderID) {
        OrderDAO dao = new OrderDAO();
        dao.deleteOrderFromDB(orderID);
    }

    public String orderBook() {     //id or Copy?
        //here we should get info from the button that was just clicked
        return "No implementation";
    }
    public void viewLoan() {        //only loans from a specific reader
        LoanDAO dao = new LoanDAO();
        dao.selectLoansFromDB(this.readerID);
    }
    public String prolong() {
        //changes the returnDate to returnDate+=30, later, including days off from work??
        return "No implementation";
    }

    public void changeEmail(String email) {
        AccountDAO dao = new AccountDAO();
        dao.alterEmailAccountInDB(this, email);
        super.getAccount().setEmail(email);
    }

    //PERSONAL DATA functions   ////////////////////////////////////////////
    public void changeLastName(String lastName) {
        ReaderDAO dao = new ReaderDAO();
        dao.alterLastNameInDB(this, lastName);
        this.setLastname(lastName);
    }
    public void changeAddress(String address) {
        ReaderDAO dao = new ReaderDAO();
        dao.alterAddressInDB(this, address);
        this.setAddress(address);
    }
    public void changePhoneNumber(String number) {
        ReaderDAO dao = new ReaderDAO();
        dao.alterPhoneNumInDB(this, number);
        this.setPhoneNum(number);
    }
}
