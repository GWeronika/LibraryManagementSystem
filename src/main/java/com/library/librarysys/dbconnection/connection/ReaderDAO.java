package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.users.Reader;

import java.util.List;

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

    public void alterLastNameInDB(Reader reader, String lastName) {
        String[] set = {"last_name = ".concat(lastName)};
        String condition = "reader_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, reader.getReaderID());
    }
    public void alterAddressInDB(Reader reader, String address) {
        String[] set = {"address = ".concat(address)};
        String condition = "reader_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, reader.getReaderID());
    }
    public void alterPhoneNumInDB(Reader reader, String phoneNumber) {
        String[] set = {"phone_number = ".concat(phoneNumber)};
        String condition = "reader_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, reader.getReaderID());
    }

    private List<Result> extractFromDB(int id) {
        String[] columns = {"reader_id", "first_name", "last_name", "address", "phone_number", "library_card_number", "account_id"};
        String condition = "reader_id = ?";
        return super.extractObjectFromDB(getTableName(), columns, condition, null, id);
    }
}
