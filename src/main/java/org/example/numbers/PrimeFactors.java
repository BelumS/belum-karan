package org.example.numbers;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeFactors {
	private PrimeFactors(){}

	public static void calculate(Scanner console) {
		try {
			System.out.print("Enter an integer to view it's Prime Factors: ");
			int n = console.nextInt();
			System.out.println();

			System.out.println("The Prime Factors of (" + n + ") are: " + Arrays.toString(Primeable.extractPrimeFactors(n)));
		} catch(Exception e) {
			System.out.println("Failed to calculate Prime Factors: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
