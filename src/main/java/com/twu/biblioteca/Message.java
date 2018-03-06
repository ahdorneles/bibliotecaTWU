package com.twu.biblioteca;

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

    public String selectAnOption () {
        return "Please select an Option \n" +
                "1. List Books";
    }

    public String doYouWantToContinue () {
        return "Do you want to continue on the app? Type Y for Yes, or N for no";
    }

    public String bye () {
        return "See you next time! ";
    }
}