package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

public class PrimeFactors {
	private PrimeFactors(){}

	public static void calculate(Scanner console) {
		try {
			out.print("Enter an integer to view it's Prime Factors: ");
			int n = Integer.parseInt(console.next());
			out.println();

			out.println("The Prime Factors of (" + n + ") are: " + Arrays.toString(Primeable.extractPrimeFactors(n)));
		} catch (NumberFormatException e) {
			err.println(NumberConstants.INVALID_INPUT);
			throw e;
		} catch(Exception e) {
			err.println("Failed to calculate Prime Factors: " + e.getMessage());
			throw e;
		}
	}
}
