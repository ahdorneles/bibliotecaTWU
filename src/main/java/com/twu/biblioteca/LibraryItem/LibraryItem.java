package com.twu.biblioteca.LibraryItem;

public class LibraryItem {

    private String title;
    private String author;
    private boolean isBooked = false;
    private int id;

    public LibraryItem(String title, String author) {
        this.title = title;
        this.author = author;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void returnItem() {
        isBooked = false;
    }

    public void checkoutItem() {
        isBooked = true;
    }

}