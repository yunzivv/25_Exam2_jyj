package org.example.container;

import java.util.Scanner;

public class Container {

    static Scanner sc;

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static Scanner getScanner() {
        return sc;
    }

    public static void close() {
        sc.close();
    }
}
