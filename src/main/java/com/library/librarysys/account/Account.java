package com.library.librarysys.account;

import com.library.librarysys.interfaces.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter @Setter
public class Account implements Identifiable {
    private int accountID;
    private String email;
    private String password;

    public Account(int accountID, String email, String password) {
        this.accountID = accountID;
        this.email = email;
        this.password = password;
    }

    @Override
    public void setID(int newID) { this.accountID = newID; }
}
