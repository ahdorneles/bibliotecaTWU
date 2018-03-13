package com.twu.biblioteca;

import com.twu.biblioteca.utils.Message;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class MessageTest {

    @Test
    public void welcomeMessageTest() {
        assertEquals("Welcome to Biblioteca!", new Message().welcomeMessage());
    }

    @Test
    public void checkoutSucceedMessageTest() {
        assertEquals("Thank you! Enjoy :)\n", new Message().isCheckoutSuccessful(true));
    }

    @Test
    public void checkoutUnsucceedMessageTest() {
        assertEquals("This item is not available.\n", new Message().isCheckoutSuccessful(false));
    }

    @Test
    public void returnSuceedMessageTest() {
        assertEquals("Thank you for returning it :).\n", new Message().isReturnSuccessful(true));
    }

    @Test
    public void returnUnsucceedMessageTest () {
        assertEquals("That is not a valid item to return.\n", new Message().isReturnSuccessful(false));
    }

    @Test
    public void notAvalidOptionMessageTest () {
        assertEquals("Select a valid option!", new Message().isItAValidOption(false));
    }


}
