package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Library;
import com.library.librarysys.users.Employee;

public class EmployeeDAO extends GenericDAO<Employee> {
    public EmployeeDAO() {
        super("employee");
    }

    public void addEmployeeToDB(Employee employee) {
        String query = "INSERT INTO employee (first_name, last_name, address, phone_number, position, library_id, account_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        super.addObjectToDB(employee, query, employee.getFirstname(), employee.getLastname(), employee.getAddress(),
                employee.getPhoneNum(), employee.getPosition().name(), employee.getLibrary().getLibraryID(),
                employee.getAccount().getAccountID());
    }

    public void deleteEmployeeFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

    public void selectEmployeeFromDB() {
        String[] columns = {"first_name", "last_name", "address", "employee.phone_number", "position", "library.name"};
        String join = "JOIN library ON library.library_id = employee.library_id";
        super.selectObjectFromDB(getTableName(), columns, null, join);
    }
    public void selectEmployeeFromDB(int id) {      //search by id
        String[] columns = {"first_name", "last_name", "address", "employee.phone_number", "position", "library.name"};
        String condition = "employee_id = ?";
        String join = "JOIN library ON library.library_id = employee.library_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, id);
    }
    public void selectEmployeeFromDB(String name) {      //search by firstname or lastname
        String[] columns = {"first_name", "last_name", "address", "employee.phone_number", "position", "library.name"};
        String condition = "first_name = ? OR last_name = ?";
        String join = "JOIN library ON library.library_id = employee.library_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, name, name);
    }
    public void selectEmployeeFromDB(Employee.Position position) {      //search by position
        String[] columns = {"first_name", "last_name", "address", "employee.phone_number", "position", "library.name"};
        String condition = "position = ?";
        String join = "JOIN library ON library.library_id = employee.library_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, position);
    }

    public void alterLastNameInDB(Employee employee, String lastName) {
        String[] set = {"last_name = ".concat(lastName)};
        String condition = "employee_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, employee.getEmployeeID());
    }
    public void alterAddressInDB(Employee employee, String address) {
        String[] set = {"address = ".concat(address)};
        String condition = "employee_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, employee.getEmployeeID());
    }
    public void alterPhoneNumInDB(Employee employee, String number) {
        String[] set = {"phone_number = ".concat(number)};
        String condition = "employee_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, employee.getEmployeeID());
    }
    public void alterPositionInDB(Employee employee, Employee.Position position) {
        String[] set = {"position = ".concat(String.valueOf(position))};
        String condition = "employee_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, employee.getEmployeeID());
    }public void alterLibraryInDB(Employee employee, Library library) {
        String[] set = {"library_id = ".concat(String.valueOf(library))};
        String condition = "employee_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, employee.getEmployeeID());
    }

}
