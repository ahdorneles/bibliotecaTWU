package com.twu.biblioteca.LibraryItem;


public class Book extends LibraryItem {

        private int publishYear;


    public Book(String title, String author, int publishYear) {
        super(title, author);
        this.publishYear = publishYear;

    }

    public void returnBook() {
        super.returnItem();
    }

    public void checkoutBook() {
        super.checkoutItem();
    }

    public int getPublishYear() {
        return publishYear;
    }
}
