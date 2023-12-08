package com.library.librarysys.dbconnection.connection;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Result {
    private Map<String, String> columnValues = new HashMap<>();

    public void addColumnValue(String columnName, String value) {
        columnValues.put(columnName, value);
    }
}
