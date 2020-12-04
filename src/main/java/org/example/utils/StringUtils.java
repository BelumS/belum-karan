package org.example.utils;

import org.example.constants.ValueConstants;

import java.util.regex.Pattern;

public final class StringUtils {
    private StringUtils() {
    }

    private static final String ONLY_WORDS_REGEX = "^[a-zA-Z\\s]+$";
    private static final String ONLY_DIGITS_REGEX = "^[0-9\\s]+$";

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

    /**
     * Checks if the input is a vowel
     *
     * @param ch the input character
     * @return true, if the input is a vowel.
     */
    public static boolean hasFirstVowel(char ch) {
        return "aeiouyAEIOUY".indexOf(ch) != -1;
    }

    public static String validateWords(String input) {
        if (Pattern.matches(ONLY_WORDS_REGEX, input)) {
            return input;
        } else
            throw new AssertionError("'" + input + "' is not a textual input!");
    }

    public static String validateNumbers(String input) {
        if (Pattern.matches(ONLY_DIGITS_REGEX, input)) {
            return input;
        } else
            throw new AssertionError("'" + input + " is not a numeric input!");
    }
//TODO: Create a capitalize() for any number of inputs (i.e., multiple words)
}
