package com.library.librarysys.libcollection;

import com.library.librarysys.interfaces.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;

/**
 * A class representing an opening in the library system.
 * Implements the Identifiable interface.
 */
@ToString
@EqualsAndHashCode
@Getter
public class Opening implements Identifiable {
    private int openingID;
    private final Day day;
    private final LocalTime openHour;
    private final LocalTime closeHour;

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    /**
     * Constructor for the Opening class.
     *
     * @param openingID integer number representing opening id
     * @param day Day object, a day which the opening refers to
     * @param openHour LocalTime object, time assigned to a specific day when the library opens
     * @param closeHour LocalTime object, time assigned to a specific day when the library closes
     */
    public Opening(int openingID, Day day, LocalTime openHour, LocalTime closeHour) {
        this.openingID = openingID;
        this.day = day;
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

    @Override
    public void setID(int newID) {
        this.openingID = newID;
    }
}
