package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Library;
import com.library.librarysys.libcollection.Opening;
import com.library.librarysys.openingformat.Result;

import java.time.LocalTime;
import java.util.List;

/**
 * A class that is responsible for connecting to the "library" table in the library system.
 * It provides methods that execute basic operations on the library table.
 * Extends the GenericDAO class.
 *
 * @see GenericDAO
 */
public class LibraryDAO extends GenericDAO<Library> {
    public LibraryDAO() {
        super("library");
    }

    /**
     * Selects all rows from the "library" table.
     *
     * @see GenericDAO
     */
    public void selectLibraryFromDB() {
        String[] columns = {"name", "location", "phone_number", "email", "opening.day", "opening.open_hour", "opening.close_hour"};
        String join = "JOIN library_opening ON library.library_id = library_opening.library_id JOIN opening ON library_opening.opening_id = opening.opening_id";
        super.selectObjectFromDB(getTableName(), columns, null, join);
    }
    /**
     * Selects all rows from the "library" table with the specific id.
     *
     * @param id integer number, id of the library to be found
     * @see GenericDAO
     */
    public void selectLibraryFromDB(int id) {
        String[] columns = {"name", "location", "phone_number", "email", "opening.day", "opening.open_hour", "opening.close_hour"};
        String join = "JOIN library_opening ON library.library_id = library_opening.library_id JOIN opening ON library_opening.opening_id = opening.opening_id";
        String condition = "library_id = ?";
        super.selectObjectFromDB(getTableName(), columns, condition, join, id);
    }
    /**
     * Selects all rows from the "library" table with the given name.
     *
     * @param name string value, name of the library to be found
     * @see GenericDAO
     */
    public void selectLibraryFromDB(String name) {
        String[] columns = {"name", "location", "phone_number", "email", "opening.day", "opening.open_hour", "opening.close_hour"};
        String join = "JOIN library_opening ON library.library_id = library_opening.library_id JOIN opening ON library_opening.opening_id = opening.opening_id";
        String condition = "name = ? OR location = ?";
        super.selectObjectFromDB(getTableName(), columns, condition, join, name, name);
    }

    /**
     * Gets the Library object with a specific id from the database.
     *
     * @param libraryID integer number, id of the library
     * @return Library object extracted from the database
     * @see GenericDAO
     */
    public Library getLibraryByID(int libraryID) {
        List<Result> resultList = extractFromDB(libraryID);
        Library library = null;

        for (Result result : resultList) {

            int resultLibraryID = Integer.parseInt(result.getColumnValues().get("library.library_id"));

            if (resultLibraryID == libraryID) {
                String name = result.getColumnValues().get("name");
                String location = result.getColumnValues().get("location");
                String phoneNumber = result.getColumnValues().get("phone_number");
                String email = result.getColumnValues().get("email");

                int openingID = Integer.parseInt(result.getColumnValues().get("opening.opening_id"));
                Opening.Day day = Opening.Day.valueOf(result.getColumnValues().get("opening.day"));
                LocalTime openHour = LocalTime.parse(result.getColumnValues().get("opening.open_hour"));
                LocalTime closeHour = LocalTime.parse(result.getColumnValues().get("opening.close_hour"));

                Opening opening = new Opening(openingID, day, openHour, closeHour);
                if (library == null) {
                    library = new Library(resultLibraryID, name, location, phoneNumber, email, opening);
                }
            }
        }
        return library;
    }

    /**
     * Changes the location of a specific library.
     *
     * @param library a library whose location is to be changed
     * @param location string value, location to be changed
     */
    public void alterLocationInDB(Library library, String location) {
        String[] set = {"location = ".concat(location)};
        String condition = "library_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, library.getLibraryID());
    }
    /**
     * Changes the phone number of a specific library.
     *
     * @param library a library whose phone number is to be changed
     * @param phoneNumber string value, phone number to be changed
     */
    public void alterPhoneNumInDB(Library library, String phoneNumber) {
        String[] set = {"phone_number = ".concat(phoneNumber)};
        String condition = "library_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, library.getLibraryID());
    }
    /**
     * Changes the email of a specific library.
     *
     * @param library a library whose email is to be changed
     * @param email string value, email to be changed
     */
    public void alterEmailInDB(Library library, String email) {
        String[] set = {"email = ".concat(email)};
        String condition = "library_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, library.getLibraryID());
    }

    /**
     * Extracts the library data with the specific id from the database.
     *
     * @param id integer number, id of the library
     * @return the list with the library data
     * @see GenericDAO
     */
    private List<Result> extractFromDB(int id) {
        String[] columns = {"library.library_id", "name", "location", "phone_number", "email",  "opening.opening_id", "opening.day",
                "opening.open_hour", "opening.close_hour"};
        String condition = "library.library_id = ?";
        String join = "JOIN library_opening ON library.library_id = library_opening.library_id " +
                "JOIN opening ON library_opening.opening_id = opening.opening_id";
        return super.extractObjectFromDB(getTableName(), columns, condition, join, id);
    }
}
