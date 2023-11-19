package com.library.librarysys.account;

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
public class Loan {
    private final int loanID;
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

    public Loan(int loanID, Copy copy, LocalDate loanDate, LocalDate returnDate, Status status, Reader reader, Employee employee) {
        this.loanID = loanID;
        this.copy = copy;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.status = status;
        this.reader = reader;
        this.employee = employee;
    }
}
