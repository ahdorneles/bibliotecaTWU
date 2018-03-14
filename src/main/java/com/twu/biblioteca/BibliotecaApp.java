package com.twu.biblioteca;


import com.twu.biblioteca.libraryitem.Book;
import com.twu.biblioteca.libraryitem.LibraryItem;
import com.twu.biblioteca.libraryitem.Movie;
import com.twu.biblioteca.user.Role;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.utils.AccountManager;
import com.twu.biblioteca.utils.CatalogueAdmin;
import com.twu.biblioteca.utils.Console;

public class BibliotecaApp {

    private CatalogueAdmin catalogueAdmin;
    private Console console;
    private AccountManager accountManager;
    private boolean isSomeoneLogged = false;

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
        book.setUser(new User("Adriana","email",234,"1234"));
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
                simpleMenu();
                break;
            default:
                console.print("Digite um valor válido.");
                again();
                break;
        }
        again();
    }

    private void simpleMenu() {
        String option = console.simpleMenu();

        switch (option) {
            case "1":
                listAvailableBooks();
                break;
            case "2":
                listAvailableMovies();
                break;
        }
    }

    private void login() {
        String libraryId = console.username();
        if (libraryId.toLowerCase().equals("b")) {
            loginOrList();
        }
        String password = console.password();

        if (authenticate(libraryId, password)) {
            isSomeoneLogged = true;
            console.loginSucceed(true);
            dynamicMenu(libraryId);
        } else {
            console.loginSucceed(false);
            login();
        }
    }

    private void dynamicMenu(String libraryId) {
        Role role = accountManager.getRole(libraryId);

        if (role == Role.CLIENT) {
            clientMenu();
        } else {
            adminMenu();
        }
    }

    private void adminMenu() {
        String option = console.adminMenu();
        switch (option) {
            case "1":
                listAvailableBooks();
                break;
            case "2":
                listAvailableMovies();
                break;
            case "3":
                listBooks();
                break;
            case "4":
                listMovies();
                break;
            case "5":
                logout();
            default:
                console.print("Digite um valor válido.");
                again();
                break;
        }

    }

    private void listMovies() {console.printMovieList(catalogueAdmin.retrieveMovieListForMenu());
    }

    private void listBooks() {
        console.printBookList(catalogueAdmin.retrieveBookListForMenu());
    }

    public boolean authenticate(String email, String password) {
        return accountManager.authenticate(email, password);
    }

    public void clientMenu() {

        String option = console.clientMenu();
        switch (option) {
            case "1":
                listAvailableBooks();
                break;
            case "2":
                listAvailableMovies();
                break;
            case "3":
                listUserInfo();
                break;
            case "4":
                logout();
            default:
                console.print("Digite um valor válido.");
                again();
                break;
        }
    }

    private void logout() {
        isSomeoneLogged = false;
        loginOrList();
    }

    private void listUserInfo() {
        console.print(accountManager.getWhoIsLogged().toString());
    }

    private void listAvailableMovies() {
        console.printMovieList(catalogueAdmin.retrieveAvailableMovieListForMenu());
    }

    private void listAvailableBooks() {
        console.printBookList(catalogueAdmin.retrieveAvailableBookListForMenu());
    }

    private void again() {

        switch (console.again().toLowerCase()) {
            case "y":
                menu();
                break;
            case "b":
                lastMenu();
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

    private void lastMenu() {
        if (isSomeoneLogged) {
            clientMenu();
        } else {
            loginOrList();
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
