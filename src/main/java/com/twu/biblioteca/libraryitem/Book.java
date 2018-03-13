package com.twu.biblioteca.libraryitem;


public class Book extends LibraryItem {

        private int publishYear;


    public Book(String title, String author, int publishYear) {
        super(title, author);
        this.publishYear = publishYear;

    }

    public int getPublishYear() {
        return publishYear;
    }
}
