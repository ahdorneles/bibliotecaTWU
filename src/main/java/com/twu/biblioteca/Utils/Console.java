package com.twu.biblioteca.Utils;

import com.twu.biblioteca.Utils.Message;

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

    public String selectAnOption() {
        print(message.selectAnOption());
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

    public void printAnyList(List<String> strings) {
        print(message.listHead());

        for (String s :
                strings) {
            print(s);
        }

    }

    public void print(String string) {
        System.out.println(string);

    }

    public void printAuthor() {
    }

    public void bye() {
        print(message.bye());
    }

    public void login() {


    }
}
