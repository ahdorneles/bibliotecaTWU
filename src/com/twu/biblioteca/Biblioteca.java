
public class Biblioteca {

    private BookManager bookManager;

    public void bookAbook () {
        bookManager.bookAbook();
    }

    public void returnAbook(Book book) {
        bookManager.returnAbook();
    }

    public void bookDetails (Book book) {
        bookManager.bookDetails();
    }

    public void menu () {
        bookManager.retrieveBookListForMenu();

    }

    public BookManager getBookManager() {
        return bookManager;
    }

    public void setBookManager(BookManager bookManager) {
        this.bookManager = bookManager;
    }
}
