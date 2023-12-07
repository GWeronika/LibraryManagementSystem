package com.library.librarysys.dbconnection;

import com.library.librarysys.interfaces.Identifiable;
import lombok.Getter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

@Getter
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

    public void selectObjectFromDB(String tableName, String[] columns, String condition, String joinCondition, Object... parameters) {
        try (Connection connection = DBConnection.getConnection()) {
            String data = String.join(", ", columns);
            String query = "SELECT " + data + " FROM " + tableName;

            if (joinCondition != null && !joinCondition.isEmpty()) {
                query += " " + joinCondition;
            }

            if (condition != null && !condition.isEmpty()) {
                query += " WHERE " + condition;
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                setParameters(preparedStatement, parameters);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        for (String column : columns) {
                            System.out.print(resultSet.getString(column) + "\t");
                        }
                        System.out.println();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Brak połączenia z bazą danych");
            e.printStackTrace();
        }
    }

    //UPDATE table JOIN table2 ON id SET table.column1 = value1 WHERE condition
    public void alterObjectInDB(String tableName, String[] setClauses, String condition, String joinCondition, Object... parameters) {
        try (Connection connection = DBConnection.getConnection()) {
            String data = String.join(", ", setClauses);
            StringBuilder query = new StringBuilder("UPDATE " + tableName);

            if (joinCondition != null && !joinCondition.isEmpty()) {
                query.append(" ").append(joinCondition);
            }

            query.append(" SET ").append(data);

            if (condition != null && !condition.isEmpty()) {
                query.append(" WHERE ").append(condition);
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(query.toString())) {
                setParameters(preparedStatement, parameters);

                int affectedRows = preparedStatement.executeUpdate();
                System.out.println("Liczba zmionionych wierszy: " + affectedRows);
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
            } else if (parameters[i] instanceof Enum<?>) {
                preparedStatement.setString(i + 1, ((Enum<?>) parameters[i]).name());
            }
        }
    }
}

