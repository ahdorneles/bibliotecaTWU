package com.twu.biblioteca;

import com.twu.biblioteca.utils.Console;
import com.twu.biblioteca.utils.Message;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;


public class ConsoleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Mock
    Console console;

    @Mock
    Scanner scanner;

    @Mock
    Message message;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(ConsoleTest.class);
        console = new Console(scanner);
    }

    @Test
    public void shouldPrintGreeting() {
        console.greeting();

    }

}
