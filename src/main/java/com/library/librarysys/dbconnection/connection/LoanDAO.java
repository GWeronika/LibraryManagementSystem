package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.account.Loan;
import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.openingformat.Result;
import com.library.librarysys.users.Reader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that is responsible for connecting to the "loan" table in the library system.
 * It provides methods that execute basic operations on the loan table.
 * Extends the GenericDAO class.
 *
 * @see GenericDAO
 */
public class LoanDAO extends GenericDAO<Loan> {
    public LoanDAO() {
        super("loan");
    }

    /**
     * Adds a new row to the "loan" table.
     *
     * @param loan Loan object to be added
     * @see GenericDAO
     */
    public boolean addLoanToDB(Loan loan) {
        String query = "INSERT INTO loan (loan_date, return_date, loan.status, employee_id, copy_id, reader_id) VALUES (?, ?, ?, ?, ?, ?)";
        return super.addObjectToDB(loan, query, java.sql.Date.valueOf(loan.getLoanDate()), java.sql.Date.valueOf(loan.getReturnDate()), loan.getStatus().name(),
                loan.getEmployee().getEmployeeID(), loan.getCopy().getCopyID(), loan.getReader().getReaderID());
    }

    /**
     * Deletes a row with a specific id from the "loan" table.
     *
     * @param deleteID integer number, describing the id of the loan to be deleted
     * @see GenericDAO
     */
    public void deleteLoanFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

    /**
     * Selects all rows from the "loan" table.
     *
     * @see GenericDAO
     */
    public void selectLoansFromDB() {
        String[] columns = {"loan_date", "return_date", "loan.status", "book.title", "book.author"};
        String join = "JOIN copy ON loan.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, null, join);
    }
    /**
     * Selects all rows from the "loan" table with the specific id.
     *
     * @param id integer number, id of the loan to be found
     * @see GenericDAO
     */
    public void selectLoansFromDB(int id) {      //search by id
        String[] columns = {"loan_date", "return_date", "loan.status", "book.title", "book.author"};
        String condition = "loan_id = ?";
        String join = "JOIN copy ON loan.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, id);
    }
    /**
     * Selects all rows from the "loan" table with the given status.
     *
     * @param status Loan.Status object, status of the loan to be found
     * @see GenericDAO
     */
    public void selectLoansFromDB(Loan.Status status) {      //search by status
        String[] columns = {"loan_date", "return_date", "loan.status", "book.title", "book.author"};
        String condition = "loan.status = ?";
        String join = "JOIN copy ON loan.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, status);
    }
    /**
     * Selects all rows from the "loan" table with the given id and status.
     *
     * @param reader Reader object, reader whose loans will be shown
     * @param status Loan.Status object, status of the loan to be found
     * @see GenericDAO
     */
    public void selectLoansFromDB(Reader reader, Loan.Status status) {
        String[] columns = {"loan_date", "return_date", "loan.status", "book.title", "book.author"};
        String condition = "loan.status = ? AND reader_id = ?";
        String join = "JOIN copy ON loan.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, status, reader.getReaderID());
    }
    public void selectLoansFromDB(Reader reader) {
        String[] columns = {"loan_date", "return_date", "loan.status", "book.title", "book.author"};
        String condition = "reader_id = ?";
        String join = "JOIN copy ON loan.copy_id = copy.copy_id JOIN book ON book.book_id = copy.book_id";
        super.selectObjectFromDB(getTableName(), columns, condition, join, reader.getReaderID());
    }

