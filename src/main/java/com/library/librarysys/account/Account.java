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

    /**
     * First constructor for the Account class.
     *
     * @param accountID integer number representing account id
     * @param email string value, email assigned to the account
     * @param password string value, password assigned to the account
     */
    public Account(int accountID, String email, String password) {
        this.accountID = accountID;
        this.email = email;
        this.password = password;
    }

    /**
     * Second constructor for the Account class.
     *
     * @param email string value, email assigned to the account
     * @param password string value, password assigned to the account
     */
    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void setID(int newID) { this.accountID = newID; }
}
