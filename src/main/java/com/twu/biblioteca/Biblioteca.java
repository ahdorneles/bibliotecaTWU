package com.twu.biblioteca;

public class Biblioteca {

    private BookManager bookManager;
    private Console console;


    Biblioteca(BookManager bookManager, Console console) {
        this.bookManager = bookManager;
        this.console = console;
    }

    public void init() {
        greeting();
        menu();
    }

    public void menu() {
        String option = console.selectAnOption();

        if (option.equals("1")) {
            listBooks();
        }
        again();
    }

    private void listBooks() {
        console.printList(bookManager.retrieveBookListForMenu());
    }

    private void again() {

        switch (console.again().toLowerCase()) {
            case "y":
                menu();
                break;
            case "n":
                return;
            default:
                System.out.println("Digite um valor válido. ");
                again();
                break;
        }

    }

    private void greeting() {
        console.greeting();

    }

    public void addBookTolist(Book book) {
        bookManager.addBookTolist(book);
    }

    public void bookAbook() {
        bookManager.bookAbook();
    }

    public void returnAbook(Book book) {
        bookManager.returnAbook();
    }

    public void bookDetails(Book book) {
        bookManager.bookDetails();
    }

}
