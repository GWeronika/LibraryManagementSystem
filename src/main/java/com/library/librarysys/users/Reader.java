package com.library.librarysys.users;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Reader extends LoggedUser {   //main panel of the reader
    private int readerID;

    @Getter @Setter
    public class LibraryCard {
        private String number;
        private String addBookToOrder() {
            return "No implementation";
        }
    }

    public String orderBook() {
        return "No implementation";
    }
    public String viewLoan() {
        return "No implementation";
    }
    public String prolong() {
        return "No implementation";
    }
}
