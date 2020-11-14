package org.example.numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Factorial of a positive integer, n,
 * is defined as the product of the sequence n, n-1, n-2, ...1
 * and the factorial of zero, 0, is defined as being 1.
 * Solve this using both loops and recursion.
 */
public final class FactorialFinder {
    private FactorialFinder() {
    }

    /**
     * Displays the factorials of the input.
     *
     * @param scanner the keyboard input
     * @return the highest input factorial as a string.
     */
    public static String displayFactorials(Scanner scanner) {
        try {
            System.out.println("Enter a number to view it's factorials.");
            String choice = scanner.next();

            int choiceAsInt = Integer.parseInt(choice);
            String factorial = "";
            for (int i = choiceAsInt; i >= 0; i--) {
                System.out.println(i + "! = " + factorial(i));

                if (factorial(i) == factorial(choiceAsInt)) {
                    factorial = String.valueOf(factorial(i));
                }
            }
            return factorial;
        } catch (NumberFormatException | InputMismatchException e) {
            System.err.println("An Exception occurred: " + e);
            throw e;
        }
    }

    private static int factorial(int n) {
        assert n >= 0;

        if (n <= 1)
            return n;

        return n * factorial(n - 1);
    }
}
