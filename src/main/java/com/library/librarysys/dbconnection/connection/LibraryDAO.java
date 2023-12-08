package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Library;
import com.library.librarysys.libcollection.Opening;

import java.time.LocalTime;
import java.util.List;

public class LibraryDAO extends GenericDAO<Library> {
    public LibraryDAO() {
        super("library");
    }

    public void selectLibraryFromDB() {
        String[] columns = {"name", "location", "phone_number", "email", "opening.day", "opening.open_hour", "opening.close_hour"};
        String join = "JOIN library_opening ON library.library_id = library_opening.library_id JOIN opening ON library_opening.opening_id = opening.opening_id";
        super.selectObjectFromDB(getTableName(), columns, null, join);
    }
    public void selectLibraryFromDB(int id) {
        String[] columns = {"name", "location", "phone_number", "email", "opening.day", "opening.open_hour", "opening.close_hour"};
        String join = "JOIN library_opening ON library.library_id = library_opening.library_id JOIN opening ON library_opening.opening_id = opening.opening_id";
        String condition = "library_id = ?";
        super.selectObjectFromDB(getTableName(), columns, condition, join, id);
    }
    public void selectLibraryFromDB(String name) {
        String[] columns = {"name", "location", "phone_number", "email", "opening.day", "opening.open_hour", "opening.close_hour"};
        String join = "JOIN library_opening ON library.library_id = library_opening.library_id JOIN opening ON library_opening.opening_id = opening.opening_id";
        String condition = "name = ? OR location = ?";
        super.selectObjectFromDB(getTableName(), columns, condition, join, name, name);
    }

    public Library getLibraryByID(int libraryID) {
        List<Result> resultList = extractFromDB(libraryID);
        Library library = null;

        for (Result result : resultList) {
            int resultLibraryID = Integer.parseInt(result.getColumnValues().get("library_id"));

            if (resultLibraryID == libraryID) {
                String name = result.getColumnValues().get("name");
                String location = result.getColumnValues().get("location");
                String phoneNumber = result.getColumnValues().get("phone_number");
                String email = result.getColumnValues().get("email");

                int openingID = Integer.parseInt(result.getColumnValues().get("opening.opening_id"));
                Opening.Day day = Opening.Day.valueOf(result.getColumnValues().get("opening.day"));
                LocalTime openHour = LocalTime.parse(result.getColumnValues().get("opening.open_hour"));
                LocalTime closeHour = LocalTime.parse(result.getColumnValues().get("opening.close_hour"));

                if (library == null) {
                    library = new Library(resultLibraryID, name, location, phoneNumber, email);
                }
                Opening opening = new Opening(openingID, day, openHour, closeHour);
                library.getOpeningsList().put(day, opening);
            }
        }
        return library;
    }


    public void alterLocationInDB(Library library, String location) {
        String[] set = {"location = ".concat(location)};
        String condition = "library_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, library.getLibraryID());
    }
    public void alterPhoneNumInDB(Library library, String phoneNumber) {
        String[] set = {"phone_number = ".concat(phoneNumber)};
        String condition = "library_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, library.getLibraryID());
    }
    public void alterEmailInDB(Library library, String email) {
        String[] set = {"email = ".concat(email)};
        String condition = "library_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, library.getLibraryID());
    }

    private List<Result> extractFromDB(int id) {
        String[] columns = {"library_id", "name", "location", "phone_number", "email",  "opening.opening_id", "opening.day",
                "opening.open_hour", "opening.close_hour"};
        String condition = "library_id = ?";
        String join = "JOIN library_opening ON library.library_id = library_opening.library.id " +
                "JOIN opening ON library_opening.opening_id = opening.opening_id";
        return super.extractObjectFromDB(getTableName(), columns, condition, join, id);
    }
}
