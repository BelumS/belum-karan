package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * Binary to Decimal Converter
 * <p>
 * Converts a decimal number (base 10) to binary number (base 2),
 * or a vice-versa.
 */
public class NumberBaseConverter {
    private NumberBaseConverter() {
    }

    public static void print(Scanner console) {
        try {
            out.print("Are you converting from Binary or Decimal?: ");
            String choice = console.next();
            out.println();

            if (choice.equalsIgnoreCase("binary") || choice.equalsIgnoreCase("decimal")) {
                out.printf("Enter a '%s' number: %n", choice);
                int number = NumberConstants.validateEntry(Integer.parseInt(console.next()));
                out.println();

                out.println("\nValue: " + numberConversion(choice, number));
            } else {
                throw new IllegalArgumentException("\"" + choice + "\" is not a valid choice!");
            }
        } catch (IllegalArgumentException | InputMismatchException e) {
            err.println("Unable to complete the conversion due to: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            err.println("An error occurred during the number conversion!");
            throw e;
        }
    }

    private static String numberConversion(String choice, int val) {
        if (choice.equalsIgnoreCase("binary")) {
            return convertDecimalToBinary(val);
        } else if (choice.equalsIgnoreCase("decimal"))
            return convertBinaryToDecimal(val);
        return "Invalid Option!";
    }

    private static String convertBinaryToDecimal(int val) {
        return Integer.toBinaryString(val);
    }

    private static String convertDecimalToBinary(int val) {
        return Integer.toString(Integer.parseInt(Integer.toString(val), 2));
    }
}