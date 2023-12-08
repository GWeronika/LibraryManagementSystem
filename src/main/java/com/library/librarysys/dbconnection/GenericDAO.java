package com.library.librarysys.dbconnection;

import com.library.librarysys.dbconnection.connection.Result;
import com.library.librarysys.interfaces.Identifiable;
import lombok.Getter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
            String query = prepareQuery(tableName, columns, condition, joinCondition);

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

    public List<Result> extractObjectFromDB(String tableName, String[] columns, String condition, String joinCondition, Object... parameters) {
        List<Result> resultList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String query = prepareQuery(tableName, columns, condition, joinCondition);

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                setParameters(preparedStatement, parameters);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Result result = new Result();
                        for (String column : columns) {
                            result.addColumnValue(column, resultSet.getString(column));
                        }
                        resultList.add(result);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Brak połączenia z bazą danych");
            e.printStackTrace();
        }
        return resultList;
    }

    public void alterObjectInDB(String tableName, String[] setClauses, String condition, Object... parameters) {
        try (Connection connection = DBConnection.getConnection()) {
            String data = String.join(", ", setClauses);
            StringBuilder query = new StringBuilder("UPDATE " + tableName);

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

    /**
     * Checks if a duplicate exists in a table for specified columns and values.
     *
     * @param tableName the name of the table in the database
     * @param columns the columns for which uniqueness is checked
     * @param values values to check
     * @return id of the row with the duplicate, 0 if there is no duplicate or an error
     */
    public int checkDuplicate(String tableName, String[] columns, Object... values) {
        StringBuilder queryBuilder = new StringBuilder("SELECT id FROM ");
        queryBuilder.append(tableName).append(" WHERE ");

        for (int i = 0; i < columns.length; i++) {
            if (i > 0) {
                queryBuilder.append(" AND ");
            }
            queryBuilder.append(columns[i]).append(" = ?");
        }

        String query = queryBuilder.toString();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < values.length; i++) {
                preparedStatement.setObject(i + 1, values[i]);
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }

        } catch (SQLException e) {
            System.out.println("Brak połączenia z bazą danych");
            e.printStackTrace();
        }
        return 0;
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

    private String prepareQuery(String tableName, String[] columns, String condition, String joinCondition) {
        String data = String.join(", ", columns);
        String query = "SELECT " + data + " FROM " + tableName;

        if (joinCondition != null && !joinCondition.isEmpty()) {
            query += " " + joinCondition;
        }

        if (condition != null && !condition.isEmpty()) {
            query += " WHERE " + condition;
        }
        return query;
    }
}

