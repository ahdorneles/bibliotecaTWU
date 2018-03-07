package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private BookManager bookManager = new BookManager();
    private Console console = new Console(new Scanner(System.in));

    public void init() {
        greeting();
        menu();
    }

    private void greeting() {
        console.greeting();
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

    public void addBookTolist(Book book) {
        bookManager.addBookTolist(book);
    }

    public void bookAbook(Book book1) {
        bookManager.bookAbook(book1);
    }

    public void returnAbook(Book book) {
        bookManager.returnAbook();
    }

    public void bookDetails(Book book) {
        bookManager.bookDetails();
    }

}
