package com.retail.ui;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleInteractionImpl implements ConsoleInteraction {
    private static final PrintStream OUT = System.out;
    static Scanner scanner = new Scanner(System.in);

    public String readString(String text) {
        String s = "";
        OUT.println(text);
        s = scanner.next();

        return s;
    }

    public int readNumber(String text) {
        int number = 0;
        OUT.println(text);
        try {
            number = scanner.nextInt();
        } catch (Exception e) {
            OUT.println("What you have provided is not a number. Please try again.");
            readNumber(text);
        }

        return number;
    }

    public float readFloatNumber(String text) {
        float number = 0;
        OUT.println(text);
        try {
            number = scanner.nextFloat();
        } catch (Exception e) {
            OUT.println("What you have provided is not a number. Please try again.");
            readNumber(text);
        }

        return number;
    }
}
