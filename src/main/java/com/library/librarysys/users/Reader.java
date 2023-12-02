package com.library.librarysys.users;

import com.library.librarysys.account.Account;
import com.library.librarysys.account.Order;
import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.interfaces.Identifiable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
public class Reader extends LoggedUser implements Identifiable {   //main panel of the reader
    private int readerID;
    private final LibraryCard libraryCard;

    @Getter @Setter
    public static class LibraryCard {
        private String number;
    }

    public Reader(String firstname, String lastname, String address, String phoneNum, Account account, int readerID, LibraryCard libraryCard) {
        super(firstname, lastname, address, phoneNum, account);
        this.readerID = readerID;
        this.libraryCard = libraryCard;
    }

    @Override
    public void setID(int newID) {
        this.readerID = newID;
    }

    public void addReaderToDB() {
        GenericDAO<Reader> readerDAO = new GenericDAO<>("reader");

        String query = "INSERT INTO reader (first_name, last_name, address, phone_number, library_card_number, account_id) " +
                "VALUES (?, ?, ?, ?)";
        readerDAO.addObjectToDB(this, query, getFirstname(), getLastname(), getAddress(), getPhoneNum(),
                getLibraryCard().getNumber(), super.getAccount().getAccountID());
    }

    public void deleteReaderFromDB(int deleteID) {
        GenericDAO<Reader> readerDAO = new GenericDAO<>("reader");
        readerDAO.deleteObjectFromDB(deleteID);
    }

    public String orderBook() {
        //"order" button, creating an order and adding it to the order table in the db
        return "No implementation";
    }
    public String viewLoan() {
        //retrieves from the loans table only those rows that have the readerID of the reader who checks it (and maybe status as 'active' but could filter it)
        return "No implementation";
    }
    public String prolong() {
        //changes the returnDate to returnDate+=30, later, including days off from work??
        return "No implementation";
    }
}
