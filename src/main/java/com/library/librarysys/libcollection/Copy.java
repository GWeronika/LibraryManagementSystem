package com.library.librarysys.libcollection;

import com.library.librarysys.interfaces.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A class representing a copy in the library system.
 * Implements the Identifiable interface.
 */
@ToString
@EqualsAndHashCode
@Getter
public class Copy implements Identifiable {
    private int copyID;
    private final Book book;
    private final String publisher;
    private final String ISBN;
    private final Format format;
    private final String releaseYear;
    private final String language;
    @Setter private String blurb;
    @Setter private Status status;
    @Setter private Library library;

    public enum Format {
        BOOK,
        EBOOK
    }

    public enum Status {
        AVAILABLE,
        UNAVAILABLE
    }

    /**
     * First constructor for the Copy class.
     *
     * @param copyID integer number representing copy id
     * @param book Book object, which book is this a copy of
     * @param publisher String value, publisher of the copy
     * @param ISBN String value, ISBN of the copy
     * @param format Format object, format of the copy
     * @param releaseYear String value, release year of the copy
     * @param language String value, language of the copy
     * @param blurb String value, blurb of the copy
     * @param status Status object, status of the loan
     * @param library Library object, a library where the copy is
     */
    public Copy(int copyID, Book book, String publisher, String ISBN, Format format, String releaseYear, String language,
                String blurb, Status status, Library library) {
        this.copyID = copyID;
        this.book = book;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.format = format;
        this.releaseYear = releaseYear;
        this.language = language;
        this.blurb = blurb;
        this.status = status;
        this.library = library;
    }

    /**
     * Second constructor for the Copy class.
     *
     * @param book Book object, which book is this a copy of
     * @param publisher String value, publisher of the copy
     * @param ISBN String value, ISBN of the copy
     * @param format Format object, format of the copy
     * @param releaseYear String value, release year of the copy
     * @param language String value, language of the copy
     * @param blurb String value, blurb of the copy
     * @param status Status object, status of the loan
     * @param library Library object, a library where the copy is
     */
    public Copy(Book book, String publisher, String ISBN, Format format, String releaseYear, String language,
                String blurb, Status status, Library library) {
        this.book = book;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.format = format;
        this.releaseYear = releaseYear;
        this.language = language;
        this.blurb = blurb;
        this.status = status;
        this.library = library;
    }

    /**
     * Second constructor for the Copy class.
     *
     * @param book Book object, which book is this a copy of
     * @param publisher String value, publisher of the copy
     * @param ISBN String value, ISBN of the copy
     * @param format Format object, format of the copy
     * @param releaseYear String value, release year of the copy
     * @param language String value, language of the copy
     * @param status Status object, status of the loan
     * @param library Library object, a library where the copy is
     */
    public Copy(Book book, String publisher, String ISBN, Format format, String releaseYear, String language,
                Status status, Library library) {     //without blurb
        this.book = book;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.format = format;
        this.releaseYear = releaseYear;
        this.language = language;
        this.status = status;
        this.library = library;
    }

    @Override
    public void setID(int newID) {
        this.copyID = newID;
    }
}
