package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.account.Account;
import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.users.LoggedUser;
import com.library.librarysys.users.Reader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountDAO extends GenericDAO<Account> {
    public AccountDAO() {
        super("account");
    }

    //later add double pass verification
    public void addAccountToDB(Account account) {
        if (passVerification(account.getPassword())) {
            if(emailVerification(account.getEmail())) {
                String query = "INSERT INTO account (email, password) VALUES (?, ?)";
                super.addObjectToDB(account, query, account.getEmail(), account.getPassword());
            } else {
                System.out.println("Niepoprawny adres email");
            }
        } else {
            System.out.println("Hasło nie spełnia wymagań. Wymagania: 8 znaków -> wielka litera, mała litera, cyfra," +
                    " znak specjalny spośród {@#$%^&+=!)");
        }
    }

    public void deleteAccountFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

    /**
     * Changes the password of a specific loggedUser.
     * The function includes verification that all password
     * requirements are met
     *
     * @param loggedUser    a person whose password is changed
     * @param password     a new password
     */
    public void alterPasswordAccountInDB(LoggedUser loggedUser, String password) {  //double pass as well
        if(passVerification(password)) {
            String[] set = {"password = ".concat(password)};
            String condition = "account_id = ?";
            super.alterObjectInDB(getTableName(), set, condition, loggedUser.getAccount().getAccountID());
        } else {
            System.out.println("Hasło nie spełnia wymagań. Wymagania: 8 znaków -> wielka litera, mała litera, cyfra," +
                    " znak specjalny spośród {@#$%^&+=!)");
        }
    }

    /**
     * Changes the email of a specific reader.
     * Attention: employees cannot change email.
     *
     * @param reader    a reader whose password is changed
     * @param email     a new email
     */
    public void alterEmailAccountInDB(Reader reader, String email) {
        if(emailVerification(email)) {
            String[] set = {"email = ".concat(email)};
            String condition = "account_id = ?";
            super.alterObjectInDB(getTableName(), set, condition, reader.getAccount().getAccountID());
        } else {
            System.out.println("Niepoprawny adres email");
        }
    }

    private boolean passVerification(String password) {
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private boolean emailVerification(String email) {
        final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
