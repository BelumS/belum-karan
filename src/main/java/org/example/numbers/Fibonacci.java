package org.example.numbers;

import java.util.Scanner;
import java.util.stream.LongStream;

public class Fibonacci {
	private Fibonacci() {
	}

	public static void sequence(Scanner console) {
		try {
			System.out.print("Enter an integer to view it's Fibonacci Sequence: ");
			long choice = Long.parseLong(console.next());
			System.out.println();

			LongStream.rangeClosed(0, choice).forEach(i -> System.out
					.println(new StringBuilder("f(").append(i).append(") = ").append(fibonacci(i)).toString()));
		} catch (Exception e) {
			System.out.println("Failed to generate Fibonacci Sequence: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static long fibonacci(long n) {
		if (n < 2L)
			return n;
		return fibonacci(n - 1L) + fibonacci(n - 2L);
	}
}
