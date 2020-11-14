package org.example.numbers;

import org.example.constants.NumberConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

public class Enth {
    private Enth() {}

    /**
     * Displays the number e(2.71).
     * @param console the keyboard input shared from the Numbers menu.
     * @return the number e
     * @throws IllegalArgumentException if an invalid number is used
     * @throws InputMismatchException If an invalid input is used
     */
    public static BigDecimal displayE(Scanner console) {
        BigDecimal result = BigDecimal.valueOf(-1L);
        try {
            out.print("Enter an integer between [0 and 20]: ");
            int choice = NumberConstants.validateEntry(console.nextInt());
            out.println();

            if (choice == 0) {
                result = BigDecimal.valueOf(2);
                out.println(result);
            } else if (choice > 0 && choice <= NumberConstants.DECIMAL_PLACE_LIMIT) {
                result = BigDecimal.valueOf(Math.E).setScale(choice, RoundingMode.DOWN);
                out.println(result);
            } else
                throw new IllegalArgumentException("Error! \"" + choice + "\" does not fit the criteria.");
        } catch (IllegalArgumentException | InputMismatchException e) {
            err.println("Failed to process e: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            err.println("Failed to Display e: " + e.getMessage());
            throw e;
        }
        return result;
    }
}
