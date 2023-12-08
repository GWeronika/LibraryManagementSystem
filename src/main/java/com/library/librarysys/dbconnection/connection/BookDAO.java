package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Book;

import java.util.List;

public class BookDAO extends GenericDAO<Book> {
    public BookDAO() {
        super("book");
    }

    public void addBookToDB(Book book) {
        String query = "INSERT INTO book (title, author) VALUES (?, ?, ?, ?)";
        super.addObjectToDB(book, query, book.getTitle(), book.getAuthor());
    }

    public void deleteBookFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

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

    private List<Result> extractFromDB(int id) {
        String[] columns = {"book_id", "title", "author"};
        String condition = "book_id = ?";
        return super.extractObjectFromDB(getTableName(), columns, condition, null, id);
    }
}
