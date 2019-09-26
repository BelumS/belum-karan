package org.example.numbers;

import java.util.stream.IntStream;

public interface Primeable {
	static boolean isPrime(int n) {
		try {
			if (n <= 0)
				throw new ArithmeticException("Not a valid candidate for prime number(s).");
			if (n > Integer.MAX_VALUE)
				throw new IllegalArgumentException("Error, that number is too large for computation!");
			if (n != 2 && n % 2 == 0)
				return false;

			return (n > 0 && n < 4) || IntStream.range(3, n).filter(i -> (i > 0) && (i % 2 == 1) && (i * i <= n))
					.noneMatch(i -> n % i == 0);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	static void checkPrime(int n) {
		IntStream.rangeClosed(1, n).filter(i -> i % 2 == 1).forEach(i -> System.out
				.println(new StringBuilder().append(i).append(" is prime?: ").append(isPrime(i)).toString()));
	}

	static int[] extractPrimeFactors(int n) {
		return IntStream.rangeClosed(1, n).filter(i -> isPrime(i) && (n % i == 0 || n == 1)).toArray();
	}
}
