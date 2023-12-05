package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.users.Reader;

public class ReaderDAO extends GenericDAO<Reader> {
    public ReaderDAO() {
        super("reader");
    }

    public void deleteReaderFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

    //SELECT functions
    public void selectReaderFromDB() {
        String[] columns = {"first_name", "last_name", "address", "phone_number", "library_card_number"};
        super.selectObjectFromDB("reader", columns, null);
    }

    public void selectReaderFromDB(int id) {      //search by id
        String[] columns = {"first_name", "last_name", "address", "phone_number", "library_card_number"};
        String condition = "reader_id = ?";
        super.selectObjectFromDB("reader", columns, condition, id);
    }

    public void selectReaderFromDB(String name) {      //search by firstname or lastname
        String[] columns = {"first_name", "last_name", "address", "phone_number", "library_card_number"};
        String condition = "first_name = ? OR last_name = ?";
        super.selectObjectFromDB("reader", columns, condition, name, name);
    }

}
