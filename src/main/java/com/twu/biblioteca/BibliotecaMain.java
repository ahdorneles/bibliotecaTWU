package com.twu.biblioteca;


import java.util.Scanner;

public class BibliotecaMain {

    public static void main(String[] args) {

        BibliotecaApp biblioteca = new BibliotecaApp();

        Book book = new Book("22","OLA",1923);
        Book book1 = new Book("44","hey",1023);
        Book book2 = new Book("55", "joao", 1999);

        biblioteca.addBookTolist(book);
        biblioteca.addBookTolist(book1);
        biblioteca.addBookTolist(book2);

        biblioteca.bookAbook(book1);

        biblioteca.init();
    }
}
