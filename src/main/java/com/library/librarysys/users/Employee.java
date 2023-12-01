package com.library.librarysys.users;

import com.library.librarysys.account.Account;
import com.library.librarysys.libcollection.Library;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
public class Employee extends LoggedUser {
    private final int employeeID;
    @Setter private Position position;
    @Setter private Library library;

    public enum Position {     //additional positions may be added later
        MANAGER,
        LIBRARIAN
    }

    public Employee(String firstname, String lastname, String address, String phoneNum, Account account, int employeeID, Position position, Library library) {
        super(firstname, lastname, address, phoneNum, account);
        this.employeeID = employeeID;
        this.position = position;
        this.library = library;
    }

    public String orderNewBook() {
        //still have no idea, maybe a window for entering a link or sth
        return "No implementation";
    }
    public String addBookToResources() {
        //create new book (there will be an automatic option to add to the database in the constructor) and add it to the 'newest' bookmark
        return "No implementation";
    }
    public String confirmPayment() {
        //in case of penalty for overdue the book, you mark that there is no penalty anymore, maybe listArray for penalties
        return "No implementation";
    }
    public String orderToLoan() {
        //delete from order table and add to the loan table in db, could use a trigger in sql
        return "No implementation";
    }
    public String createEvent() {
        //add an image and text to the 'newest' bookmark
        return "No implementation";
    }
    public String accessToAnalysis() {
        //you can see the books that were searched for but not found in the db (to buy it then)
        return "No implementation";
    }
}
