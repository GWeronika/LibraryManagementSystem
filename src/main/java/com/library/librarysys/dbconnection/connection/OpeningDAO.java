package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Opening;

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
}
