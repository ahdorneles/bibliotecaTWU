package com.twu.biblioteca;


import com.twu.biblioteca.LibraryItem.Book;
import com.twu.biblioteca.LibraryItem.LibraryItem;
import com.twu.biblioteca.LibraryItem.Movie;
import com.twu.biblioteca.Utils.CatalogueAdmin;
import com.twu.biblioteca.Utils.Console;

public class BibliotecaApp {

    private CatalogueAdmin catalogueAdmin;
    private Console console;

    public BibliotecaApp(CatalogueAdmin catalogueAdmin, Console console) {
        this.catalogueAdmin = catalogueAdmin;
        this.console = console;
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
        menu();
    }

    public void greeting() {
        console.greeting();
    }

    public void menu() {
        String option = console.selectAnOption();

        if (option.equals("1")) {
            listBooks();
        }

        if (option.equals("2")) {
            listMovies();
        }
        again();
    }

    private void listMovies() {
        console.printList(catalogueAdmin.retrieveMovieListForMenu());
    }

    private void listBooks() {

        console.printList(catalogueAdmin.retrieveBookListForMenu());
    }

    private void again() {

        switch (console.again().toLowerCase()) {
            case "y":
                menu();
                break;
            case "n":
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
        catalogueAdmin.bookAnItem(libraryItem);
    }

    public void returnAbook(Book book) {
        catalogueAdmin.returnAbook();
    }

    public void bookDetails(Book book) {
        catalogueAdmin.bookDetails();
    }

}
