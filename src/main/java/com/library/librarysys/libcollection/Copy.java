package com.library.librarysys.libcollection;


import com.library.librarysys.account.Order;
import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.interfaces.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    public Copy(int copyID, Book book, String publisher, String ISBN, Format format, String releaseYear, String language, String blurb, Library library) {
        this.copyID = copyID;
        this.book = book;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.format = format;
        this.releaseYear = releaseYear;
        this.language = language;
        this.blurb = blurb;
        this.status = Status.AVAILABLE;
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
        this.status = Status.AVAILABLE;
        this.library = library;
    }

    @Override
    public void setID(int newID) {
        this.copyID = newID;
    }

    public void addCopyToDB() {
        GenericDAO<Copy> copyDAO = new GenericDAO<>("copy");

        String query = "INSERT INTO copy (publisher, isbn, release_year, format, language, " +
                "blurb, status, library_id, book_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        copyDAO.addObjectToDB(this, query, getPublisher(), getISBN(), getReleaseYear(), getFormat(), getLanguage(),
                getBlurb(), status.name(), library.getLibraryID(), book.getBookID());
    }

    public void deleteOrderFromDB(int deleteID) {
        GenericDAO<Copy> copyDAO = new GenericDAO<>("copy");
        copyDAO.deleteObjectFromDB(deleteID);
    }
}
