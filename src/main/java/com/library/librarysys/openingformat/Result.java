package com.library.librarysys.openingformat;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * A class representing a result for storing values in a HashMap.
 */
@Getter
public class Result {
    private Map<String, String> columnValues = new HashMap<>();

    /**
     * Adds values to their keys in the HashMap.
     * @param columnName column name - a key
     * @param value value assigned to the column - a value
     */
    public void addColumnValue(String columnName, String value) {
        columnValues.put(columnName, value);
    }
}
