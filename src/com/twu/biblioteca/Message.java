
public class Message {


    public String welcomeMessage () {
        return "Welcome to Biblioteca!";
    }

    public String isCheckoutSuccessful(boolean succeed) {

        return succeed
                ? "Thank you! Enjoy the book"
                :  "That book is not available.";
    }

    public String isReturnSuccessful (boolean succeed) {
        return succeed
                ? "Thank your for returning the book."
                : "That is not a valid book to return.";
   }

    public String isItAValidOption(boolean validOption) {
        return validOption ? "" : "Select a valid option!";
    }


    public String theresNoBook() {
        return "There's no such a book in our list.";
    }
}