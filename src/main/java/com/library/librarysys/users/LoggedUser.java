package com.library.librarysys.users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public abstract class LoggedUser extends User {
    private final String firstname;
    private final String lastname;
    @Setter private String address;
    @Setter private String phoneNum;

    public LoggedUser(String firstname, String lastname, String address, String phoneNum) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public String changeEmail() {
        //having an account (loggedUser has), set email
        return "No implementation";
    }
    public String changePassword() {
        return "No implementation";
    }
}