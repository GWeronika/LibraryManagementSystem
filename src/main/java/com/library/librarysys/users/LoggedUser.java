package com.library.librarysys.users;
import com.library.librarysys.account.Account;

import com.library.librarysys.dbconnection.connection.AccountDAO;
import com.library.librarysys.dbconnection.connection.EmployeeDAO;
import com.library.librarysys.dbconnection.connection.ReaderDAO;
import com.library.librarysys.interfaces.Identifiable;
import com.library.password.PasswordEncoder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.security.NoSuchAlgorithmException;

/**
 * A class representing a logged user in the library system.
 * It contains functionalities that can be used by logged users.
 */
@ToString
@Getter
public abstract class LoggedUser extends User implements Identifiable {
    private final String firstname;
    @Setter private String lastname;
    @Setter private String address;
    @Setter private String phoneNum;
    private final Account account;

    /**
     * Constructor for the LoggedUser class that is inherited
     * by the Employee, Administrator and Reader classes.
     *
     * @param firstname string value, logged user first name
     * @param lastname string value, logged user last name
     * @param address string value, logged user address
     * @param phoneNum string value, logged user phone number
     * @param account reference to a logged user account
     */
    public LoggedUser(String firstname, String lastname, String address, String phoneNum, Account account) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phoneNum = phoneNum;
        this.account = account;
    }

    /**
     * Changes the password of the logged user.
     *
     * @param password password to be changed
     * @see     AccountDAO
     */
    public void changePassword(String password) {
        AccountDAO dao = new AccountDAO();
        dao.alterPasswordAccountInDB(this, password);
        this.account.setPassword(password);
    }

    /**
     * Checks whether the user has entered the correct email and password
     * and then recognizes the user
     *
     * @param email of the user to log in
     * @param password password to log in
     * @return LoggedUser whose account is logged in
     * @see     AccountDAO EmployeeDAO ReaderDAO
     */
    public LoggedUser logIn(String email, String password) {
        try {
            AccountDAO dao = new AccountDAO();
            Account account = dao.getAccountByEmail(email);

            if (account != null) {
                String salt = account.getSalt();
                String hashedPassword = PasswordEncoder.hashPassword(password, salt);

                if (hashedPassword.equals(account.getPassword())) {
                    System.out.println("Zalogowano pomyślnie.");
                    if(getEmailUsername(email).equals("employee")) {
                        EmployeeDAO DAO = new EmployeeDAO();
                        return DAO.getEmployeeByAccountID(account.getAccountID());
                    } else if(getEmailUsername(email).equals("admin")) {
                        System.out.println("Jesteś adminem");
                    } else {
                        ReaderDAO DAO = new ReaderDAO();
                        return DAO.getReaderByAccountID(account.getAccountID());
                    }
                } else {
                    System.out.println("Błędne hasło.");
                }
            } else {
                System.out.println("Nie znaleziono konta o podanym adresie email.");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Recognizes the user by his email address.
     *
     * @param email of the user to log in
     */
    private static String getEmailUsername(String email) {
        int atIndex = email.indexOf('@');
        int dotIndex = email.indexOf('.', atIndex);
        if (atIndex != -1 && dotIndex != -1) {
            return email.substring(atIndex + 1, dotIndex);
        } else {
            return "";
        }
    }

}