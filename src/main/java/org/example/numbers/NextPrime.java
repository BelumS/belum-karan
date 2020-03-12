package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

public class NextPrime {
    private NextPrime() {
    }

    public static void infinitePrimes(Scanner console) {
        try {
            out.print("Enter an integer to view its Primes: ");
            int from = NumberConstants.validateEntry(Integer.parseInt(console.next()));
            out.println();

            out.printf("Find All Primes Up to %d, press Q to Quit.%n", from);
            out.print("> \r");
            String choice = console.next();
            out.println();

            for (int i = 1; i <= from; i += 2) {
                if (Primeable.isPrime(i)) {
                    Primeable.checkPrime(i);

                    out.print("Quit [q]? > ");
                    choice = console.next();
                } else {
                    continue;
                }

                if (choice.equalsIgnoreCase("Q") || choice.equalsIgnoreCase("Quit")) {
					System.exit(1);
				}
            }
        } catch (NumberFormatException e) {
            err.println(NumberConstants.INVALID_INPUT);
            throw e;
        } catch (Exception e) {
            err.println("An error occurred while processing the prime numbers!");
            throw e;
        }
    }
}
