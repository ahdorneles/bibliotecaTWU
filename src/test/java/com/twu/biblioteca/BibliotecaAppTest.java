package com.twu.biblioteca;
import com.twu.biblioteca.LibraryItem.LibraryItem;
import com.twu.biblioteca.Utils.CatalogueAdmin;
import com.twu.biblioteca.Utils.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {

    private BibliotecaApp biblioteca;
    private LibraryItem.Book book;

    @Mock
    private
    Console console;

    @Mock
    private
    CatalogueAdmin catalogueAdmin;



    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        book = new LibraryItem.Book("22","22", 1234);
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
    public void shouldSearchAuthorByTitle(){
        verify(console,times(1)).printAuthor();
    }

    @Test
    public void shouldCheckoutAbook() {
        System.out.println(catalogueAdmin.retrieveItemsList().size());

    }
}