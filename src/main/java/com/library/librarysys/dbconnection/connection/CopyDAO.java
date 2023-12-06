package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Copy;

public class CopyDAO extends GenericDAO<Copy> {
    public CopyDAO() {
        super("copy");
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
        String condition = "book.title LIKE ? OR book.author LIKE ?";
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

}
