package org.example.numbers;

import org.example.constants.NumberConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * Determines the next prime number in a sequence.
 */
public class NextPrime {
    private NextPrime() {
    }

    /**
     * Displays the a sequence of prime numbers.
     *
     * @param console the keyboard input shared from the Numbers menu.
     * @throws NumberFormatException If an invalid input is used
     */
    public static List<Integer> infinitePrimes(Scanner console) {
        try {
            out.print("Enter an integer to view its Primes: ");
            int from = NumberConstants.validateEntry(Integer.parseInt(console.next()));
            out.println();

            out.printf("Find All Primes Up to %d, press Q to Quit.%n", from);
            out.print("> ");
            String choice = console.next();
            out.println();

            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= from; i += 2) {
                if (Primeable.isPrime(i)) {
                    Primeable.checkPrime(i);
                    list.add(i);
                    out.print("Quit [q]? > ");
                    choice = console.next();
                    out.println();
                } else {
                    continue;
                }

                if (choice.equalsIgnoreCase("Q") || choice.equalsIgnoreCase("Quit")) {
                    return list;
                }
            }
            return new ArrayList<>();
        } catch (NumberFormatException e) {
            err.println(NumberConstants.INVALID_INPUT);
            throw e;
        } catch (Exception e) {
            err.println("An error occurred while processing the prime numbers!");
            throw e;
        }
    }
}
