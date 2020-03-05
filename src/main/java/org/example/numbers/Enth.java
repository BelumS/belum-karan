package org.example.numbers;

import org.example.common.NumberConstants;

import static java.lang.System.out;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

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
                NumberConstants.printError(null, choice + " is not a valid number.");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            NumberConstants.printError(e, "Failed to process e: " + e.getMessage());
        } catch (Exception e) {
            NumberConstants.printError(e, "Failed to Display e: " + e.getMessage());
        }
        return result;
    }
}
