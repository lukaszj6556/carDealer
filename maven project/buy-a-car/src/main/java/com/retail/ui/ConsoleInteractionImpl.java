package com.retail.ui;

import java.io.PrintStream;

import com.retail.ui.ScannerWrapperInterface;

public class ConsoleInteractionImpl implements ConsoleInteraction {
    private static final PrintStream OUT = System.out;
    ScannerWrapperInterface wrapper;

    public ConsoleInteractionImpl(ScannerWrapperInterface wrapper) {
        this.wrapper = wrapper;
    }

    public String readString(String text) {
        String s = "";
        OUT.println(text);
        s = wrapper.readString();

        return s;
    }

    public int readNumber(String text) {
        int number = 0;
        OUT.println(text);
        try {
            number = wrapper.readInt();
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
            number = wrapper.readFloat();
        } catch (Exception e) {
            OUT.println("What you have provided is not a number. Please try again.");
            readNumber(text);
        }

        return number;
    }
}
