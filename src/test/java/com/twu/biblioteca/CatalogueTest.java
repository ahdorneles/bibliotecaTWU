
package com.twu.biblioteca;

import com.twu.biblioteca.libraryitem.Book;
import com.twu.biblioteca.libraryitem.LibraryItem;
import com.twu.biblioteca.libraryitem.Movie;
import com.twu.biblioteca.utils.CatalogueAdmin;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class CatalogueTest {


    private CatalogueAdmin catalogueAdmin;
    private LibraryItem book1;
    private LibraryItem book2;
    private LibraryItem book3;
    private LibraryItem movie1;
    private LibraryItem movie2;



    @Before
    public void initialize() {
        catalogueAdmin = new CatalogueAdmin();
        book1 = new Book("22", "jose", 1928);
        book2 = new Book("33", "maria", 1989);
        book3 = new Book("44", "maria", 2019);

        movie1 = new Movie("Oi","teste",3);
        movie2 = new Movie("Teste","outro", 4);

        catalogueAdmin.addItemTolist(book1);
        catalogueAdmin.addItemTolist(book2);
        catalogueAdmin.addItemTolist(book3);
        catalogueAdmin.addItemTolist(movie1);
        catalogueAdmin.addItemTolist(movie2);

    }

    @Test
    public void shouldRetrieveLibraryItemsList() {
        List<LibraryItem> bookList = catalogueAdmin.retrieveItemsList();
        assertEquals(5, bookList.size());
    }

    @Test
    public void shouldCheckoutBookSuccessfully() {
        book1.checkoutItem();
        assertTrue(book1.isBooked());
    }

    @Test
    public void shouldCheckoutMovieSuccessfully() {
        movie1.checkoutItem();
        assertTrue(movie1.isBooked());
    }

    @Test
    public void shouldReturnBookSuccessfully() {
        book1.returnItem();
        assertFalse(book1.isBooked());

    }

    @Test
    public void shouldReturnMovieSuccessfully() {
        movie1.returnItem();
        assertFalse(movie1.isBooked());

    }

    @Test
    public void shouldRetrieveAvailableBooks() {
        book1.checkoutItem();
        assertEquals(2, catalogueAdmin.retrieveAvailableBookList().size());
    }

    @Test
    public void shouldRetrieveAvailableMovies() {
        movie1.checkoutItem();
        assertEquals(1,catalogueAdmin.retrieveAvailableMovieList().size());

    }

}

