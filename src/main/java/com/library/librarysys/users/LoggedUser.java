package com.library.librarysys.users;
import com.library.librarysys.account.Account;

import com.library.librarysys.dbconnection.connection.AccountDAO;
import com.library.librarysys.interfaces.Identifiable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A class representing a logged user in the library system.
 * It contains functionalities that can be used by logged users.
 */
@ToString
@Getter
public abstract class LoggedUser extends User implements Identifiable {
    private final String firstname;
    @Setter private String lastname;
    @Setter private String address;
    @Setter private String phoneNum;
    private final Account account;

    /**
     * Constructor for the LoggedUser class that is inherited
     * by the Employee, Administrator and Reader classes.
     *
     * @param firstname string value, logged user first name
     * @param lastname string value, logged user last name
     * @param address string value, logged user address
     * @param phoneNum string value, logged user phone number
     * @param account reference to a logged user account
     */
    public LoggedUser(String firstname, String lastname, String address, String phoneNum, Account account) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phoneNum = phoneNum;
        this.account = account;
    }

    /**
     * Changes the password of the logged user.
     *
     * @param password password to be changed
     * @see     AccountDAO
     */
    public void changePassword(String password) {
        AccountDAO dao = new AccountDAO();
        dao.alterPasswordAccountInDB(this, password);
        this.account.setPassword(password);
    }
}