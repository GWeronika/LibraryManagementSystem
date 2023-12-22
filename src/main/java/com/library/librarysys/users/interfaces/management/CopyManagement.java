package com.library.librarysys.users.interfaces.management;

import com.library.librarysys.libcollection.Copy;
import com.library.librarysys.libcollection.Library;

public interface CopyManagement {
    void moveCopyToLibrary(Copy copy, Library library);
    void changeCopyBlurb(Copy copy, String blurb);
    void changeCopyStatus(Copy copy, Copy.Status status);
    void addBookToResources(Copy copy);
    void orderNewBook(String title, String author, String publisher, String isbn, String releaseYear,
                      Copy.Format format, String language, String blurb, Library library);

    }