    /**
     * Gets the Loan object with a specific id from the database.
     *
     * @param loanID integer number, id of the loan
     * @return Loan object extracted from the database
     * @see GenericDAO
     */
    public Loan getLoanByID(int loanID) {
        List<Result> resultList = extractFromDB("loan_id", loanID);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        CopyDAO copyDAO = new CopyDAO();
        ReaderDAO readerDAO = new ReaderDAO();
        for (Result result : resultList) {
            int resultLoanID = Integer.parseInt(result.getColumnValues().get("loan_id"));

            if (resultLoanID == loanID) {
                LocalDate loanDate = LocalDate.parse(result.getColumnValues().get("loan_date"));
                LocalDate returnDate = LocalDate.parse(result.getColumnValues().get("return_date"));
                Loan.Status status = Loan.Status.valueOf(result.getColumnValues().get("loan.status"));
                int employeeID = Integer.parseInt(result.getColumnValues().get("employee_id"));
                int copyID = Integer.parseInt(result.getColumnValues().get("copy_id"));
                int readerID = Integer.parseInt(result.getColumnValues().get("reader_id"));

                return new Loan(resultLoanID, loanDate, returnDate, status, copyDAO.getCopyByID(copyID),
                        readerDAO.getReaderByID(readerID), employeeDAO.getEmployeeByID(employeeID));
            }
        }
        return null;
    }
    /**
     * Gets the Loan object with a specific reader id from the database.
     *
     * @param readerID integer number, id of the reader
     * @return ArrayList loans extracted from the database
     * @see GenericDAO
     */
    public ArrayList<Loan> getLoanByReaderID(int readerID) {
        List<Result> resultList = extractFromDB("reader_id", readerID);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        CopyDAO copyDAO = new CopyDAO();
        ReaderDAO readerDAO = new ReaderDAO();
        ArrayList<Loan> loansList = new ArrayList<>();
        for (Result result : resultList) {
            int resultLoanReaderID = Integer.parseInt(result.getColumnValues().get("reader_id"));

            if (resultLoanReaderID == readerID) {
                int loan_id = Integer.parseInt(result.getColumnValues().get("loan_id"));
                LocalDate loanDate = LocalDate.parse(result.getColumnValues().get("loan_date"));
                LocalDate returnDate = LocalDate.parse(result.getColumnValues().get("return_date"));
                Loan.Status status = Loan.Status.valueOf(result.getColumnValues().get("loan.status"));
                int employeeID = Integer.parseInt(result.getColumnValues().get("employee_id"));
                int copyID = Integer.parseInt(result.getColumnValues().get("copy_id"));

                Loan loan = new Loan(loan_id, loanDate, returnDate, status, copyDAO.getCopyByID(copyID), readerDAO.getReaderByID(resultLoanReaderID),
                        employeeDAO.getEmployeeByID(employeeID));
                loansList.add(loan);
            }
        }
        return loansList;
    }
    /**
     * Gets the Loan object with a copy id from the database.
     *
     * @param copyID integer number, id of the copy
     * @return ArrayList loans extracted from the database
     * @see GenericDAO
     */
    public ArrayList<Loan> getLoanByCopyID(int copyID) {
        List<Result> resultList = extractFromDB("copy_id", copyID);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        CopyDAO copyDAO = new CopyDAO();
        ReaderDAO readerDAO = new ReaderDAO();
        ArrayList<Loan> loansList = new ArrayList<>();
        for (Result result : resultList) {
            int resultLoanCopyID = Integer.parseInt(result.getColumnValues().get("copy_id"));

            if (resultLoanCopyID == copyID) {
                int loan_id = Integer.parseInt(result.getColumnValues().get("loan_id"));
                LocalDate loanDate = LocalDate.parse(result.getColumnValues().get("loan_date"));
                LocalDate returnDate = LocalDate.parse(result.getColumnValues().get("return_date"));
                Loan.Status status = Loan.Status.valueOf(result.getColumnValues().get("loan.status"));
                int employeeID = Integer.parseInt(result.getColumnValues().get("employee_id"));
                int readerID = Integer.parseInt(result.getColumnValues().get("reader_id"));

                Loan loan = new Loan(loan_id, loanDate, returnDate, status, copyDAO.getCopyByID(resultLoanCopyID), readerDAO.getReaderByID(readerID),
                        employeeDAO.getEmployeeByID(employeeID));
                loansList.add(loan);
            }
        }
        return loansList;
    }

    /**
     * Changes the return date of a specific loan.
     *
     * @param loan a loan whose return date is to be changed
     * @param returnDate LocalDate object, return date to be changed
     */
    public void alterReturnDateInDB(Loan loan, LocalDate returnDate) {
        String[] set = {"return_date = '".concat(String.valueOf(returnDate)) + "'"};
        String condition = "loan_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, loan.getLoanID());
    }
    /**
     * Changes the status of a specific loan.
     *
     * @param loan a loan whose status is to be changed
     * @param status Loan.Status object, status to be changed
     */
    public void alterStatusInDB(Loan loan, Loan.Status status) {
        String[] set = {"loan.status = '".concat(String.valueOf(status)).concat("'")};
        String condition = "loan_id = ?";
        super.alterObjectInDB(getTableName(), set, condition, loan.getLoanID());
    }

    /**
     * Extracts the loan data with the specific id from the database.
     *
     * @param columnName name of the column in the condition
     * @param idValue integer number, searched id
     * @return the list with the loan data
     * @see GenericDAO
     */
    private List<Result> extractFromDB(String columnName, int idValue) {
        String[] columns = {"loan_id", "loan_date", "return_date", "loan.status", "employee_id", "copy_id", "reader_id"};
        String condition = columnName + " = ?";
        return super.extractObjectFromDB(getTableName(), columns, condition, null, idValue);
    }
}
