package org.example.numbers;

import org.example.constants.NumberConstants;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * Represents the prime factorization of a number.
 */
public class PrimeFactors {
	private PrimeFactors(){}

	/**
	 * Calculates the prime factorization of an input.
	 * @param console the keyboard input shared from the Numbers menu.
	 * @return an array of prime factors.
	 * @throws NumberFormatException If an invalid input is used
	 */
	public static int[] calculate(Scanner console) throws NumberFormatException {
		try {
			out.print("Enter an integer to view it's Prime Factors: ");
			int n = NumberConstants.validateEntry(Integer.parseInt(console.next()));
			out.println();

			int[] result = Primeable.extractPrimeFactors(n);
			out.println("The Prime Factors of (" + n + ") are: " + Arrays.toString(result));
			return result;
		} catch (NumberFormatException e) {
			err.println(NumberConstants.INVALID_INPUT);
			throw e;
		} catch(Exception e) {
			err.println("Failed to calculate Prime Factors: " + e.getMessage());
			throw e;
		}
	}
}
