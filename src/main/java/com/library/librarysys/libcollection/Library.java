package com.library.librarysys.libcollection;

import com.library.librarysys.interfaces.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

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

    private void initializeOpening(Opening... openings) {
        for(Opening day : openings) {
            Opening.Day dayKey = Opening.Day.valueOf(String.valueOf(day.getDay()));
            if (openingsList.containsKey(dayKey)) {
                System.out.println("Dzień " + dayKey + " już ma ustalone godziny. Czy chcesz je zmienić?");
            }
            openingsList.put(dayKey, day);        //HashMap ensures that there are no duplicates (two equal weekdays)
        }
    }
}
