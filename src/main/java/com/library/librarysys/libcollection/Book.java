package com.library.librarysys.libcollection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Book {
    private final int bookID;
    private final String title;
    private final String author;
    private final String releaseYear;

    public Book(int bookID, String title, String author, String releaseYear) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
    }
}
