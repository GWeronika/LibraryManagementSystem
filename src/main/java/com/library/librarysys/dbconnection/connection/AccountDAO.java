package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.account.Account;
import com.library.librarysys.dbconnection.GenericDAO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountDAO extends GenericDAO<Account> {
    public AccountDAO() {
        super("account");
    }

    //later add double pass verification
    public void addAccountToDB(Account account) {
        if (passVerification(account.getPassword())) {
            GenericDAO<Account> accountDAO = new GenericDAO<>("account");
            String query = "INSERT INTO account (email, password) VALUES (?, ?)";
            accountDAO.addObjectToDB(account, query, account.getEmail(), account.getPassword());
        } else {
            System.out.println("Password does not meet the requirements.");
        }
    }

    public void deleteAccountFromDB(int deleteID) {
        GenericDAO<Account> accountDAO = new GenericDAO<>("account");
        accountDAO.deleteObjectFromDB(deleteID);
    }

    private boolean passVerification(String password) {
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}
