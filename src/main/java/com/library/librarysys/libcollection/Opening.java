package com.library.librarysys.libcollection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.interfaces.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;

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

    public void addOpeningToDB() {
        GenericDAO<Opening> openingDAO = new GenericDAO<>("opening");

        String query = "INSERT INTO opening (day, open_hour, close_hour) VALUES (?, ?, ?)";
        openingDAO.addObjectToDB(this, query, day.name(), getOpenHour(), getCloseHour());
    }
}
