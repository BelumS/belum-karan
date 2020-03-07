package org.example.numbers;

import java.util.stream.IntStream;

import org.example.common.NumberConstants;

import static java.lang.System.err;

public interface Primeable {
	static boolean isPrime(int n) {
		try {
			if (n <= 0)
				throw new ArithmeticException(NumberConstants.INVALID_PRIME);
			if (n >= Integer.MAX_VALUE)
				throw new IllegalArgumentException(NumberConstants.INTEGER_OVERFLOW);
			if (n != 2 && n % 2 == 0)
				return false;

			return n < 4 || IntStream.range(3, n).filter(i -> i % 2 == 1 && i * i <= n)
					.noneMatch(i -> n % i == 0);
		} catch (Exception e) {
			err.println("An error occurred while checking for prime numbers!");
			throw e;
		}
	}

	static void checkPrime(int n) {
		IntStream.rangeClosed(1, n)
				.filter(i -> i % 2 == 1)
				.forEach(i ->
						System.out.println(new StringBuilder().append(i).append(" is prime?: ").append(isPrime(i)).toString()));
	}

	static int[] extractPrimeFactors(int n) {
		return IntStream.rangeClosed(1, n)
				.filter(i -> isPrime(i) && (n % i == 0 || n == 1))
				.toArray();
	}
}
