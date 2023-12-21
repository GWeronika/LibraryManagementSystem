package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Copy;
import com.library.librarysys.libcollection.Library;
import com.library.librarysys.openingformat.Result;

import java.util.List;

/**
 * A class that is responsible for connecting to the "copy" table in the library system.
 * It provides methods that execute basic operations on the copy table.
 * Extends the GenericDAO class
 *
 * @see GenericDAO
 */
public class CopyDAO extends GenericDAO<Copy> {
    public CopyDAO() {
        super("copy");
    }

    /**
     * Adds a new row to the "copy" table.
     *
     * @param copy Copy object to be added
     * @see GenericDAO
     */
    public void addCopyToDB(Copy copy) {
        String query = "INSERT INTO copy (publisher, isbn, release_year, format, language, " +
                "blurb, status, library_id, book_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        super.addObjectToDB(copy, query, copy.getPublisher(), copy.getISBN(), copy.getReleaseYear(), copy.getFormat(),
                copy.getLanguage(), copy.getBlurb(), copy.getStatus().name(), copy.getLibrary().getLibraryID(),
                copy.getBook().getBookID());
    }

    /**
     * Deletes a row with a specific id from the "copy" table.
     *
     * @param deleteID integer number, describing the id of the copy to be deleted
     * @see GenericDAO
     */
    public void deleteCopyFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

    /**
     * Selects all rows from the "copy" table.
     *
     * @see GenericDAO
     */
    public void selectCopyFromDB() {
        String[] columns = {"book.title", "book.author", "publisher", "isbn", "release_year", "format", "language", "blurb", "status", "library.name"};
        String join = "JOIN library ON library.library_id = copy.library_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, null, join);
    }
    /**
     * Selects all rows from the "copy" table with the specific id or ISBN.
     *
     * @param number integer number, id or ISBN of the copy to be found
     * @see GenericDAO
     */
    public void selectCopyFromDB(int number) {
        String[] columns = {"book.title", "book.author", "publisher", "isbn", "release_year", "format", "language", "blurb", "status", "library.name"};
        String condition = "copy_id = ? OR isbn = ?";
        String join = "JOIN library ON library.library_id = copy.library_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, number, number);
    }
    /**
     * Selects all rows from the "copy" table with the specific title or author..
     *
     * @param name string value, title or author of the copy to be found
     * @see GenericDAO
     */
    public void selectCopyFromDB(String name) {
        String[] columns = {"book.title", "book.author", "publisher", "isbn", "release_year", "format", "language", "blurb", "status", "library.name"};
        String condition = "book.title LIKE ? OR book.author LIKE ? ";
        String join = "JOIN library ON library.library_id = copy.library_id JOIN book ON book.book_id = copy.book_id";
        String likeName = "%" + name + "%";
        super.selectObjectFromDB(getTableName(), columns, condition, join, likeName, likeName);
    }
    /**
     * Selects all rows from the "copy" table in a specific format.
     *
     * @param format Copy.Format object, format of the copies to be found
     * @see GenericDAO
     */
    public void selectCopyFromDB(Copy.Format format) {
        String[] columns = {"book.title", "book.author", "publisher", "isbn", "release_year", "format", "language", "blurb", "status", "library.name"};
        String condition = "format = ?";
        String join = "JOIN library ON library.library_id = copy.library_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, format);
    }

    /**
     * Gets the Copy object with a specific id from the database.
     *
     * @param copyID integer number, id of the copy
     * @return Copy object extracted from the database
     * @see GenericDAO
     */
    public Copy getCopyByID(int copyID) {
        List<Result> resultList = extractFromDB(copyID);
        BookDAO bookDAO = new BookDAO();
        LibraryDAO libraryDAO = new LibraryDAO();
        for (Result result : resultList) {
            int resultCopyID = Integer.parseInt(result.getColumnValues().get("copy_id"));

            if (resultCopyID == copyID) {
                String publisher = result.getColumnValues().get("publisher");
                int bookID = Integer.parseInt(result.getColumnValues().get("book_id"));
                String isbn = result.getColumnValues().get("isbn");
                Copy.Format format = Copy.Format.valueOf(result.getColumnValues().get("format"));
                String releaseYear = result.getColumnValues().get("release_year");
                String language = result.getColumnValues().get("language");
                String blurb = result.getColumnValues().get("blurb");
                Copy.Status status = Copy.Status.valueOf(result.getColumnValues().get("status"));
                int libraryID = Integer.parseInt(result.getColumnValues().get("library_id"));

                return new Copy(copyID, bookDAO.getBookByID(bookID), publisher, isbn, format, releaseYear, language, blurb, status,
                        libraryDAO.getLibraryByID(libraryID));
            }
        }
        return null;
    }

    /**
     * Changes the library of a specific copy.
     *
     * @param copy a copy whose library is to be changed
     * @param library library object to be changed
     */
    public void alterLibraryCopyInDB(Copy copy, Library library) {
        String[] set = {"library_id = ".concat(String.valueOf(library.getLibraryID()))};
        String condition = "copy_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, copy.getCopyID());
    }
    /**
     * Changes the blurb of a specific copy.
     *
     * @param copy a copy whose blurb is to be changed
     * @param blurb string value, blurb to be changed
     */
    public void alterBlurbCopyInDB(Copy copy, String blurb) {
        String[] set = {"blurb = ".concat(blurb)};
        String condition = "copy_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, copy.getCopyID());
    }
    /**
     * Changes the status of a specific copy.
     *
     * @param copy a copy whose status is to be changed
     * @param status Copy.Status object, status to be changed
     */
    public void alterStatusCopyInDB(Copy copy, Copy.Status status) {
        String[] set = {"status = ".concat(status.name())};
        String condition = "copy_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, copy.getCopyID());
    }
    /**
     * Extracts the copy data with the specific id from the database.
     *
     * @param id integer number, id of the copy
     * @return the list with the copy data
     * @see GenericDAO
     */
    private List<Result> extractFromDB(int id) {
        String[] columns = {"copy_id", "publisher", "isbn", "release_year", "format", "language", "blurb", "status", "library_id", "book_id"};
        String condition = "copy_id = ?";
        return super.extractObjectFromDB(getTableName(), columns, condition, null, id);
    }
}
