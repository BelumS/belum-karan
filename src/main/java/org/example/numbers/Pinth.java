package org.example.numbers;

import org.example.common.NumberConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;
import static org.example.common.NumberConstants.printError;

public final class Pinth {
    private Pinth() {
    }

    public static BigDecimal displayPi(Scanner console) {
        BigDecimal result = BigDecimal.ZERO;
        try {
            out.print("Enter an integer between [0 and 20]: ");
            int choice = Integer.parseInt(console.next());

            if (choice == 0) {
                result = BigDecimal.valueOf(3);
                out.println(result);
            } else if (choice > 0 && choice <= NumberConstants.DECIMAL_LIMIT) {
                result = BigDecimal.valueOf(Math.PI).setScale(choice, RoundingMode.DOWN);
                out.println(result);
            } else {
                throw new IllegalArgumentException("Error! \"" + choice + "\" does not fit the criteria.");
            }
        } catch (IllegalArgumentException e) {
            err.println("Unable to process the number: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            err.println("Failed to Display PI: " + e.getMessage());
            throw e;
        }
        return result;
    }
}
