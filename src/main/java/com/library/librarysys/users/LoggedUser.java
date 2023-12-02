package com.library.librarysys.users;
import com.library.librarysys.account.Account;

import com.library.librarysys.interfaces.Identifiable;
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

    public String changeEmail() {
        //having an account (loggedUser has), set email
        return "No implementation";
    }
    public String changePassword() {
        return "No implementation";
    }
}