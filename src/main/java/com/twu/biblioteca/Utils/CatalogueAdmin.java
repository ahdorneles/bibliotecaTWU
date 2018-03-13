package com.twu.biblioteca.Utils;

import com.twu.biblioteca.LibraryItem.Book;
import com.twu.biblioteca.LibraryItem.LibraryItem;
import com.twu.biblioteca.LibraryItem.Movie;

import java.util.ArrayList;
import java.util.List;

public class CatalogueAdmin {


    private List<LibraryItem> libraryItemList = new ArrayList<>();


    public void addItemTolist(LibraryItem item) {
        libraryItemList.add(item);
    }


    public String getAuthorByTitle(String title) {

        String author = null;

        for (LibraryItem item : libraryItemList) {
            if (item.getTitle().equals(title)) {
                author = item.getAuthor();
            }
        }

        return author;
    }

    public List<String> getTitleByAuthor(String author) {

        List<String> titleByAuthor = new ArrayList<>();

        for (LibraryItem item : libraryItemList) {
            if (item.getAuthor().equals(author)) {
                titleByAuthor.add(item.getTitle());
            }
        }

        return titleByAuthor;
    }

    public List<LibraryItem> retrieveItemsList() {
        return libraryItemList;
    }

    public List<Book> retrieveAvailableBookList() {
        List<Book> availableBookList = new ArrayList<>();

        for (LibraryItem libraryItem :
                libraryItemList) {
            if (libraryItem instanceof Book && !libraryItem.isBooked()) {
                availableBookList.add((Book)libraryItem);
            }
        }
        return availableBookList;
    }

    public List<Movie> retrieveAvailableMovieList() {
        List<Movie> availableMovieList = new ArrayList<>();

        for (LibraryItem libraryItem :
                libraryItemList) {
            if (libraryItem instanceof Movie && !libraryItem.isBooked()) {
                availableMovieList.add((Movie)libraryItem);
            }
        }
        return availableMovieList;
    }

    public void bookAnItem(LibraryItem item) {

        for (LibraryItem libraryItem1 :
                libraryItemList) {
            if (item.getId() == item.getId()) {
                item.checkoutItem();
            }
        }
    }

    public void returnAbook() {
    }

    public void bookDetails() {
    }


    public List<String> retrieveBookListForMenu() {

        List<Book> list = retrieveAvailableBookList();
        List<String> bookListForMenu = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Book book = (Book) list.get(i);
            book.setId(i + 1);

            String line =
                    printItemTitle(book) +
                    printAuthor(book) +
                    printPublishedYear(book) +
                    printAvailability(book) + "\n";

            bookListForMenu.add(line);
        }


        return bookListForMenu;
    }

    public List<String> retrieveMovieListForMenu() {

        List<Movie> list = retrieveAvailableMovieList();
        List<String> bookListForMenu = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Movie movie = list.get(i);
            movie.setId(i + 1);

            String line =
                    printItemTitle(movie) +
                    printAuthor(movie) +
                    printMovieRating(movie) +
                    printAvailability(movie) + "\n";

            bookListForMenu.add(line);
        }


        return bookListForMenu;
    }

    private Object printMovieRating(Movie movie) {
        String output = Integer.toString(movie.getRating());

        while (output.length() < 14) {
            output = output.concat(" ");

        }
        return output.concat("|");
    }

    private String printAvailability(LibraryItem item) {
        String available = "     NO    |";

        if (!item.isBooked()) {
            available = "    YES    |";
        }
        return available;
    }

    private String printPublishedYear(Book book) {

        String output = Integer.toString(book.getPublishYear());

        while (output.length() < 14) {
            output = output.concat(" ");

        }
        return output.concat("|");

    }


    private String printAuthor(LibraryItem libraryItem) {

        String output = libraryItem.getAuthor();

        while (output.length() < 25) {
            output = output.concat(" ");

        }
        return output.concat("|");

    }


    private String printItemTitle(LibraryItem item) {
        String output = item.getTitle();

        while (output.length() < 25) {
            output = output.concat(" ");

        }
        return output.concat("|");

    }
}
