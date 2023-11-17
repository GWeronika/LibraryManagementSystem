package com.library.librarysys.users;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Reader extends LoggedUser {   //main panel of the reader
    private int readerID;

    @Getter @Setter
    public class LibraryCard {
        private String number;
    }

    public String orderBook() {
        //"order" button, creating an order and adding it to the order table in the db
        return "No implementation";
    }
    public String viewLoan() {
        //retrieves from the loans table only those rows that have the readerID of the reader who checks it (and maybe status as 'active' but could filter it)
        return "No implementation";
    }
    public String prolong() {
        //changes the returnDate to returnDate+=30, later, including days off from work??
        return "No implementation";
    }
}
