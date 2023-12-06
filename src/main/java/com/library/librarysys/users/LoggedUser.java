package com.library.librarysys.users;
import com.library.librarysys.account.Account;

import com.library.librarysys.dbconnection.connection.CopyDAO;
import com.library.librarysys.dbconnection.connection.LibraryDAO;
import com.library.librarysys.interfaces.Identifiable;
import com.library.librarysys.libcollection.Copy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public abstract class LoggedUser extends User implements Identifiable {
    private final String firstname;
    private final String lastname;
    @Setter private String address;
    @Setter private String phoneNum;
    private final Account account;

    public LoggedUser(String firstname, String lastname, String address, String phoneNum, Account account) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phoneNum = phoneNum;
        this.account = account;
    }

    //COPY functions
    public void browseBooks() {
        CopyDAO dao = new CopyDAO();
        dao.selectCopyFromDB();
    }
    public void browseBooks(int number) {
        CopyDAO dao = new CopyDAO();
        dao.selectCopyFromDB(number);
    }
    public void browseBooks(String name) {
        CopyDAO dao = new CopyDAO();
        dao.selectCopyFromDB(name);
    }
    public void browseBooks(Copy.Format format) {
        CopyDAO dao = new CopyDAO();
        dao.selectCopyFromDB(format);
    }

    //LIBRARY functions
    public void browseLibraries() {
        LibraryDAO dao = new LibraryDAO();
        dao.selectLibraryFromDB();
    }
    public void browseLibraries(int libraryID) {
        LibraryDAO dao = new LibraryDAO();
        dao.selectLibraryFromDB(libraryID);
    }
    public void browseLibraries(String name) {
        LibraryDAO dao = new LibraryDAO();
        dao.selectLibraryFromDB(name);
    }

    public String changeEmail() {
        //having an account (loggedUser has), set email
        return "No implementation";
    }
    public String changePassword() {
        return "No implementation";
    }
}