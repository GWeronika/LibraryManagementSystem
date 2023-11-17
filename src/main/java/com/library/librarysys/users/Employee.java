package com.library.librarysys.users;

import lombok.Getter;

@Getter
public class Employee extends LoggedUser {
    private int employeeID;
    private enum position {     //additional positions may be added later
        MANAGER,
        LIBRARIAN
    }

    public String orderNewBook() {
        return "No implementation";
    }
    public String addBookToResources() {
        return "No implementation";
    }
    public String confirmPayment() {
        return "No implementation";
    }
    public String orderToLoan() {
        return "No implementation";
    }
    public String createEvent() {
        return "No implementation";
    }
    public String accessToAnalysis() {
        return "No implementation";
    }
}
