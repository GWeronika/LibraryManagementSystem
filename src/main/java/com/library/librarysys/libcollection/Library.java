package com.library.librarysys.libcollection;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.HashMap;

@Getter
public class Library {
    private final int libraryID;
    @Setter private String location;
    @Setter private HashMap<String, HashMap<LocalTime, LocalTime>> openings = new HashMap<>();      //days of the week should be final keys but with the GUI this problem will be easier to deal with

    public Library(int libraryID, String location, HashMap<String, HashMap<LocalTime, LocalTime>> openings) {
        this.libraryID = libraryID;
        this.location = location;
        initializeMap(openings);
    }

    private void initializeMap(HashMap<String, HashMap<LocalTime, LocalTime>> openings) {
        final String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String day : daysOfWeek) {
            HashMap<LocalTime, LocalTime> dailyOpenings = new HashMap<>();
            if (openings.containsKey(day)) {
                HashMap<LocalTime, LocalTime> initialDailyOpenings = openings.get(day);
                dailyOpenings.putAll(initialDailyOpenings);
            }
            this.openings.put(day, dailyOpenings);
        }
    }
}
