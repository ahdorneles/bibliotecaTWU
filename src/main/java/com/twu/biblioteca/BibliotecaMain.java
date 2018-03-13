package com.twu.biblioteca;


import com.twu.biblioteca.utils.CatalogueAdmin;
import com.twu.biblioteca.utils.Console;

import java.util.Scanner;

public class BibliotecaMain {

    public static void main(String[] args) {

        BibliotecaApp biblioteca = new BibliotecaApp(new CatalogueAdmin(),new Console(new Scanner(System.in)));
        biblioteca.init();
    }
}
