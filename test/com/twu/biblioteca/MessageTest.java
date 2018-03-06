
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class MessageTest {

    @Test
    public void welcomeMessageTest() {
        assertEquals("Welcome to Biblioteca!", new Message().welcomeMessage());
    }

    @Test
    public void checkoutSucceedMessageTest() {
        assertEquals("Thank you! Enjoy the book", new Message().isCheckoutSuccessful(true));
    }

    @Test
    public void checkoutUnsucceedMessageTest() {
        assertEquals("That book is not available.", new Message().isCheckoutSuccessful(false));
    }

    @Test
    public void returnSuceedMessageTest() {
        assertEquals("Thank your for returning the book.", new Message().isReturnSuccessful(true));
    }

    @Test
    public void returnUnsucceedMessageTest () {
        assertEquals("That is not a valid book to return.", new Message().isReturnSuccessful(false));
    }

    @Test
    public void notAvalidOptionMessageTest () {
        assertEquals("Select a valid option!", new Message().isItAValidOption(false));
    }


}
