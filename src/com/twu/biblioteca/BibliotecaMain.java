import com.sun.org.apache.xpath.internal.operations.Bool;

public class BibliotecaMain {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Book book = new Book("22","OLA",1923);
        Book book1 = new Book("44","hey",1023);
        Book book2 = new Book("55", "joao", 1999);

        BookManager bookManager = new BookManager();
        biblioteca.setBookManager(bookManager);
        bookManager.addBookTolist(book);
        bookManager.addBookTolist(book1);
        bookManager.addBookTolist(book2);
        book2.setBooked();

        biblioteca.menu();
    }
}
