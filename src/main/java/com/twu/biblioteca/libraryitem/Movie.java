package com.twu.biblioteca.libraryitem;


public class Movie extends LibraryItem {

    private int rating;


    public Movie(String title, String author, int rating) {
        super(title, author);
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}