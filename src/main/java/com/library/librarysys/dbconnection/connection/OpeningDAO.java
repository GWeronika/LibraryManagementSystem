package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Opening;
import com.library.librarysys.openingformat.Result;

import java.time.LocalTime;
import java.util.List;

/**
 * A class that is responsible for connecting to the "opening" table in the library system.
 * It provides methods that execute basic operations on the opening table.
 * Extends the GenericDAO class.
 *
 * @see GenericDAO
 */
public class OpeningDAO extends GenericDAO<Opening> {
    public OpeningDAO() {
        super("opening");
    }

    /**
     * Adds a new row to the "opening" table.
     *
     * @param opening Opening object to be added
     * @see GenericDAO
     */
    public void addOpeningToDB(Opening opening) {
        String query = "INSERT INTO opening (day, open_hour, close_hour) VALUES (?, ?, ?)";
        super.addObjectToDB(opening, query, opening.getDay().name(), opening.getOpenHour(), opening.getCloseHour());
    }

    /**
     * Deletes a row with a specific id from the "opening" table.
     *
     * @param deleteID integer number, describing the id of the opening to be deleted
     * @see GenericDAO
     */
    public void deleteOpeningFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

    /**
     * Gets the Opening object with a specific id from the database.
     *
     * @param openingID integer number, id of the opening
     * @return Opening object extracted from the database
     * @see GenericDAO
     */
    public Opening getOpeningByID(int openingID) {
        List<Result> resultList = extractFromDB(openingID);
        for (Result result : resultList) {
            int resultOpeningID = Integer.parseInt(result.getColumnValues().get("opening_id"));

            if (resultOpeningID == openingID) {
                Opening.Day day = Opening.Day.valueOf(result.getColumnValues().get("day"));
                LocalTime openHour = LocalTime.parse(result.getColumnValues().get("open_hour"));
                LocalTime close_hour = LocalTime.parse(result.getColumnValues().get("close_hour"));

                return new Opening(resultOpeningID, day, openHour, close_hour);
            }
        }
        return null;
    }

    /**
     * Extracts the opening data with the specific id from the database.
     *
     * @param id integer number, id of the opening
     * @return the list with the opening data
     * @see GenericDAO
     */
    private List<Result> extractFromDB(int id) {
        String[] columns = {"opening_id", "day", "open_hour", "close_hour"};
        String condition = "opening_id = ?";
        return super.extractObjectFromDB(getTableName(), columns, condition, null, id);
    }
}
