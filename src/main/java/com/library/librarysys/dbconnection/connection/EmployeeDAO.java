package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.users.Employee;

public class EmployeeDAO extends GenericDAO<Employee> {
    public EmployeeDAO() {
        super("employee");
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
}
