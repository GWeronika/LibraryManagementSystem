package com.library.librarysys.users.interfaces;

import com.library.librarysys.interfaces.Identifiable;
import com.library.librarysys.users.interfaces.management.CopyManagement;
import com.library.librarysys.users.interfaces.management.LoanOrderManagement;
import com.library.librarysys.users.interfaces.management.PersonalData;

public interface IEmployee extends Identifiable, PersonalData, LoanOrderManagement, CopyManagement, ILoggedUser {
}
