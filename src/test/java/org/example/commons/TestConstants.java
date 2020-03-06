package org.example.commons;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public final class TestConstants {
    private TestConstants(){}

    public static Scanner testScanner(String input) {
        return new Scanner(new ByteArrayInputStream(input.getBytes()));
    }
}
