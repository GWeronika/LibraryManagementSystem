package com.library.librarysys.libcollection;

import com.library.librarysys.account.Order;
import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.interfaces.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Book implements Identifiable {
    private int bookID;
    private final String title;
    private final String author;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
    }
    @Override
    public void setID(int newID) {
        this.bookID = newID;
    }

    public void addBookToDB() {
        GenericDAO<Book> bookDAO = new GenericDAO<>("book");

        String query = "INSERT INTO book (title, author) VALUES (?, ?, ?, ?)";
        bookDAO.addObjectToDB(this, query, getTitle(), getAuthor());
    }

    public void deleteBookFromDB(int deleteID) {
        GenericDAO<Book> bookDAO = new GenericDAO<>("book");
        bookDAO.deleteObjectFromDB(deleteID);
    }
}
