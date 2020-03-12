package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

public class PrimeFactors {
	private PrimeFactors(){}

	public static int[] calculate(Scanner console) {
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
