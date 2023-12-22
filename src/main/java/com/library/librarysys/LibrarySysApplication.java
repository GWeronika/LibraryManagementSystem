package com.library.librarysys;

import com.library.librarysys.account.Account;
import com.library.librarysys.account.Loan;
import com.library.librarysys.account.Order;
import com.library.librarysys.dbconnection.connection.LibraryDAO;
import com.library.librarysys.libcollection.Copy;
import com.library.librarysys.libcollection.Library;
import com.library.librarysys.users.Administrator;
import com.library.librarysys.users.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
public class LibrarySysApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarySysApplication.class, args);
        Account ac = new Account(999, "4", "4");
        Administrator a = new Administrator(10, "a", "c", "s", "0", ac);

        LibraryDAO lDao = new LibraryDAO();
        Library library4 = lDao.getLibraryByID(4);
        Account accc = new Account(100, "4", "4");
        Library lib = new Library(8, "f", "g", "7", "t");
        Employee e = new Employee(100, "r", "r", "r", "9", accc, Employee.Position.LIBRARIAN, lib);
//        e.orderToLoan(21);
    }

    @RestController
    public static class ReceiveDataController {
        @PostMapping("/receiveData")
        public String receiveData(@RequestBody Map<String, String> data) {
            String name = data.get("name");
            System.out.println("Odebrano imię: " + name);
            return "Imię odebrane na serwerze: " + name;
        }
    }

}