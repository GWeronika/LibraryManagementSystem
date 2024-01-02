package com.library.librarysys.account;

import com.library.librarysys.interfaces.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A class representing an account in the library system.
 * Implements the Identifiable interface.
 */
@ToString
@EqualsAndHashCode
@Getter @Setter
public class Account implements Identifiable {
    private int accountID;
    private String email;
    private String password;
    private String salt;

    /**
     * First constructor for the Account class.
     *
     * @param accountID integer number representing account id
     * @param email string value, email assigned to the account
     * @param password string value, password assigned to the account
     * @param salt a string of data that is added to the password before the hash function is applied
     */
    public Account(int accountID, String email, String password, String salt) {
        this.accountID = accountID;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    /**
     * Second constructor for the Account class.
     *
     * @param email string value, email assigned to the account
     * @param password string value, password assigned to the account
     * @param salt a string of data that is added to the password before the hash function is applied
     */
    public Account(String email, String password, String salt) {
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    @Override
    public void setID(int newID) { this.accountID = newID; }
}
