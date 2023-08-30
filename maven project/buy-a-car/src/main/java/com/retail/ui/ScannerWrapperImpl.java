package com.retail.ui;

import java.util.Scanner;

import com.retail.ui.ScannerWrapperInterface;

public class ScannerWrapperImpl implements ScannerWrapperInterface {
    static Scanner scanner = new Scanner(System.in);

    public String readString() {
        String value = scanner.next();
        scanner.close();

        return value;
    }

    public int readInt() {
        int value = scanner.nextInt();
        scanner.close();

        return value;
    }

    public float readFloat() {
        float value = scanner.nextFloat();
        scanner.close();

        return value;
    }
}
