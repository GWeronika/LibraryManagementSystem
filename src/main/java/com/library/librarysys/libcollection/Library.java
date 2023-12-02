package com.library.librarysys.libcollection;

import com.library.librarysys.users.Administrator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

@ToString
@EqualsAndHashCode
@Getter
public class Library {
    private final int libraryID;
    @Setter private String location;
    @Setter private String phoneNum;
    @Setter private String email;
    @Setter private Administrator administrator;
    HashMap<String, Opening> openingsList;

    public Library(int libraryID, String location, String phoneNum, String email, Administrator administrator, Opening... openings) {
        this.libraryID = libraryID;
        this.location = location;
        this.phoneNum = phoneNum;
        this.email = email;
        this.administrator = administrator;
        initializeOpening(openings);
    }

    private void initializeOpening(Opening... openings) {
        for(Opening day : openings) {
            String dayKey = String.valueOf(day.getDay());
            if (openingsList.containsKey(dayKey)) {
                System.out.println("Dzień " + dayKey + " już ma ustalone godziny. Czy chcesz je zmienić?");
            }
            openingsList.put(String.valueOf(day.getDay()), day);        //HashMap ensures that there are no duplicates (two equal weekdays)
        }
    }
}
