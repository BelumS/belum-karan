package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * Converts a decimal number (base 10) to binary number (base 2),
 * or a vice-versa.
 */
public class NumberBaseConverter {
    private NumberBaseConverter() {
    }

    /**
     * Displays the converted number.
     * @param console the keyboard input shared from the Numbers menu.
     * @return the String representing the converted number.
     * @throws IllegalArgumentException if an invalid number is used
     * @throws InputMismatchException If an invalid input is used
     */
    public static String print(Scanner console) throws IllegalArgumentException, InputMismatchException {
        try {
            out.print("Are you converting from Binary or Decimal?: ");
            String choice = console.next();
            out.println();

            if (choice.equalsIgnoreCase("binary") || choice.equalsIgnoreCase("decimal")) {
                out.printf("Enter a '%s' number: %n", choice);
                int number = NumberConstants.validateEntry(Integer.parseInt(console.next()));

                String answer = numberConversion(choice, number);
                out.println("\nValue: " + answer);
                return answer;
            } else
                throw new IllegalArgumentException("\"" + choice + "\" is not a valid choice!");
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
        }
        return convertBinaryToDecimal(val);
    }

    private static String convertBinaryToDecimal(int val) {
        return Integer.toBinaryString(val);
    }

    private static String convertDecimalToBinary(int val) {
        return Integer.toString(Integer.parseInt(Integer.toString(val), 2));
    }
}