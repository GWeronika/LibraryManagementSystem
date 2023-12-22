package com.library.librarysys.users.interfaces.management;

import com.library.librarysys.libcollection.Library;
import com.library.librarysys.libcollection.Opening;


public interface LibraryManagement {
    void changeLibraryOpenings(Library library, Opening opening);
    void changeLibraryLocation(Library library, String location);
    void changeLibraryPhoneNum(Library library, String phoneNumber);
    void changeLibraryEmail(Library library, String email);
}
