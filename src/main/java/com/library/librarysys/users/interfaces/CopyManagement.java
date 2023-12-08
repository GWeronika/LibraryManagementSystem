package com.library.librarysys.users.interfaces;

import com.library.librarysys.libcollection.Copy;
import com.library.librarysys.libcollection.Library;

public interface CopyManagement {
    void moveCopyToLibrary(Copy copy, Library library);
    void changeCopyBlurb(Copy copy, String blurb);
    void changeCopyStatus(Copy copy, Copy.Status status);
    String addBookToResources();
    void browseBooks();
    void browseBooks(int number);
    void browseBooks(String phrase);
    void browseBooks(Copy.Format format);
}