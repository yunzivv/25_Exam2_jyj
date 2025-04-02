package org.example.main;


import org.example.app.App;
import org.example.container.Container;

public class Main {
    public static void main(String[] args) {

        Container.init();

        new App().run();

        Container.close();

    }
}