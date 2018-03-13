
package com.twu.biblioteca;

import com.twu.biblioteca.libraryitem.Book;
import com.twu.biblioteca.libraryitem.LibraryItem;
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

    @Before
    public void initialize() {
        catalogueAdmin = new CatalogueAdmin();
        book1 = new Book("22", "jose", 1928);
        LibraryItem book2 = new Book("33", "maria", 1989);
        LibraryItem book3 = new Book("44", "maria", 2019);

        catalogueAdmin.addItemTolist(book1);
        catalogueAdmin.addItemTolist(book2);
        catalogueAdmin.addItemTolist(book3);

    }

    @Test
    public void retrieveLibraryItemListTest() {

        List<LibraryItem> bookList = catalogueAdmin.retrieveItemsList();
        assertEquals(3, bookList.size());

    }

    @Test
    public void retrieveBookAuthorByTitleTest() {
        assertEquals("jose", catalogueAdmin.getAuthorByTitle("22"));

    }


    @Test
    public void retrieveTitleByAuthorTest() {
        assertEquals(2, catalogueAdmin.getTitleByAuthor("maria").size());

    }

    @Test
    public void setBookBookedTest() {
        book1.checkoutItem();
        assertTrue(book1.isBooked());
    }

    @Test
    public void setBookAvailableTest() {

        book1.returnItem();
        assertFalse(book1.isBooked());

    }

    @Test
    public void retrieveAvailableBookListTest() {
        book1.checkoutItem();
        assertEquals(2, catalogueAdmin.retrieveAvailableBookList().size());

    }

    @Test
    public void bookAbookTest() {
        book1.checkoutItem();
        assertTrue(book1.isBooked());

    }


}

