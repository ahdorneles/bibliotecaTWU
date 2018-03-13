package com.twu.biblioteca;

import com.twu.biblioteca.LibraryItem.LibraryItem;
import com.twu.biblioteca.Utils.CatalogueAdmin;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class CatalogueTest {


    private CatalogueAdmin bookManager;
    private LibraryItem.Book book1;

    @Before
    public void initialize() {
        bookManager = new CatalogueAdmin();
        book1 = new LibraryItem.Book("22", "jose", 1928);
        LibraryItem.Book book2 = new LibraryItem.Book("33", "maria", 1989);
        LibraryItem.Book book3 = new LibraryItem.Book("44", "maria", 2019);

        bookManager.addItemTolist(book1);
        bookManager.addItemTolist(book2);
        bookManager.addItemTolist(book3);

    }

    @Test
    public void retrieveLibraryItemListTest() {

        List<LibraryItem> bookList = bookManager.retrieveItemsList();
        assertEquals(3, bookList.size());

    }

    @Test
    public void retrieveBookAuthorByTitleTest() {
        assertEquals("jose", bookManager.getAuthorByTitle("22"));

    }


    @Test
    public void retrieveTitleByAuthorTest() {
        assertEquals(2, bookManager.getTitleByAuthor("maria").size());

    }

    @Test
    public void setBookBookedTest() {
        book1.returnBook();
        assertTrue(book1.isBooked());
    }

    @Test
    public void setBookAvailableTest() {
        book1.returnBook();
        assertTrue(book1.isBooked());

        book1.returnBook();
        assertFalse(book1.isBooked());

    }

    @Test
    public void retrieveAvailableBookListTest() {
        book1.checkoutBook();
        assertEquals(2, bookManager.retrieveAvailableBookList().size());

    }

    @Test
    public void bookAbookTest() {
        book1.checkoutBook();
        assertTrue(book1.isBooked());

    }


}
