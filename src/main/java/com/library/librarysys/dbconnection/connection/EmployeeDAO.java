package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Library;
import com.library.librarysys.openingformat.Result;
import com.library.librarysys.users.Employee;

import java.util.List;

/**
 * A class that is responsible for connecting to the "employee" table in the library system.
 * It provides methods that execute basic operations on the employee table.
 * Extends the GenericDAO class
 *
 * @see GenericDAO
 */
public class EmployeeDAO extends GenericDAO<Employee> {
    public EmployeeDAO() {
        super("employee");
    }

    /**
     * Adds a new row to the "employee" table.
     *
     * @param employee Employee object to be added
     * @see GenericDAO
     */
    public void addEmployeeToDB(Employee employee) {
        String query = "INSERT INTO employee (first_name, last_name, address, employee.phone_number, position, library_id, account_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        super.addObjectToDB(employee, query, employee.getFirstname(), employee.getLastname(), employee.getAddress(),
                employee.getPhoneNum(), employee.getPosition().name(), employee.getLibrary().getLibraryID(),
                employee.getAccount().getAccountID());
    }

    /**
     * Deletes a row with a specific id from the "employee" table.
     *
     * @param deleteID integer number, describing the id of the employee to be deleted
     * @see GenericDAO
     */
    public void deleteEmployeeFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

    /**
     * Selects all rows from the "employee" table.
     *
     * @see GenericDAO
     */
    public void selectEmployeeFromDB() {
        String[] columns = {"first_name", "last_name", "address", "employee.phone_number", "position", "library.name"};
        String join = "JOIN library ON library.library_id = employee.library_id";
        super.selectObjectFromDB(getTableName(), columns, null, join);
    }
    /**
     * Selects all rows from the "employee" table with the specific id.
     *
     * @param id integer number, id of the employee to be found
     * @see GenericDAO
     */
    public void selectEmployeeFromDB(int id) {      //search by id
        String[] columns = {"first_name", "last_name", "address", "employee.phone_number", "position", "library.name"};
        String condition = "employee_id = ?";
        String join = "JOIN library ON library.library_id = employee.library_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, id);
    }
    /**
     * Selects all rows from the "employee" table with the given first- or last name.
     *
     * @param name string value, first- or last name of the employee to be found
     * @see GenericDAO
     */
    public void selectEmployeeFromDB(String name) {      //search by firstname or lastname
        String[] columns = {"first_name", "last_name", "address", "employee.phone_number", "position", "library.name"};
        String condition = "first_name = ? OR last_name = ?";
        String join = "JOIN library ON library.library_id = employee.library_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, name, name);
    }
    /**
     * Selects all rows from the "employee" table with the given position.
     *
     * @param position Employee.Position object, position of the employees to be found
     * @see GenericDAO
     */
    public void selectEmployeeFromDB(Employee.Position position) {      //search by position
        String[] columns = {"first_name", "last_name", "address", "employee.phone_number", "position", "library.name"};
        String condition = "position = ?";
        String join = "JOIN library ON library.library_id = employee.library_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, position);
    }

    /**
     * Gets the Employee object with a specific id from the database.
     *
     * @param employeeID integer number, id of the employee
     * @return Employee object extracted from the database
     * @see GenericDAO
     */
    public Employee getEmployeeByID(int employeeID) {
        List<Result> resultList = extractFromDB(employeeID);
        AccountDAO accountDAO = new AccountDAO();
        LibraryDAO libraryDAO = new LibraryDAO();
        for (Result result : resultList) {
            int resultEmployeeID = Integer.parseInt(result.getColumnValues().get("employee_id"));

            if (resultEmployeeID == employeeID) {
                String firstName = result.getColumnValues().get("first_name");
                String lastName = result.getColumnValues().get("last_name");
                String address = result.getColumnValues().get("address");
                String phoneNumber = result.getColumnValues().get("employee.phone_number");
                Employee.Position position = Employee.Position.valueOf(result.getColumnValues().get("position"));
                int libraryID = Integer.parseInt(result.getColumnValues().get("library_id"));
                int accountID = Integer.parseInt(result.getColumnValues().get("account_id"));

                return new Employee(resultEmployeeID, firstName, lastName, address, phoneNumber, accountDAO.getAccountByID(accountID),
                        position, libraryDAO.getLibraryByID(libraryID));
            }
        }
        return null;
    }

    /**
     * Changes the last name of a specific employee.
     *
     * @param employee an employee whose last name is to be changed
     * @param lastName string value, last name to be changed
     */
    public void alterLastNameInDB(Employee employee, String lastName) {
        String[] set = {"last_name = '".concat(lastName) + "'"};
        String condition = "employee_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, employee.getEmployeeID());
    }
    /**
     * Changes the address of a specific employee.
     *
     * @param employee an employee whose address is to be changed
     * @param address string value, address to be changed
     */
    public void alterAddressInDB(Employee employee, String address) {
        String[] set = {"address = '".concat(address) + "'"};
        String condition = "employee_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, employee.getEmployeeID());
    }
    /**
     * Changes the phone number of a specific employee.
     *
     * @param employee an employee whose phone number is to be changed
     * @param number string value, phone number to be changed
     */
    public void alterPhoneNumInDB(Employee employee, String number) {
        String[] set = {"employee.phone_number = '".concat(number) + "'"};
        String condition = "employee_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, employee.getEmployeeID());
    }
    /**
     * Changes the position of a specific employee.
     *
     * @param employee an employee whose address is to be changed
     * @param position Employee.Position object, position to be changed
     */
    public void alterPositionInDB(Employee employee, Employee.Position position) {
        String[] set = {"position = '".concat(String.valueOf(position)) + "'"};
        String condition = "employee_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, employee.getEmployeeID());
    }
    /**
     * Changes the library of a specific employee.
     *
     * @param employee an employee whose library is to be changed
     * @param library library object to be changed
     */public void alterLibraryInDB(Employee employee, Library library) {
        String[] set = {"library_id = ".concat(String.valueOf(library))};
        String condition = "employee_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, employee.getEmployeeID());
    }

    /**
     * Extracts the employee data with the specific id from the database.
     *
     * @param id integer number, id of the employee
     * @return the list with the employee data
     * @see GenericDAO
     */
    private List<Result> extractFromDB(int id) {
        String[] columns = {"employee_id", "first_name", "last_name", "address", "employee.phone_number", "position",
                "library_id", "account_id"};
        String condition = "employee_id = ?";
        return super.extractObjectFromDB(getTableName(), columns, condition, null, id);
    }
}
