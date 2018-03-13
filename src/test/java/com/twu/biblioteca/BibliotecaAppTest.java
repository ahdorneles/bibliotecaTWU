package com.twu.biblioteca;
import com.sun.source.tree.AssertTree;
import com.sun.tools.internal.xjc.reader.dtd.bindinfo.BIAttribute;
import com.twu.biblioteca.libraryitem.Book;
import com.twu.biblioteca.libraryitem.LibraryItem;
import com.twu.biblioteca.utils.CatalogueAdmin;
import com.twu.biblioteca.utils.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {

    private BibliotecaApp biblioteca;
    private LibraryItem book;

    @Mock
    private
    Console console;

    @Mock
    private
    CatalogueAdmin catalogueAdmin;



    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        book = new Book("22","22", 1234);
        biblioteca = new BibliotecaApp(catalogueAdmin,console);

    }
    @Test
    public void shouldPrintWelcomeMessage() {
        biblioteca.greeting();
        verify(console,times(1)).greeting();

    }

    @Test
    public void shouldAddBookToList (){
        biblioteca.addItemToList(book);
        verify(catalogueAdmin,times(1)).addItemTolist(book);
        verify(console, times(1)).bookAddedToList();
    }


    @Test
    public void shouldCheckoutAbook() {
        System.out.println(catalogueAdmin.retrieveItemsList().size());
    }


}