package com.twu.biblioteca;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class BibliotecaTest {

    @Mock
    Console console;


    @Test
    public void shouldPrintWelcomeMessage() {
        BookManager bookManager = new BookManager();
        Biblioteca biblioteca = new Biblioteca(bookManager,console);

        biblioteca.menu();

        verify(console,times(2)).greeting();

    }
}