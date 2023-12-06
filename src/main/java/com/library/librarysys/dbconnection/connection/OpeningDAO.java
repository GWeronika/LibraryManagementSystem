package com.library.librarysys.dbconnection.connection;

import com.library.librarysys.dbconnection.GenericDAO;
import com.library.librarysys.libcollection.Opening;

public class OpeningDAO extends GenericDAO<Opening> {
    public OpeningDAO() {
        super("opening");
    }

    public void deleteOpeningFromDB(int deleteID) {
        super.deleteObjectFromDB(deleteID);
    }
}
