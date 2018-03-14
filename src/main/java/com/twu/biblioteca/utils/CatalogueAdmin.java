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


    public List<Book> retrieveBookList() {
        List<Book> bookList = new ArrayList<>();
        for (LibraryItem libraryItem :
                libraryItemList) {
            if (libraryItem instanceof Book) {
                bookList.add((Book) libraryItem);
            }

        }
        return bookList;
    }

    public List<Book> retrieveAvailableBookList() {
        List<Book> availableBookList = retrieveBookList();

        for (LibraryItem libraryItem :
                libraryItemList) {
            if (!libraryItem.isBooked()) {
                availableBookList.add((Book)libraryItem);
            }
        }
        return availableBookList;
    }

    public List<Movie> retrieveMovieList() {
        List<Movie> movieList = new ArrayList<>();
        for (LibraryItem libraryItem :
                libraryItemList) {
            if (libraryItem instanceof Movie) {
                movieList.add((Movie)libraryItem);
            }

        }
        return movieList;
    }

    public List<Movie> retrieveAvailableMovieList() {
        List<Movie> availableMovieList = retrieveMovieList();

        for (LibraryItem libraryItem :
                libraryItemList) {
            if (libraryItem.isBooked()) {
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

    public List<String> retrieveAvailableBookListForMenu() {

        List<Book> list = retrieveAvailableBookList();
        return catalogueListForMenu(list,true);
    }

    public List<String> retrieveAvailableMovieListForMenu() {

        List<Movie> list = retrieveAvailableMovieList();
        return catalogueListForMenu(list,true);
    }

    public List <String> retrieveBookListForMenu() {
        List<Book> list = retrieveBookList();
        return catalogueListForMenu(list,false);
    }

    public List<String> retrieveMovieListForMenu() {
        List<Movie> list = retrieveMovieList();
        return catalogueListForMenu(list,false);
    }

    public List<String> catalogueListForMenu(List<? extends LibraryItem> list, boolean justAvailableItems) {
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
                    printAvailability(libraryItem) +
                            (justAvailableItems ? '\n' : printUserbooking(libraryItem));

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

    private String printUserbooking (LibraryItem item) {

        String output = item.getUserName();

        while (output.length() < 20) {
            output = output.concat(" ");

        }
        return output.concat("|");
    }

}
