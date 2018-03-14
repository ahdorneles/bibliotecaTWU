package com.twu.biblioteca.utils;

public class Message {


    public String listHead() {
        return
                "           TITLE         |" +
                "          AUTHOR         |" +
                " PUBLISH YEAR |" +
                " AVAILABLE | \n";

    }
    public String movieListHead() {
        return
                         "           TITLE         |" +
                        "          AUTHOR         |" +
                        " RATING |" +
                        " AVAILABLE | \n";

    }
    public String welcomeMessage () {
        return "Welcome to Biblioteca!";
    }

    public String isCheckoutSuccessful(boolean succeed) {

        return succeed
                ? "Thank you! Enjoy :)\n"
                :  "This item is not available.\n";
    }

    public String isReturnSuccessful (boolean succeed) {
        return succeed
                ? "Thank you for returning it :).\n"
                : "That is not a valid item to return.\n";
   }

    public String isItAValidOption(boolean validOption) {
        return validOption ? "" : "Select a valid option!";
    }


    public String theresNoBook() {
        return "There's no such a book in our list.";
    }

    public String selectAnOption () {
        return "Please select an Option \n" +
                "1. List Books\n" +
                "2. List Movies\n" +
                "3. My Info\n" +
                "4. To logout";
    }

    public String doYouWantToContinue () {
        return "Do you want to continue on the app? Type Y for Yes, N for no or B to last menu:";
    }

    public String bye () {
        return "See you next time! ";
    }

    public String bookAddedToList() {
        return "The book was added to the List.\n";
    }

    public String loginOrList() {
        return "Please select an Option \n" +
                "1. Login\n" +
                "2. List Available Items";
    }

    public String password() {
        return "Please insert your Password:";
    }

    public String username() {
        return "Please insert your Library Id or B to back to first menu:";

    }

    public String isLoginSuccessful(boolean login) {
        return login ?
                "Login Successful":
                "Login error. Try again";
    }
}