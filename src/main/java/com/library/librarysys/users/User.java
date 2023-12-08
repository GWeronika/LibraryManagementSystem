package com.library.librarysys.users;

import com.library.librarysys.dbconnection.connection.CopyDAO;
import com.library.librarysys.dbconnection.connection.LibraryDAO;
import com.library.librarysys.libcollection.Copy;

public class User {

    /**
     * Displays all libraries in the library database
     * Displayed columns:
     * name, location, phone number, email, opening day
     * opening hours and closing hours
     *
     * @see     LibraryDAO
     */
    public String createAccount() {
        //the account will only be created if the email address is not repeated in the database (the database does not accept duplicates)
        return "No implementation";
    }

    //LIBRARY functions//////////////////////////////////////////////////
    /**
     * Displays all libraries in the library database
     * Displayed columns:
     * name, location, phone number, email, opening day
     * opening hours and closing hours
     *
     * @see     LibraryDAO
     */
    public void browseLibraries() {
        LibraryDAO dao = new LibraryDAO();
        dao.selectLibraryFromDB();
    }
    public void browseLibraries(int libraryID) {
        LibraryDAO dao = new LibraryDAO();
        dao.selectLibraryFromDB(libraryID);
    }

    /**
     * Displays all libraries in the library database
     * Displayed columns:
     * name, location, phone number, email, opening day
     * opening hours and closing hours
     *
     * @param   phrase  search key for a given item
     * @see     LibraryDAO
     */
    public void browseLibraries(String phrase) {
        LibraryDAO dao = new LibraryDAO();
        dao.selectLibraryFromDB(phrase);
    }

    //COPY functions////////////////////////////////////////////////
    /**
     * Displays all copies in the library database
     * Displayed columns:
     * book title, book author, publisher, ISBN, release year,
     * format, language, blurb, status and the library where
     * the copy is located
     *
     * @see     CopyDAO
     */
    public void browseBooks() {             //search all
        CopyDAO dao = new CopyDAO();
        dao.selectCopyFromDB();
    }
    public void browseBooks(int number) {           //search by id or isbn
        CopyDAO dao = new CopyDAO();
        dao.selectCopyFromDB(number);
    }

    /**
     * Displays all copies in the library database
     * Displayed columns:
     * book title, book author, publisher, ISBN, release year,
     * format, language, blurb, status and the library where
     * the copy is located
     *
     * @param   phrase  search key for a given item
     * @see     CopyDAO
     */
    public void browseBooks(String phrase) {
        CopyDAO dao = new CopyDAO();
        dao.selectCopyFromDB(phrase);
    }
    public void browseBooks(Copy.Format format) {
        CopyDAO dao = new CopyDAO();
        dao.selectCopyFromDB(format);
    }
}
