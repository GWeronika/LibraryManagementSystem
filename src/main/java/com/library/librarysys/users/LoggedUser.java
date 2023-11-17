package com.library.librarysys.users;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class LoggedUser extends User {
    private String firstname;
    private String lastname;
    @Setter private String address;
    @Setter private String phoneNum;

    protected String changeEmail() {
        return "No implementation";
    }
    protected String changePassword() {
        return "No implementation";
    }
}