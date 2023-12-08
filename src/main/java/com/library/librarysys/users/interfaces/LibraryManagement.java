package com.library.librarysys.users.interfaces;

import com.library.librarysys.libcollection.Library;

public interface LibraryManagement {
    String establishRules();
    String changeLibraryOpenings();
    void changeLibraryLocation(Library library, String location);
    void changeLibraryPhoneNum(Library library, String phoneNumber);
    void changeLibraryEmail(Library library, String email);
    void browseLibraries();
    void browseLibraries(String phrase);
    void browseLibraries(int libraryID);
}
