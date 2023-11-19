package com.library.librarysys.account;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.library.librarysys.users.LoggedUser;

@ToString
@EqualsAndHashCode
@Getter @Setter
public class Account {
    private String email;
    private String password;
    private final LoggedUser loggedUser;

    public Account(String email, String password, LoggedUser loggedUser) {
        this.email = email;
        this.password = password;
        this.loggedUser = loggedUser;
    }
    //pass verification should be added
}
