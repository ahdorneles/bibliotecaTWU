package com.twu.biblioteca;


import com.twu.biblioteca.libraryitem.Book;
import com.twu.biblioteca.libraryitem.LibraryItem;
import com.twu.biblioteca.libraryitem.Movie;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.utils.AccountManager;
import com.twu.biblioteca.utils.CatalogueAdmin;
import com.twu.biblioteca.utils.Console;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class BibliotecaApp {

    private CatalogueAdmin catalogueAdmin;
    private Console console;
    private AccountManager accountManager;

    public BibliotecaApp(CatalogueAdmin catalogueAdmin, Console console) {
        this.catalogueAdmin = catalogueAdmin;
        this.console = console;
        this.accountManager = new AccountManager();
    }

    public void init() {
        greeting();
        LibraryItem book = new Book("22", "OLA", 1923);
        LibraryItem book1 = new Book("44", "hey", 1023);
        LibraryItem book2 = new Book("55", "joao", 1999);
        LibraryItem movie = new Movie("O filme", "Teste", 6);
        LibraryItem movie2 = new Movie("OutroFilme", "Teste2", 8);
        addItemToList(book);
        addItemToList(book1);
        addItemToList(book2);
        addItemToList(movie);
        addItemToList(movie2);

        bookAnItem(book);
        bookAnItem(book1);
        returnAnItem(book1);
        returnAnItem(book);
        menu();
    }


    public void greeting() {
        console.greeting();
    }

    public void menu() {
        loginOrList();
    }


    public void loginOrList() {
        String option = console.loginOrList();

        switch (option) {
            case "1":
                login();
                break;
            case "2":
                listItems();
                break;
            default:
                console.print("Digite um valor válido.");
                again();
                break;
        }
        again();
    }

    private void login() {
        String username = console.username();
        String password = console.password();
        authenticate(username, password);


    }

    public boolean authenticate(String email, String password) {
        return accountManager.authenticate(email,password);
    }

    public void listItems() {

        String option = console.selectAnOption();

        switch (option) {
            case "1":
                listBooks();
                break;
            case "2":
                listMovies();
                break;
            default:
                console.print("Digite um valor válido.");
                again();
                break;
        }
    }

    private void listMovies() {
        console.printAnyList(catalogueAdmin.retrieveMovieListForMenu());
    }

    private void listBooks() {
        console.printAnyList(catalogueAdmin.retrieveBookListForMenu());
    }

    private void again() {

        switch (console.again().toLowerCase()) {
            case "y":
                menu();
                break;
            case "n":
                console.bye();
                return;
            default:
                console.print("Digite um valor válido.");
                again();

                break;
        }

    }

    public void addItemToList(LibraryItem item) {
        catalogueAdmin.addItemTolist(item);
        console.bookAddedToList();
    }

    public void bookAnItem(LibraryItem libraryItem) {
        boolean checkoutSucced = catalogueAdmin.bookAnItem(libraryItem);
        console.checkoutSucceed(checkoutSucced);

    }

    public void returnAnItem(LibraryItem libraryItem) {
        boolean returnSucced = catalogueAdmin.returnAnItem(libraryItem);
        console.returnSucced(returnSucced);
    }
}
