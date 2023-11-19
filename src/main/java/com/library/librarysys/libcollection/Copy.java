package com.library.librarysys.libcollection;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Copy {
    private final int copyID;
    private final Book book;
    private final String publisher;
    private final String ISBN;
    private final Format format;
    private final String releaseYear;
    private final String language;
    private String blurb;
    @Setter private Library library;

    public enum Format {
        BOOK,
        EBOOK
    }

    public Copy(int copyID, Book book, String publisher, String ISBN, Format format, String releaseYear, String language, String blurb, Library library) {
        this.copyID = copyID;
        this.book = book;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.format = format;
        this.releaseYear = releaseYear;
        this.language = language;
        this.blurb = blurb;
        this.library = library;
    }
    public Copy(int copyID, Book book, String publisher, String ISBN, Format format, String releaseYear, String language, Library library) {     //without blurb
        this.copyID = copyID;
        this.book = book;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.format = format;
        this.releaseYear = releaseYear;
        this.language = language;
        this.library = library;
    }
}
