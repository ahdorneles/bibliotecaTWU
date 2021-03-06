package com.twu.biblioteca.utils;


import java.util.List;
import java.util.Scanner;

public class Console {
    private Scanner input;

    private Message message = new Message();

    public Console(Scanner input) {
        this.input = input;
    }

    public void greeting() {
        print(message.welcomeMessage());
    }

    public String clientMenu() {
        print(message.clientMenu());
        return input.next();
    }


    public String adminMenu() {
        print(message.adminMenu());
        return input.next();
    }

    public String loginOrList() {
        print(message.loginOrList());
        return input.next();
    }


    public String again() {
        print(message.doYouWantToContinue());
        return input.next();

    }

    public void bookAddedToList() {
        print(message.bookAddedToList());

    }

    public void checkoutSucceed(boolean bool) {
        print(message.isCheckoutSuccessful(bool));
    }

    public void returnSucced(boolean bool) {
        print(message.isReturnSuccessful(bool));
    }

    public void printBookList(List<String> strings) {
        print(message.bookListHead() + '\n');

        for (String s :
                strings) {
            print(s);
        }

    }

    public void printMovieList(List<String> strings) {
        print(message.movieListHead() + '\n');

        for (String s :
                strings) {
            print(s);
        }

    }

    public void print(String string) {
        System.out.println(string);

    }


    public void bye() {
        print(message.bye());
    }


    public void loginSucceed(boolean loginSucceed) {
        print(message.isLoginSuccessful(loginSucceed));

    }

    public String password() {
        print(message.password());
        return input.next();
    }

    public String username() {
        print(message.username());
        return input.next();

    }

    public String simpleMenu() {
        print(message.simpleMenu());
        return input.next();
    }
}
