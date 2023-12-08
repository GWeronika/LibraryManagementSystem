package com.library.librarysys.users.interfaces;

public interface ReaderManagement {
    void deleteReader(int readerID);
    void showReaders();
    void showReaders(String name);
    void showReaders(int readerID);
}
