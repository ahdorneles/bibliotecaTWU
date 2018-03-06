import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class BookManagerTest {


    private BookManager bookManager;
    private Book book1;

    @Before
    public void initialize() {
        bookManager = new BookManager();
        book1 = new Book("22", "jose", 1928);
        Book book2 = new Book("33", "maria", 1989);
        Book book3 = new Book("44", "maria", 2019);

        bookManager.addBookTolist(book1);
        bookManager.addBookTolist(book2);
        bookManager.addBookTolist(book3);

    }

    @Test
    public void retrieveBookListTest() {

        List<Book> bookList = bookManager.retrieveBookList();
        assertEquals(3, bookList.size());

    }

    @Test
    public void retrieveBookAuthorByTitleTest() {
        assertEquals("jose", bookManager.getAuthorByTitle("22"));

    }

    @Test
    public void retrieveBookYearByTitleTest() {
        assertEquals(1989, bookManager.getYearByTitle("33"));


    }

    @Test
    public void retrieveTitleByAuthorTest() {
        assertEquals(2, bookManager.getTitleByAuthor("maria").size());

    }

    @Test
    public void setBookBookedTest() {
        book1.setBooked();
        assertTrue(book1.isBooked());
    }

    @Test
    public void setBookAvailableTest() {
        book1.setBooked();
        assertTrue(book1.isBooked());

        book1.returnBook();
        assertFalse(book1.isBooked());

    }

    @Test
    public void retrieveAvailableBookListTest() {
        book1.setBooked();
        assertEquals(2, bookManager.retrieveAvailableBookList().size());

    }

    @Test
    public void retrieveBookedBookList() {
        book1.setBooked();
        assertEquals(1, bookManager.retrieveBookedBookList().size());
    }


}
