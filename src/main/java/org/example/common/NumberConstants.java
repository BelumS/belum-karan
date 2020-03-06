package org.example.common;

import java.util.Objects;

public final class NumberConstants {
    private NumberConstants(){}

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

    public static final String DECIMAL_OVERFLOW = "Error: Decimal Overflow!";
    public static final String INTEGER_OVERFLOW = "Error, that number is too large for computation!";
    public static final String NEGATIVE_NUMBER = "Error, cannot compute a negative number!";
    public static final String INVALID_PRIME = "Not a valid candidate for prime number(s).";

    public static final int DECIMAL_LIMIT = 20;

    public static void printError(Exception e, String message) {
        System.err.println(Objects.requireNonNull(message));
        if(e != null) {
            e.printStackTrace();
        }
        System.exit(-1);
    }
}