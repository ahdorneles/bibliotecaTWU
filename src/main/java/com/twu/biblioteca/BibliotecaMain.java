package com.twu.biblioteca;


import com.twu.biblioteca.Utils.CatalogueAdmin;
import com.twu.biblioteca.Utils.Console;

import java.util.Scanner;

public class BibliotecaMain {

    public static void main(String[] args) {

        BibliotecaApp biblioteca = new BibliotecaApp(new CatalogueAdmin(),new Console(new Scanner(System.in)));
        biblioteca.init();
    }
}
