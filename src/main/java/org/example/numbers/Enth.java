package org.example.numbers;

import org.example.common.NumberConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

public class Enth {
    private Enth() {
    }

    public static BigDecimal displayE(Scanner console) {
        BigDecimal result = BigDecimal.ZERO;
        try {
            out.print("Enter an integer between [0 and 20]: ");
            int choice = console.nextInt();
            out.println();

            if (choice == 0) {
                result = BigDecimal.valueOf(2);
                out.println(result);
            } else if (choice > 0 && choice <= NumberConstants.DECIMAL_LIMIT) {
                result = BigDecimal.valueOf(Math.E).setScale(choice, RoundingMode.DOWN);
                out.println(result);
            } else {
                throw new IllegalArgumentException(choice + " is not a valid number.");
            }
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
