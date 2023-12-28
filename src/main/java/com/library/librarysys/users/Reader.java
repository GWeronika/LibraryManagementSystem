package com.library.librarysys.users;

import com.library.librarysys.account.Account;
import com.library.librarysys.account.Loan;
import com.library.librarysys.account.Order;
import com.library.librarysys.dbconnection.connection.*;
import com.library.librarysys.libcollection.Copy;
import com.library.librarysys.users.interfaces.IReader;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A class representing a reader in the library system.
 * Extends the LoggedUser class and implements the IReader interface.
 */
@ToString
@Getter @Setter
public class Reader extends LoggedUser implements IReader {
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
     * Removes the order with the given id from the database.
     * Changes the status of the copy to AVAILABLE.
     *
     * @param orderID id of the order that will be canceled
     * @see OrderDAO CopyDAO
     */
    @Override
    public void cancelOrder(int orderID) {
        OrderDAO orderDAO = new OrderDAO();
        CopyDAO copyDAO = new CopyDAO();

        Order order = orderDAO.getOrderByID(orderID);
        if(order != null && order.getReader().getReaderID() == this.getReaderID()) {
            int copyID = order.getCopy().getCopyID();       //collecting the copyID from the order

            Copy copy = copyDAO.getCopyByID(copyID);
            copy.setStatus(Copy.Status.AVAILABLE);          //changing status to AVALIABLE in db and in the code
            copyDAO.alterStatusCopyInDB(copy, Copy.Status.AVAILABLE);

            orderDAO.deleteOrderFromDB(orderID);
        } else {
            System.out.println("Nie istnieje twoje zamówienie o podanym ID");
        }
    }

    /**
     * Creates a book order with the given ID. Adds the order to the database.
     * Changes the status of the copy to UNAVAILABLE.
     *
     * @param copyID id of the copy that will be ordered
     * @see OrderDAO CopyDAO
     */
    @Override
    public void orderBook(int copyID) {
        CopyDAO copyDAO= new CopyDAO();
        OrderDAO orderDAO = new OrderDAO();

        Copy copy = copyDAO.getCopyByID(copyID);
        if(copy != null) {
            if (copy.getStatus() == Copy.Status.AVAILABLE) {
                Order order = new Order(copy, this);
                orderDAO.addOrderToDB(order);
                copy.setStatus(Copy.Status.UNAVAILABLE);
                copyDAO.alterStatusCopyInDB(copy, Copy.Status.UNAVAILABLE);
            } else {
                System.out.println("Ten egzemplarz jest wypożyczony.");
            }
        } else {
            System.out.println("Nie istnieje egzemplarz o podanym ID");
        }
    }

    /**
     * Shows the user his own loans (active, overdue as well as returned).
     *
     * @see LoanDAO
     */
    @Override
    public void viewLoan() {
        LoanDAO dao = new LoanDAO();
        dao.selectLoansFromDB(this);
    }
    /**
     * Shows the user his own loans with a specific status.
     *
     * @param status the status of loans that the reader wants to see
     * @see LoanDAO
     */
    @Override
    public void viewLoan(Loan.Status status) {        //only active loans from a specific reader
        LoanDAO dao = new LoanDAO();
        dao.selectLoansFromDB(this, status);
    }

    /**
     * Extends the loan period of the copy by 30 days.
     *
     * @param loanID id of the loan to prolong
     * @see LoanDAO
     */
    @Override
    public void prolong(int loanID) {
        LoanDAO loanDAO = new LoanDAO();
        Loan loan = loanDAO.getLoanByID(loanID);

        if(loan != null) {
            if(loan.getReader().getReaderID() == this.readerID) {
                loanDAO.alterReturnDateInDB(loan, loan.getReturnDate().plusDays(30));
                loan.setReturnDate(loan.getReturnDate().plusDays(30));
            } else {
                System.out.println("Wypożyczenie nie należy do czytelnika o podanym ID");
            }
        } else {
            System.out.println("Nie ma wypożyczenia o takim ID");
        }
    }

    /**
     * Removes the reader from the database.
     * This also involves deleting all orders and loans of the reader
     * with the given ID and their library account.
     *
     * @see ReaderDAO
     */
    @Override
    public void deleteReader() {
        ReaderDAO readerDAO = new ReaderDAO();
        AccountDAO accountDAO = new AccountDAO();
        Reader reader = readerDAO.getReaderByID(this.readerID);

        //trigger deletes loans and orders of the deleted reader
        readerDAO.deleteReaderFromDB(this.readerID);
        //delete account
        accountDAO.deleteAccountFromDB(reader.getAccount().getAccountID());
    }

    /**
     * Changes the email address in the reader's account.
     *
     * @param email string value the reader wants to replace the old value with
     * @see AccountDAO
     */
    @Override
    public void changeEmail(String email) {
        AccountDAO dao = new AccountDAO();
        dao.alterEmailAccountInDB(this, email);
        this.getAccount().setEmail(email);
    }

    //PERSONAL DATA functions   ////////////////////////////////////////////
    /**
     * Changes the last name of the reader.
     *
     * @param lastName string value the reader wants to replace the old value with
     * @see ReaderDAO
     */
    public void changeLastName(String lastName) {
        ReaderDAO dao = new ReaderDAO();
        dao.alterLastNameInDB(this, lastName);
        this.setLastname(lastName);
    }
    /**
     * Changes the address of the reader.
     *
     * @param address string value the reader wants to replace the old value with
     * @see ReaderDAO
     */
    public void changeAddress(String address) {
        ReaderDAO dao = new ReaderDAO();
        dao.alterAddressInDB(this, address);
        this.setAddress(address);
    }
    /**
     * Changes the phone number of the reader.
     *
     * @param number string value the reader wants to replace the old value with
     * @see ReaderDAO
     */
    public void changePhoneNumber(String number) {
        ReaderDAO dao = new ReaderDAO();
        dao.alterPhoneNumInDB(this, number);
        this.setPhoneNum(number);
    }
}
