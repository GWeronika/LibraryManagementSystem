package com.library.librarysys.libcollection;

import lombok.Getter;

@Getter
public class Copy {
    private final int copyID;
    private final Book book;
    private final String publisher;
    private final String ISBN;
    private final Format format;
    private final String releaseYear;
    private final String language;
    private final String blurb;

    public enum Format {
        BOOK,
        EBOOK
    }

    public Copy(int copyID, Book book, String publisher, String ISBN, Format format, String releaseYear, String language, String blurb) {
        this.copyID = copyID;
        this.book = book;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.format = format;
        this.releaseYear = releaseYear;
        this.language = language;
        this.blurb = blurb;
    }
}
