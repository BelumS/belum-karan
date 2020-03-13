package org.example.commons;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * Represents the shared members for the test classes.
 */
public final class TestConstants {
    private TestConstants(){}

    /**
     * A shared <code>Scanner</code> to be used amongst the test classes.
     * @param input the <code>String</code> standard input
     * @return the shared input <code>Scanner</code> for the test classes.
     */
    public static Scanner testScanner(String input) {
        return new Scanner(new ByteArrayInputStream(input.getBytes()));
    }
}
