package com.library.librarysys.users.interfaces.management;

import com.library.librarysys.libcollection.Copy;
import com.library.librarysys.libcollection.Library;

public interface CopyManagement {
    void moveCopyToLibrary(Copy copy, Library library);
    void changeCopyBlurb(Copy copy, String blurb);
    void changeCopyStatus(Copy copy, Copy.Status status);
    void addBookToResources(Copy copy);
    void browseBooks();
    void browseBooks(int number);
    void browseBooks(String phrase);
    void browseBooks(Copy.Format format);
}