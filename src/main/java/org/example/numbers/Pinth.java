package org.example.numbers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;

public final class Pinth {
    private static final int LIMIT = 20;

    private Pinth() {}

    public static BigDecimal displayPi(Scanner console) {
        BigDecimal result;
        try {
            out.print("Enter an integer between [0 and 20]: ");
            int choice = console.nextInt();

            if (choice == 0) {
                result = BigDecimal.valueOf(3);
                out.println(result);
                return result;
            } else if (choice > 0 && choice <= LIMIT) {
                result = BigDecimal.valueOf(Math.PI).setScale(choice, RoundingMode.DOWN);
                out.println(result);
                return result;
            } else {
                out.println("Error! \"" + choice + "\" does not fit the criteria.");
                result = BigDecimal.ZERO;
                System.exit(-1);
            }
        } catch (InputMismatchException e) {
            out.println("Unable to process the number: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            out.println("Failed to Display PI: " + e.getMessage());
            throw e;
        }
        return result;
    }
}
