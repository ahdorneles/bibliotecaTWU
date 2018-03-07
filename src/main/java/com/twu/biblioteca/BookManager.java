package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookManager {


    private Message message = new Message();
    private List<Book> bookList = new ArrayList<>();


    public void addBookTolist(Book book) {
        bookList.add(book);
    }


    public String getAuthorByTitle(String title) {

        for (Book aBookList : bookList) {
            if (aBookList.getTitle().equals(title)) {
                return aBookList.getAuthor();
            }
        }

        return message.theresNoBook();
    }

    public List<String> getTitleByAuthor(String author) {

        List<String> titleByAuthor = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getAuthor().equals(author)) {
                titleByAuthor.add(book.getTitle());
            }
        }

        return titleByAuthor;
    }

    public int getYearByTitle(String title) {

        for (Book aBookList : bookList) {
            if (aBookList.getTitle().equals(title)) {
                return aBookList.getPublishYear();
            }
        }

        return 0;
    }

    public List<Book> retrieveBookList() {
        return bookList;
    }

    public List<Book> retrieveAvailableBookList() {
        List<Book> availableBookList = new ArrayList<>();

        for (Book book :
                bookList) {
            if (!book.isBooked()) {
                availableBookList.add(book);
            }
        }
        return availableBookList;
    }


    public List<Book> retrieveBookedBookList() {

        List<Book> bookedBookList = new ArrayList<>();

        for (Book book :
                bookList) {
            if (book.isBooked()) {
                bookedBookList.add(book);
            }
        }
        return bookedBookList;
    }

    public void bookAbook() {
    }

    public void returnAbook() {
    }

    public void bookDetails() {
    }


    public List<String> retrieveBookListForMenu() {

        List<String> bookListForMenu = new ArrayList<>();
        bookListForMenu.add(message.bookListHead());
        List<Book> list = retrieveBookList();

        for (Book book :
                list) {

            String line = printBookId() +
                    printBookTitle(book) +
                    printBookAuthor(book) +
                    printBookPublishedYear(book) +
                    printAvailability(book) + "\n";

            bookListForMenu.add(line);
        }
        return bookListForMenu;
    }

    private String printAvailability(Book book) {
        String available = "     NO    |";

        if (!book.isBooked()) {
            available = "    YES    |";
        }
        return available;
    }

    private String printBookPublishedYear(Book book) {


        String output = Integer.toString(book.getPublishYear());

        while (output.length() < 14) {
            output = output.concat(" ");

        }
        return output.concat("|");

    }


    private String printBookAuthor(Book book) {

        String output = book.getAuthor();

        while (output.length() < 25) {
            output = output.concat(" ");

        }
        return output.concat("|");

    }


    private String printBookTitle(Book book) {
        String output = book.getTitle();

        while (output.length() < 25) {
            output = output.concat(" ");

        }
        return output.concat("|");

    }

    private String printBookId() {
        int listSize = retrieveBookList().size();
        String output = Integer.toString(listSize);

        while (output.length() < 4) {
            output = output.concat(" ");

        }
        return output.concat("|");

    }
}
