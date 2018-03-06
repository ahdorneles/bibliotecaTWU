package com.twu.biblioteca;

import java.util.Scanner;

public class Console {

    private Scanner input;
    private Message message = new Message();
    private BookManager bookManager = new BookManager();

    public void init () {

    }

    public void greeting () {
        System.out.println(message.welcomeMessage());
    }

    public void selectAnOption () {
        System.out.println(message.selectAnOption());
    }



}
