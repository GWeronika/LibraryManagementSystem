package com.library.librarysys.users.interfaces;

import com.library.librarysys.libcollection.Copy;

public interface IUser {
    void browseBooks();
    void browseBooks(int number);
    void browseBooks(String phrase);
    void browseBooks(Copy.Format format);
    void browseLibraries();
    void browseLibraries(String phrase);
    void browseLibraries(int libraryID);
}