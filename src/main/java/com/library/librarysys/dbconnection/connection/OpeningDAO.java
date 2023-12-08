package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Opening;

import java.time.LocalTime;
import java.util.List;

public class OpeningDAO extends GenericDAO<Opening> {
    public OpeningDAO() {
        super("opening");
    }

    public void addOpeningToDB(Opening opening) {
        String query = "INSERT INTO opening (day, open_hour, close_hour) VALUES (?, ?, ?)";
        super.addObjectToDB(opening, query, opening.getDay().name(), opening.getOpenHour(), opening.getCloseHour());
    }

    public void deleteOpeningFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }

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

    private List<Result> extractFromDB(int id) {
        String[] columns = {"opening_id", "day", "open_hour", "close_hour"};
        String condition = "opening_id = ?";
        return super.extractObjectFromDB(getTableName(), columns, condition, null, id);
    }
}
