package com.library.librarysys.users.interfaces.management;

import com.library.librarysys.libcollection.Library;
import com.library.librarysys.users.Employee;

public interface EmployeeManagement {
    void deleteEmployee(int employeeID);
    void showEmployees();
    void showEmployees(int employeeID);
    void showEmployees(String name);
    void showEmployees(Employee.Position position);
    void changeEmployeePosition(Employee employee, Employee.Position position);
    void changeEmployeeLibrary(Employee employee, Library library);
    void confirmEmployee(String firstName, String secondName);
}
