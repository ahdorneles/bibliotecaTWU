package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class Console {

    private Scanner input;
    private Message message = new Message();

    public Console(Scanner input) {
        this.input = input;
    }

    public void greeting() {
        System.out.println(message.welcomeMessage());
    }

    public String selectAnOption() {
        System.out.println(message.selectAnOption());
        return input.next();
    }


    public void printList(List<String> strings) {
        for (String s :
                strings) {
            System.out.println(s);
        }
    }

    public String again() {
        System.out.println(message.doYouWantToContinue());
        return input.next();

    }
}
