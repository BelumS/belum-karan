package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.*;
import static org.example.common.NumberConstants.validateEntry;

public class Fibonacci {
	private Fibonacci() {
	}

	/**
	 * Displays the fibonacci sequence.
	 * @param console the keyboard input shared from the Numbers menu.
	 * @return the map of the fibonacci sequence
	 * @throws IllegalArgumentException if an invalid number is used
	 * @throws InputMismatchException If an invalid input is used
	 */
	public static Map<String, Long> sequence(Scanner console) {
		try {
			out.print("Enter an integer to view it's Fibonacci Sequence: ");
			long choice = validateEntry(Long.parseLong(console.next()));
			out.println();
			Map<String, Long> sequence = new LinkedHashMap<>();

			for(long i = 0; i < choice; i++) {
				sequence.put("f("+i+")", fibonacci(i));
			}
			out.println(sequence);
			return sequence;
		} catch (InputMismatchException | NumberFormatException e) {
			err.println(NumberConstants.INVALID_INPUT);
			throw e;
		} catch (Exception e) {
			err.println("An error occurred while generating the sequence: " + e.getMessage());
			throw e;
		}
	}

	private static long fibonacci(long n) {
		if (n < 2L)
			return n;
		return fibonacci(n - 1L) + fibonacci(n - 2L);
	}
}
