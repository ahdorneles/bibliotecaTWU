package com.twu.biblioteca.LibraryItem;

import com.twu.biblioteca.LibraryItem.LibraryItem;

public class Movie extends LibraryItem {

    private int rating;


    public Movie(String title, String author, int rating) {
        super(title, author);
        this.rating = rating;
    }

    public void returnMovie() {
        super.returnItem();
    }

    public void checkoutMovie() {
        super.checkoutItem();
    }

    public int getRating() {
        return rating;
    }
}