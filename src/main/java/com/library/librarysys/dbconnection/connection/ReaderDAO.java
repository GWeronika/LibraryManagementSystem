package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.users.Reader;

public class ReaderDAO extends GenericDAO<Reader> {
    public ReaderDAO() {
        super("reader");
    }

    public void addReaderToDB(Reader reader) {
        String query = "INSERT INTO reader (first_name, last_name, address, phone_number, library_card_number, account_id) " +
                "VALUES (?, ?, ?, ?)";
        super.addObjectToDB(reader, query, reader.getFirstname(), reader.getLastname(), reader.getAddress(), reader.getPhoneNum(),
                reader.getLibraryCard().getNumber(), reader.getAccount().getAccountID());
    }

    public void deleteReaderFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

    //SELECT functions
    public void selectReaderFromDB() {
        String[] columns = {"first_name", "last_name", "address", "phone_number", "library_card_number"};
        super.selectObjectFromDB(getTableName(), columns, null, null);
    }

    public void selectReaderFromDB(int id) {      //search by id
        String[] columns = {"first_name", "last_name", "address", "phone_number", "library_card_number"};
        String condition = "reader_id = ?";
        super.selectObjectFromDB(getTableName(), columns, condition, null, id);
    }

    public void selectReaderFromDB(String name) {      //search by firstname or lastname
        String[] columns = {"first_name", "last_name", "address", "phone_number", "library_card_number"};
        String condition = "first_name = ? OR last_name = ?";
        super.selectObjectFromDB(getTableName(), columns, condition, name, name);
    }

}
