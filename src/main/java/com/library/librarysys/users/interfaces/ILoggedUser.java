package com.library.librarysys.users.interfaces;

import com.library.librarysys.users.LoggedUser;

public interface ILoggedUser extends IUser {
    void changePassword(String password);
    LoggedUser logIn(String email, String password);
}
