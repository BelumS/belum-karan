package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.Scanner;

import static java.lang.System.out;

public class NextPrime {
	private NextPrime() {
	}

	public static void infinitePrimes(Scanner console) {
		try {
			out.print("Enter an integer to view its Primes: ");
			int from = console.nextInt();
			out.println();

			out.printf("Find All Primes Up to %d, press Q to Quit.%n", from);
			out.print("> ");
			String choice = console.next();
			out.println();

			for (int i = 1; i < from; i += 2) {
				if (Primeable.isPrime(i)) {
					Primeable.checkPrime(i);
					out.print("Quit? > ");
					choice = console.next();
				} else
					continue;

				if (choice.equalsIgnoreCase("q"))
					System.exit(0);
			}
		} catch (Exception e) {
			NumberConstants.printError(e,"Failed to Find Primes due to: " + e.getMessage());
		}
	}
}
