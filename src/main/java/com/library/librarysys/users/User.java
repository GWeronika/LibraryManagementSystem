package com.library.librarysys.users;

import com.library.librarysys.account.Account;
import com.library.librarysys.dbconnection.connection.AccountDAO;
import com.library.librarysys.dbconnection.connection.CopyDAO;
import com.library.librarysys.dbconnection.connection.LibraryDAO;
import com.library.librarysys.libcollection.Copy;
import com.library.password.*;

import java.security.NoSuchAlgorithmException;

/**
 * A class representing a user in the library system.
 * It contains functionalities that can be used by logged users
 * as well as guests.
 */
public class User {

    /**
     * Creates account with the specific email and password values.
     * Adds account to the database.
     *
     * @see     AccountDAO
     */
    public void createAccount(String email, String password) {
        try {
            AccountDAO dao = new AccountDAO();
            String salt = SaltGenerator.generateSalt();
            String hashedPassword = PasswordEncoder.hashPassword(password, salt);

            int duplicate = dao.checkDuplicate(email);
            if(duplicate == 0) {
                Account account = new Account(email, hashedPassword, salt);
                dao.addAccountToDB(account);
            } else {
                System.out.println("Konto o takim adresie email już istnieje.");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
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
