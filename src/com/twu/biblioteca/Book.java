import java.util.ArrayList;
import java.util.List;

public class Book {

    private String title;
    private String author;
    private int publishYear;
    private boolean isBooked = false;


    public Book (){

    }

    public Book(String title, String author, int publishYear) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }


    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked() {
        isBooked = true;
    }

    public void returnBook() {
        isBooked = false;
    }
}
