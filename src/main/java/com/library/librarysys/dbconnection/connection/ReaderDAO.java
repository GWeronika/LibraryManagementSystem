package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.openingformat.Result;
import com.library.librarysys.users.Reader;

import java.util.List;

/**
 * A class that is responsible for connecting to the "reader" table in the library system.
 * It provides methods that execute basic operations on the reader table.
 * Extends the GenericDAO class.
 *
 * @see GenericDAO
 */
public class ReaderDAO extends GenericDAO<Reader> {
    public ReaderDAO() {
        super("reader");
    }

    /**
     * Adds a new row to the "reader" table.
     *
     * @param reader Reader object to be added
     * @see GenericDAO
     */
    public void addReaderToDB(Reader reader) {
        String query = "INSERT INTO reader (first_name, last_name, address, phone_number, library_card_number, account_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        super.addObjectToDB(reader, query, reader.getFirstname(), reader.getLastname(), reader.getAddress(), reader.getPhoneNum(),
                reader.getLibraryCard().getNumber(), reader.getAccount().getAccountID());
    }

    /**
     * Deletes a row with a specific id from the "reader" table.
     *
     * @param deleteID integer number, describing the id of the reader to be deleted
     * @see GenericDAO
     */
    public boolean deleteReaderFromDB(int deleteID) {
        return super.deleteObjectFromDB(deleteID);
    }

    //SELECT functions
    /**
     * Selects all rows from the "reader" table.
     *
     * @see GenericDAO
     */
    public void selectReaderFromDB() {
        String[] columns = {"first_name", "last_name", "address", "phone_number", "library_card_number"};
        super.selectObjectFromDB(getTableName(), columns, null, null);
    }
    /**
     * Selects all rows from the "reader" table with the specific id.
     *
     * @param id integer number, id of the reader to be found
     * @see GenericDAO
     */
    public void selectReaderFromDB(int id) {      //search by id
        String[] columns = {"first_name", "last_name", "address", "phone_number", "library_card_number"};
        String condition = "reader_id = ?";
        super.selectObjectFromDB(getTableName(), columns, condition, null, id);
    }
    /**
     * Selects all rows from the "reader" table with the given first- or last name.
     *
     * @param name string value, first- or last name of the reader to be found
     * @see GenericDAO
     */
    public void selectReaderFromDB(String name) {      //search by firstname or lastname
        String[] columns = {"first_name", "last_name", "address", "phone_number", "library_card_number"};
        String condition = "first_name = ? OR last_name = ?";
        super.selectObjectFromDB(getTableName(), columns, condition, null, name, name);
    }

    /**
     * Gets the Reader object with a specific id from the database.
     *
     * @param readerID integer number, id of the reader
     * @return Reader object extracted from the database
     * @see GenericDAO
     */
    public Reader getReaderByID(int readerID) {
        List<Result> resultList = extractFromDB(readerID);
        AccountDAO accountDAO = new AccountDAO();
        for (Result result : resultList) {
            int resultReaderID = Integer.parseInt(result.getColumnValues().get("reader_id"));

            if (resultReaderID == readerID) {
                String firstName = result.getColumnValues().get("first_name");
                String lastName = result.getColumnValues().get("last_name");
                String address = result.getColumnValues().get("address");
                String phoneNumber = result.getColumnValues().get("phone_number");
                Reader.LibraryCard number = new Reader.LibraryCard(result.getColumnValues().get("library_card_number"));
                int accountID = Integer.parseInt(result.getColumnValues().get("account_id"));


                return new Reader(resultReaderID, firstName, lastName, address, phoneNumber,
                        accountDAO.getAccountByID(accountID), number);
            }
        }
        return null;
    }

    /**
     * Changes the last name of a specific reader.
     *
     * @param reader a reader whose last name is to be changed
     * @param lastName string value, last name to be changed
     */
    public void alterLastNameInDB(Reader reader, String lastName) {
        String[] set = {"last_name = '".concat(lastName) + "'"};
        String condition = "reader_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, reader.getReaderID());
    }
    /**
     * Changes the address of a specific reader.
     *
     * @param reader a reader whose address is to be changed
     * @param address string value, address to be changed
     */
    public void alterAddressInDB(Reader reader, String address) {
        String[] set = {"address = '".concat(address) + "'"};
        String condition = "reader_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, reader.getReaderID());
    }
    /**
     * Changes the phone number of a specific reader.
     *
     * @param reader a reader whose phone number is to be changed
     * @param phoneNumber string value, phone number to be changed
     */
    public void alterPhoneNumInDB(Reader reader, String phoneNumber) {
        String[] set = {"phone_number = '".concat(phoneNumber) + "'"};
        String condition = "reader_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, reader.getReaderID());
    }

    /**
     * Extracts the reader data with the specific id from the database.
     *
     * @param id integer number, id of the reader
     * @return the list with the reader data
     * @see GenericDAO
     */
    private List<Result> extractFromDB(int id) {
        String[] columns = {"reader_id", "first_name", "last_name", "address", "phone_number", "library_card_number", "account_id"};
        String condition = "reader_id = ?";
        return super.extractObjectFromDB(getTableName(), columns, condition, null, id);
    }
}
