package org.example.numbers;

import java.util.Scanner;

public class NextPrime {
	private NextPrime() {
	}

	public static void infinitePrimes(Scanner console) {
		try {
			System.out.print("Enter an integer to view its Primes: ");
			int from = console.nextInt();
			System.out.println();

			System.out.printf("Find All Primes Up to %d, press Q to Quit.%n", from);
			System.out.print("> ");
			String choice = console.next();
			System.out.println();

			for (int i = 1; i < from; i += 2) {
				if (Primeable.isPrime(i)) {
					Primeable.checkPrime(i);
					System.out.print("Quit? > ");
					choice = console.next();
				} else
					continue;

				if (choice.equalsIgnoreCase("q"))
					System.exit(0);
				else
					continue;
			}
		} catch (Exception e) {
			System.out.println("Failed to Find Primes due to: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
