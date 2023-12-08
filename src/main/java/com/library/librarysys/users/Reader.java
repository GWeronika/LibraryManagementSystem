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

@ToString
@Getter @Setter
public class Reader extends LoggedUser implements Identifiable, PersonalData {
    private int readerID;
    private final LibraryCard libraryCard;

    @Getter @Setter
    public static class LibraryCard {
        private String number;

        public LibraryCard(String number) {
            this.number = number;
        }
    }

    public Reader(int readerID, String firstname, String lastname, String address, String phoneNum, Account account, LibraryCard libraryCard) {
        super(firstname, lastname, address, phoneNum, account);
        this.readerID = readerID;
        this.libraryCard = libraryCard;
    }

    @Override
    public void setID(int newID) {
        this.readerID = newID;
    }

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
