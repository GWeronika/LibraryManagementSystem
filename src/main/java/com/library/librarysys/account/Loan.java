package com.library.librarysys.account;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.interfaces.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.library.librarysys.libcollection.Copy;
import com.library.librarysys.users.Reader;
import com.library.librarysys.users.Employee;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@Getter
public class Loan implements Identifiable {
    private int loanID;
    private final Copy copy;
    private final LocalDate loanDate;
    @Setter private LocalDate returnDate;
    @Setter private Status status;
    private final Reader reader;
    private final Employee employee;

    public enum Status {
        ACTIVE,
        OVERDUE,
        RETURNED
    }

    @Override
    public void setID(int newID) { this.loanID = newID; }

    public Loan(int loanID, Copy copy, Reader reader, Employee employee) {
        this.loanID = loanID;
        this.copy = copy;
        this.loanDate = LocalDate.now();
        this.returnDate = this.loanDate.plusDays(30);
        this.status = Status.ACTIVE;
        this.reader = reader;
        this.employee = employee;
    }

    public void addLoanToDB() {
        GenericDAO<Loan> loanDAO = new GenericDAO<>("loan");

        String query = "INSERT INTO loan (loan_date, return_date, status, employee_id, copy_id, reader_id) VALUES (?, ?, ?, ?, ?, ?)";
        loanDAO.addObjectToDB(this, query, getLoanDate(), getReturnDate(), status.name(), employee.getEmployeeID(), copy.getCopyID(), reader.getReaderID());
    }
}
