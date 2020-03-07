package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.LongStream;

import static java.lang.System.*;

public class Fibonacci {
	private Fibonacci() {
	}

	public static void sequence(Scanner console) {
		try {
			out.print("Enter an integer to view it's Fibonacci Sequence: ");
			long choice = Long.parseLong(console.next());
			out.println();

			LongStream.rangeClosed(0, choice).forEach(i ->
					out.println(new StringBuilder("f(").append(i).append(") = ").append(fibonacci(i)).toString()));
		} catch (InputMismatchException | NumberFormatException e) {
			err.println(NumberConstants.INVALID_INPUT);
			throw e;
		} catch (Exception e) {
			err.println("Failed to generate Fibonacci Sequence: " + e.getMessage());
			throw e;
		}
	}

	private static long fibonacci(long n) {
		if (n < 2L)
			return n;
		return fibonacci(n - 1L) + fibonacci(n - 2L);
	}
}
