package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Book;
import com.library.librarysys.openingformat.Result;

import java.util.List;

/**
 * A class that is responsible for connecting to the "book" table in the library system.
 * It provides methods that execute basic operations on the book table.
 * Extends the GenericDAO class
 *
 * @see GenericDAO
 */
public class BookDAO extends GenericDAO<Book> {
    public BookDAO() {
        super("book");
    }

    /**
     * Adds a new row to the "book" table.
     *
     * @param book Book object to be added
     * @see GenericDAO
     */
    public void addBookToDB(Book book) {
        String query = "INSERT INTO book (title, author) VALUES (?, ?)";
        super.addObjectToDB(book, query, book.getTitle(), book.getAuthor());
    }

    /**
     * Deletes a row with a specific id from the "book" table.
     *
     * @param deleteID integer number, describing the id of the book to be deleted
     * @see GenericDAO
     */
    public void deleteBookFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

    /**
     * Gets the Book object with a specific id from the database.
     *
     * @param bookID integer number, id of the book
     * @return Book object extracted from the database
     * @see GenericDAO
     */
    public Book getBookByID(int bookID) {
        List<Result> resultList = extractFromDB(bookID);
        for (Result result : resultList) {
            int resultCopyID = Integer.parseInt(result.getColumnValues().get("book_id"));

            if (resultCopyID == bookID) {
                String title = result.getColumnValues().get("title");
                String author = result.getColumnValues().get("author");

                return new Book(resultCopyID, title, author);
            }
        }
        return null;
    }

    /**
     * Checks whether there are duplicated title and author in the book table.
     *
     * @param title title duplicate to be found
     * @param author author duplicate to be found
     * @return integer number referring to the id of the repeated title and author
     * @see GenericDAO
     */
    public int checkDuplicate(String title, String author) {
        String[] columns = {"title", "author"};
        return super.checkDuplicate(getTableName(), columns, title, author);
    }

    /**
     * Extracts the book data with the specific id from the database.
     *
     * @param id integer number, id of the book
     * @see GenericDAO
     */
    private List<Result> extractFromDB(int id) {
        String[] columns = {"book_id", "title", "author"};
        String condition = "book_id = ?";
        return super.extractObjectFromDB(getTableName(), columns, condition, null, id);
    }
}
