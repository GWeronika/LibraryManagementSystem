package com.library.librarysys.account;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter @Setter
public class Account {
    private String email;
    private String password;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }
    //pass verification should be added
}
