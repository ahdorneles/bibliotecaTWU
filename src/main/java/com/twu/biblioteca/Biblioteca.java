package com.twu.biblioteca;

public class Biblioteca {

    private BookManager bookManager;
    private Console console;


    Biblioteca(BookManager bookManager, Console console) {
        this.bookManager = bookManager;
        this.console = console;
    }

    public void bookAbook () {
        bookManager.bookAbook();
    }

    public void returnAbook(Book book) {
        bookManager.returnAbook();
    }

    public void bookDetails (Book book) {
        bookManager.bookDetails();
    }

    public void menu () {
        console.greeting();
        bookManager.retrieveBookListForMenu();

    }

}
