package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Library;

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
}
