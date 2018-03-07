package com.twu.biblioteca;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

public class BibliotecaMain {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca(new BookManager(), new Console(new Scanner(System.in)));

        Book book = new Book("22","OLA",1923);
        Book book1 = new Book("44","hey",1023);
        Book book2 = new Book("55", "joao", 1999);

        biblioteca.addBookTolist(book);
        biblioteca.addBookTolist(book1);
        biblioteca.addBookTolist(book2);
        book2.setBooked();

        biblioteca.init();
    }
}
