package com.library.librarysys.libcollection;

import com.library.librarysys.users.Administrator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;
import java.util.HashMap;

@ToString
@EqualsAndHashCode
@Getter
public class Library {
    private final int libraryID;
    @Setter private String location;
    @Setter private HashMap<String, HashMap<LocalTime, LocalTime>> openings = new HashMap<>();      //days of the week should be final keys but with the GUI this problem will be easier to deal with
    @Setter private Administrator administrator;

    public Library(int libraryID, String location, HashMap<String, HashMap<LocalTime, LocalTime>> openings, Administrator administrator) {
        this.libraryID = libraryID;
        this.location = location;
        initializeMap(openings);
        this.administrator = administrator;
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
