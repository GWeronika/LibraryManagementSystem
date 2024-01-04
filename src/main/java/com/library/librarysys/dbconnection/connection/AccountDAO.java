package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.account.Account;
import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.openingformat.Result;
import com.library.librarysys.users.LoggedUser;
import com.library.librarysys.users.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class that is responsible for connecting to the "account" table in the library system.
 * It provides methods that execute basic operations on the account table.
 * Extends the GenericDAO class
 *
 * @see GenericDAO
 */
public class AccountDAO extends GenericDAO<Account> {
    public AccountDAO() {
        super("account");
    }

    /**
     * Adds a new row to the "account" table.
     *
     * @param account Account object to be added
     * @see GenericDAO
     */
    public void addAccountToDB(Account account) {
        System.out.println(account.getPassword());
        if (passVerification(account.getPassword())) {
            if(emailVerification(account.getEmail())) {
                String query = "INSERT INTO account (email, password, salt) VALUES (?, ?, ?)";
                super.addObjectToDB(account, query, account.getEmail(), account.getPassword(), account.getSalt());
            } else {
                System.out.println("Niepoprawny adres email");
            }
        } else {
            System.out.println("Hasło nie spełnia wymagań. Wymagania: 8 znaków -> wielka litera, mała litera, cyfra," +
                    " znak specjalny spośród {@#$%^&+=!.)");
        }
    }

    /**
     * Deletes a row with a specific id from the "account" table.
     *
     * @param deleteID integer number, describing the id of the account to be deleted
     * @see GenericDAO
     */
    public void deleteAccountFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

    /**
     * Gets the Account object with a specific id from the database.
     *
     * @param accountID integer number, id of the account
     * @return Account object extracted from the database
     * @see GenericDAO
     */
    public Account getAccountByID(int accountID) {
        List<Result> resultList = extractFromDB("account_id", accountID);
        for (Result result : resultList) {
            int resultAccountID = Integer.parseInt(result.getColumnValues().get("account_id"));

            if (resultAccountID == accountID) {
                String email = result.getColumnValues().get("email");
                String password = result.getColumnValues().get("password");
                String salt = result.getColumnValues().get("salt");

                return new Account(resultAccountID, email, password, salt);
            }
        }
        return null;
    }
    /**
     * Gets the Account object with a specific email from the database.
     *
     * @param email String value, email of the account
     * @return Account object extracted from the database
     * @see GenericDAO
     */
    public Account getAccountByEmail(String email) {
        List<Result> resultList = extractFromDB("email", email);
        ArrayList<Account> accountsList = new ArrayList<>();
        for (Result result : resultList) {
            String resultAccountEmail = result.getColumnValues().get("email");

            if (Objects.equals(resultAccountEmail, email)) {
                int accountID = Integer.parseInt(result.getColumnValues().get("account_id"));
                String password = result.getColumnValues().get("password");
                String salt = result.getColumnValues().get("salt");

                return new Account(accountID, resultAccountEmail, password, salt);
            }
        }
        return null;
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
            String[] set = {"password = '".concat(password) + "'"};
            String condition = "account_id = ?";
            super.alterObjectInDB(getTableName(), set, condition, loggedUser.getAccount().getAccountID());
        } else {
            System.out.println("Hasło nie spełnia wymagań. Wymagania: 8 znaków -> wielka litera, mała litera, cyfra," +
                    " znak specjalny spośród {@#$%^&+=!.)");
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
            String[] set = {"email = '".concat(email) + "'"};
            String condition = "account_id = ?";
            super.alterObjectInDB(getTableName(), set, condition, reader.getAccount().getAccountID());
        } else {
            System.out.println("Niepoprawny adres email");
        }
    }

    /**
     * Checks whether there are duplicated emails in the account table.
     *
     * @param email email duplicate to be found
     * @return integer number referring to the id of the repeated email
     * @see GenericDAO
     */
    public int checkDuplicate(String email) {
        String[] columns = {"email"};
        return super.checkDuplicate(getTableName(), columns, email);
    }

    /**
     * Checks whether the given password meet the specified requirements.
     *
     * @param password string value, describing the password to be saved
     * @return true if password meets the requirements, false otherwise
     * @see GenericDAO
     */
    private boolean passVerification(String password) {
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    /**
     * Checks whether the given email meet the specified requirements.
     *
     * @param email string value, describing the email to be saved
     * @return true if password meets the requirements, false otherwise
     * @see GenericDAO
     */
    private boolean emailVerification(String email) {
        final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    /**
     * Extracts the account data with the specific id from the database.
     *
     * @param id integer number, id of the account
     * @param columnName name of the column in the condition
     * @return the list with the account data
     * @see GenericDAO
     */
    private List<Result> extractFromDB(String columnName, int id) {
        String[] columns = {"account_id", "email", "password", "salt"};
        String condition = columnName + " = ?";
        return super.extractObjectFromDB(getTableName(), columns, condition, null, id);
    }
    /**
     * Extracts the account data with the specific id from the database.
     *
     * @param name String value, email of the account
     * @param columnName name of the column in the condition
     * @return the list with the account data
     * @see GenericDAO
     */
    private List<Result> extractFromDB(String columnName, String name) {
        String[] columns = {"account_id", "email", "password", "salt"};
        String condition = columnName + " = ?";
        return super.extractObjectFromDB(getTableName(), columns, condition, null, name);
    }
}
