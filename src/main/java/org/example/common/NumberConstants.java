package org.example.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents the shared members (variables and methods) of the numeric algorithms.
 */
public final class NumberConstants {
    private NumberConstants(){}

    //Menu Titles
    public static final String TITLE = "Numbers";
    public static final String TITLE_PI = "PI to the Nth";
    public static final String TITLE_E = "E to the Nth";
    public static final String TITLE_FIBONACCI = "Fibonacci";
    public static final String TITLE_PRIME_FACTORS = "Prime Factors";
    public static final String TITLE_NEXT_PRIME = "Next Prime";
    public static final String TITLE_TILE_COST = "Tile Cost";
    public static final String TITLE_MORTGAGE = "Mortgage";
    public static final String TITLE_CHANGE_RETURN = "Change Return";
    public static final String TITLE_NUMBER_CONVERTER = "Number Converter";

    //Error Messages
    public static final String DECIMAL_OVERFLOW = "Error: Decimal Overflow!";
    public static final String INTEGER_OVERFLOW = "Error, that number is too large for computation!";
    public static final String NEGATIVE_NUMBER = "Error, cannot compute a negative number!";
    public static final String INVALID_PRIME = "Not a valid candidate for prime number(s).";
    public static final String INVALID_INPUT = "Error: the input data cannot be computed!";
    private static final String INVALID_INPUT_EXCEPTION = " is not a valid input for computation!";

    public static final int DECIMAL_PLACE_LIMIT = 20;

    /**
     * Provides a precisely rounded currency value.
     * @param val the floating point number to be rounded.
     * @return a value rounded to 2 decimal places.
     */
    public static double roundedCurrencyValue(double val) {
        return BigDecimal.valueOf(val).setScale(2, RoundingMode.DOWN).doubleValue();
    }

    /**
     * Displays an error message to the console, and then ends the program in error.
     * @param e - The Exception whose stack trace will displayed on the console.
     * @param message - The detailed message explaining why the error occurred.
     */
    public static void printError(Exception e, String message) {
        System.err.println(message);
        if(e != null) {
            e.printStackTrace();
        }
        System.exit(-1);
    }

    /**
     * Determines if an integer is valid.
     * @param val the number whose validity will be determined
     * @return a valid integer.
     * @throws IllegalArgumentException if the integer is negative, or an overflow value.
     */
    public static int validateEntry(int val) throws IllegalArgumentException {
        if(val < 0 || val >= Integer.MAX_VALUE)
            throw new IllegalArgumentException("\"" + val + INVALID_INPUT_EXCEPTION);
        return val;
    }

    /**
     * Determines if a long is valid.
     * @param val the number whose validity will be determined
     * @return a valid long.
     * @throws IllegalArgumentException if the long is negative, or an overflow value.
     */
    public static long validateInput(long val) throws IllegalArgumentException {
        if(val < 0L || val >= Long.MAX_VALUE)
            throw new IllegalArgumentException(val + INVALID_INPUT_EXCEPTION);
        return val;
    }

    /**
     * Determines if a double is valid.
     * @param val the number whose validity will be determined
     * @return a valid double.
     * @throws IllegalArgumentException if the double is negative, or an overflow value.
     */
    public static double validateEntry(double val) throws IllegalArgumentException {
        if(val < 0.0 || val >= Double.MAX_VALUE)
            throw new IllegalArgumentException("\"" + val + INVALID_INPUT_EXCEPTION);
        return val;
    }
}