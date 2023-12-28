package com.library.librarysys.libcollection.libraryopening;

import com.library.librarysys.interfaces.Identifiable;
import com.library.librarysys.libcollection.Library;
import com.library.librarysys.libcollection.Opening;
import lombok.Getter;

/**
 * A class representing a connection between library and its opening in the library system.
 * Implements the Identifiable interface.
 */
@Getter
public class LibraryOpening implements Identifiable {
    private int id;
    private final Library library;
    private final Opening opening;

    /**
     * Constructor for the LibraryOpening class.
     *
     * @param opening Opening object, opening connected to the library
     * @param library Library object, library having the opening
     */
    public LibraryOpening(Library library, Opening opening) {
        this.library = library;
        this.opening = opening;
    }

    @Override
    public void setID(int newID) {
        this.id = newID;
    }
}
