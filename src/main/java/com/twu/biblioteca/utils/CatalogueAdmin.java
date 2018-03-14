package com.twu.biblioteca.utils;

import com.twu.biblioteca.libraryitem.Book;
import com.twu.biblioteca.libraryitem.LibraryItem;
import com.twu.biblioteca.libraryitem.Movie;

import java.util.ArrayList;
import java.util.List;

public class CatalogueAdmin {


    private List<LibraryItem> libraryItemList = new ArrayList<>();


    public void addItemTolist(LibraryItem item) {
        libraryItemList.add(item);
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

    public boolean bookAnItem(LibraryItem item) {
        boolean booked = false;

        for (LibraryItem items :
                libraryItemList) {
            if (items.getTitle().equals(item.getTitle())) {
                item.checkoutItem();
                booked = true;
            }
        }
        return booked;
    }

    public boolean returnAnItem(LibraryItem item) {

        boolean returned = false;

        for (LibraryItem items :
                libraryItemList) {
            if (items.getTitle().equals(item.getTitle())) {
                item.returnItem();
                returned = true;
            }
        }
        return returned;
    }

    public List<String> retrieveBookListForMenu() {

        List<Book> list = retrieveAvailableBookList();
        return catalogueListForMenu(list);
    }

    public List<String> retrieveMovieListForMenu() {

        List<Movie> list = retrieveAvailableMovieList();
        return catalogueListForMenu(list);
    }

    public List<String> catalogueListForMenu(List<? extends LibraryItem> list) {

        List<String> catalogueList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            LibraryItem libraryItem = list.get(i);
            libraryItem.setId(i + 1);

            String line =
                    printItemTitle(libraryItem) +
                    printAuthor(libraryItem) +
                            (libraryItem instanceof Movie ?
                                    printMovieRating((Movie)libraryItem) :
                                    printPublishedYear((Book) libraryItem))+
                    printAvailability(libraryItem) + "\n";

            catalogueList.add(line);
        }


        return catalogueList;
    }

    private String printMovieRating(Movie movie) {
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
