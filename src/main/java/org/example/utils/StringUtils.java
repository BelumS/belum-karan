package org.example.utils;

public final class StringUtils {
    private StringUtils() {
    }

    public static String capitalize(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    //TODO: Create a capitalize() for any number of inputs (i.e., multiple words)
}
