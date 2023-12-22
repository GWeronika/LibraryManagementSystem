package com.library.librarysys.users.interfaces;

import com.library.librarysys.users.interfaces.management.AdministratorManagement;
import com.library.librarysys.users.interfaces.management.EmployeeManagement;
import com.library.librarysys.users.interfaces.management.LibraryManagement;
import com.library.librarysys.users.interfaces.management.ReaderManagement;

public interface IAdministrator extends EmployeeManagement, ReaderManagement, LibraryManagement, AdministratorManagement, IUser {
}
