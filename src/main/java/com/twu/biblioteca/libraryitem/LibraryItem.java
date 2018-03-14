package com.twu.biblioteca.libraryitem;

import com.twu.biblioteca.user.User;

public class LibraryItem {

    private String title;
    private String author;
    private boolean isBooked = false;
    private int id;
    private User user;

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

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getUserName() {
        if (user == null) {
            return "";
        } else {
            return user.getName();
        }
    }
}
