package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Book;

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
}
