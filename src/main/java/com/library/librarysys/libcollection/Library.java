package com.library.librarysys.libcollection;

import com.library.librarysys.interfaces.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

/**
 * A class representing a library in the library system.
 * Implements the Identifiable interface.
 *
 * @see Opening
 */
@ToString
@EqualsAndHashCode
@Getter
public class Library implements Identifiable {
    private int libraryID;
    private final String name;
    @Setter private String location;
    @Setter private String phoneNum;
    @Setter private String email;
    @Setter private HashMap<Opening.Day, Opening> openingsList;

    /**
     * Constructor for the Library class.
     *
     * @param libraryID integer number representing library id
     * @param name String value, name of the library
     * @param location String value, location of the library
     * @param phoneNum String value, phone number of the library
     * @param email String value, email of the library
     * @param openings a map of Opening objects, all openings of the library
     */
    public Library(int libraryID, String name, String location, String phoneNum, String email, Opening... openings) {
        this.libraryID = libraryID;
        this.name = name;
        this.location = location;
        this.phoneNum = phoneNum;
        this.email = email;
        initializeOpening(openings);
    }

    @Override
    public void setID(int newID) {
        this.libraryID = newID;
    }

    /**
     * Initializes the opening hours for specified days and updates the openings list.
     * For each provided Opening object, the method checks if the corresponding day is already present in the openings list.
     * If the day is already set, it prompts the user to confirm changing the existing opening hours.
     * The method then updates the openings list with the provided opening hours.
     *
     * @param openings an array of Opening objects representing the opening hours for specific days.
     * @throws IllegalArgumentException If an invalid day is provided in the Opening objects.
     *                                  The method uses the Opening.Day enum for day validation.
     * @see Opening
     */
    private void initializeOpening(Opening... openings) {
        this.openingsList = new HashMap<>();
        for(Opening day : openings) {
            Opening.Day dayKey = Opening.Day.valueOf(String.valueOf(day.getDay()));
            if (openingsList.containsKey(dayKey)) {
                System.out.println("Dzień " + dayKey + " już ma ustalone godziny. Czy chcesz je zmienić?");
            }
            openingsList.put(dayKey, day);        //HashMap ensures that there are no duplicates (two equal weekdays)
        }
    }
}
