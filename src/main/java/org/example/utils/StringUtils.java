package org.example.utils;

import org.example.constants.ValueConstants;

public final class StringUtils {
    private StringUtils() {
    }

    public static boolean isNotBlank(String input) {
        return input != null
                && !input.strip().isEmpty()
                && !input.isBlank();
    }

    public static boolean isNotEmpty(String input) {
        return input != null && !input.strip().isEmpty();
    }

    public static boolean isBlank(String input) {
        return input == null
                || input.isBlank();
    }

    public static boolean isEmpty(String input) {
        return input == null
                || input.strip().isEmpty();
    }

    public static String capitalize(String input) {
        if (isBlank(input)) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static String getValueWithDefaultEmpty(String input) {
        return (isBlank(input) || isEmpty(input)) ? ValueConstants.VALUE_EMPTY : input;
    }

    public static String getValueWithDefaultZero(String input) {
        return (isBlank(input) || isEmpty(input)) ? ValueConstants.VALUE_ZERO : input;
    }

    public static boolean getValueWithDefaultFalse(String input) {
        return input != null;
    }

//TODO: Create a capitalize() for any number of inputs (i.e., multiple words)
}
