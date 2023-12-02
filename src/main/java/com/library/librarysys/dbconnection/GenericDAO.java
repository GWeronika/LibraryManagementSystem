package com.library.librarysys.dbconnection;

import com.library.librarysys.interfaces.Identifiable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class GenericDAO<T extends Identifiable> {
    private final String tableName;

    public GenericDAO(String tableName) {
        this.tableName = tableName;
    }

    public void addObjectToDB(T object, String query, Object... parameters) {
        try (Connection connection = DBConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                setParameters(preparedStatement, parameters);

                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    try (var generatedKeys = preparedStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            object.setID(generatedKeys.getInt(1));
                        }
                    }
                }

                System.out.println(object.getClass().getSimpleName() + " dodane do bazy danych.");
            }
        } catch (SQLException e) {
            System.out.println("Brak połączenia z bazą danych");
            e.printStackTrace();
        }
    }

    public void deleteObjectFromDB(int id) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "DELETE FROM " + tableName + " WHERE " + tableName.toLowerCase() + "_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);

                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println(tableName + " usunięte z bazy danych.");
                } else {
                    System.out.println(tableName + " z ID " + id + " nie odnaleziono w bazie danych.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Brak połączenia z bazą danych");
            e.printStackTrace();
        }
    }

    private void setParameters(PreparedStatement preparedStatement, Object... parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i] instanceof Integer) {
                preparedStatement.setInt(i + 1, (Integer) parameters[i]);
            } else if (parameters[i] instanceof String) {
                preparedStatement.setString(i + 1, (String) parameters[i]);
            } else if (parameters[i] instanceof java.sql.Date) {
                preparedStatement.setDate(i + 1, (java.sql.Date) parameters[i]);
            }
        }
    }
}
