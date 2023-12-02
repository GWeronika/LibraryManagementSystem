package com.library.librarysys.account;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.interfaces.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ToString
@EqualsAndHashCode
@Getter @Setter
public class Account implements Identifiable {
    private int accountID;
    private String email;
    private String password;

    public Account(int accountID, String email, String password) {
        this.accountID = accountID;
        this.email = email;
        this.password = password;
    }

    @Override
    public void setID(int newID) { this.accountID = newID; }

    //later add double pass verification
    public void addAccountToDB() {
        if (passVerification(password)) {
            GenericDAO<Account> accountDAO = new GenericDAO<>("account");
            String query = "INSERT INTO account (email, password) VALUES (?, ?)";
            accountDAO.addObjectToDB(this, query, getEmail(), getPassword());
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
