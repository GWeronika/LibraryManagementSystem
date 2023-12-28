package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.DBConnection;
import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.libraryopening.LibraryOpening;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * A class that is responsible for connecting to the "library_opening" table in the library system.
 * It provides methods that execute basic operations on the library_opening table.
 * Extends the GenericDAO class.
 *
 * @see GenericDAO
 */
public class LibraryOpeningDAO extends GenericDAO<LibraryOpening> {
    public LibraryOpeningDAO() {
        super("library_opening");
    }

    /**
     * Adds a new row to the "library_opening" table.
     *
     * @param libraryOpening LibraryOpening object, connection between library and opening
     * @see GenericDAO
     */
    public void addLibraryOpeningToDB(LibraryOpening libraryOpening) {
        String query = "INSERT INTO library_opening (library_id, opening_id) VALUES (?, ?)";
        super.addObjectToDB(libraryOpening, query, libraryOpening.getLibrary().getLibraryID(), libraryOpening.getOpening().getOpeningID());
    }

    /**
     * Deletes a row with a specific library id and opening id from the "library_opening" table.
     *
     * @param libraryID id of the library in the connection table
     * @param openingID id of the opening in the connection table
     * @see DBConnection
     */
    public void deleteLibraryOpeningFromDB(int libraryID, int openingID) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "DELETE FROM " + getTableName() + " WHERE library_id = ? AND opening_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, libraryID);
                preparedStatement.setInt(2, openingID);

                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Połączenie usunięte z bazy danych.");
                } else {
                    System.out.println("Połączenia o library_id " + libraryID + " i opening_id " + openingID + " nie odnaleziono w bazie danych.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Brak połączenia z bazą danych");
            e.printStackTrace();
        }
    }
}