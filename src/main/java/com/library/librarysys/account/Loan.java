package com.library.librarysys.account;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
public class Loan {
    private int loanID;
    private LocalDate loanDate;
    @Setter private LocalDate returnDate;
    private enum Status {
        ACTIVE,
        OVERDUE,
        RETURNED
    }
}
