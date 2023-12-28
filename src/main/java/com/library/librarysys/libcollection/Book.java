package com.library.librarysys.libcollection;

import com.library.librarysys.interfaces.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * A class representing a loan in the library system.
 * Implements the Identifiable interface.
 */
@ToString
@EqualsAndHashCode
@Getter
public class Book implements Identifiable {
    private int bookID;
    private final String title;
    private final String author;

    /**
     * First constructor for the Book class.
     *
     * @param bookID integer number representing book id
     * @param title String value, title of the book
     * @param author String value, author of the book
     */
    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
    }

    /**
     * Second constructor for the Book class.
     *
     * @param title String value, title of the book
     * @param author String value, author of the book
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    @Override
    public void setID(int newID) {
        this.bookID = newID;
    }
}
