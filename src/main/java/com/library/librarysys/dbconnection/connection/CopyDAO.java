package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Copy;
import com.library.librarysys.libcollection.Library;

public class CopyDAO extends GenericDAO<Copy> {
    public CopyDAO() {
        super("copy");
    }

    public void addCopyToDB(Copy copy) {
        String query = "INSERT INTO copy (publisher, isbn, release_year, format, language, " +
                "blurb, status, library_id, book_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        super.addObjectToDB(copy, query, copy.getPublisher(), copy.getISBN(), copy.getReleaseYear(), copy.getFormat(),
                copy.getLanguage(), copy.getBlurb(), copy.getStatus().name(), copy.getLibrary().getLibraryID(),
                copy.getBook().getBookID());
    }

    public void deleteCopyFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

    public void selectCopyFromDB() {
        String[] columns = {"book.title", "book.author", "publisher", "isbn", "release_year", "format", "language", "blurb", "status", "library.name"};
        String join = "JOIN library ON library.library_id = copy.library_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, null, join);
    }
    public void selectCopyFromDB(int number) {
        String[] columns = {"book.title", "book.author", "publisher", "isbn", "release_year", "format", "language", "blurb", "status", "library.name"};
        String condition = "copy_id = ? OR isbn = ?";
        String join = "JOIN library ON library.library_id = copy.library_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, number, number);
    }
    public void selectCopyFromDB(String name) {
        String[] columns = {"book.title", "book.author", "publisher", "isbn", "release_year", "format", "language", "blurb", "status", "library.name"};
        String condition = "book.title LIKE ? OR book.author LIKE ? ";
        String join = "JOIN library ON library.library_id = copy.library_id JOIN book ON book.book_id = copy.book_id";
        String likeName = "%" + name + "%";
        super.selectObjectFromDB(getTableName(), columns, condition, join, likeName, likeName);
    }
    public void selectCopyFromDB(Copy.Format format) {
        String[] columns = {"book.title", "book.author", "publisher", "isbn", "release_year", "format", "language", "blurb", "status", "library.name"};
        String condition = "format = ?";
        String join = "JOIN library ON library.library_id = copy.library_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, format);
    }

    public void alterLibraryCopyInDB(Copy copy, Library library) {
        String[] set = {"library_id = ".concat(String.valueOf(library.getLibraryID()))};
        String condition = "copy_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, copy.getCopyID());
    }
    public void alterBlurbCopyInDB(Copy copy, String blurb) {
        String[] set = {"blurb = ".concat(blurb)};
        String condition = "copy_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, copy.getCopyID());
    }
    public void alterStatusCopyInDB(Copy copy, Copy.Status status) {
        String[] set = {"library_id = ".concat(status.name())};
        String condition = "copy_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, copy.getCopyID());
    }
}
