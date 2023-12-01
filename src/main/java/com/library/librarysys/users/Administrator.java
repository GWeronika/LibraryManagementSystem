package com.library.librarysys.users;

import com.library.librarysys.account.Account;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Administrator extends LoggedUser {
    private final int adminID;

    public Administrator(String firstname, String lastname, String address, String phoneNum, Account account, int adminID) {
        super(firstname, lastname, address, phoneNum, account);
        this.adminID = adminID;
    }

    public String confirmEmployee() {
        //confirm that they are the employees, that they were hired
        return "No implementation";
    }
    public String confirmPurchase() {
        //you get the note from the librarian (this textbox in Employee class) and confirm that the library can acquire the book
        return "No implementation";
    }
    public String establishRules() {
        //bookmark with rules, make new posts
        return "No implementation";
    }
    public String changeLibraryOpeningHours() {
        //could be made for each library, just use setters
        return "No implementation";
    }
    public String changeLibraryOpeningDays() {
        return "No implementation";
    }
    public String deleteAccount() {
        //delete the account and the reader/employee from the db
        return "No implementation";
    }
}
