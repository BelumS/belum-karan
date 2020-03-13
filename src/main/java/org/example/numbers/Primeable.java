package org.example.numbers;

import java.util.stream.IntStream;

/**
 * An interface that defines methods which determine if a number is prime.
 */
public interface Primeable {

	/**
	 * Determines if a number is a prime number.
	 * @param n the non-zero, and non-negative number to be checked for prime.
	 * @return true if the number is prime.
	 */
	static boolean isPrime(int n) {
			if (n != 2 && n % 2 == 0)
				return false;

			return n < 4 || IntStream.range(3, n)
				.filter(i -> i % 2 == 1 && i * i <= n)
				.noneMatch(i -> n % i == 0);
	}

	/**
	 * Displays a number's prime eligibility.
	 * @param n the non-negative, non-zero number to be checked if it's prime eligible.
	 */
	static void checkPrime(int n) {
		IntStream.rangeClosed(1, n)
				.filter(i -> i % 2 == 1)
				.forEach(i -> System.out.println(
					new StringBuilder()
					.append(i)
					.append(" is prime?: ")
					.append(isPrime(i))
					.toString()));
	}

	/**
	 * Extracts the prime factors of a number.
	 * @param n the non-zero, non-negative number whose prime factorization will be determined
	 * @return an array of prime numbers
	 */
	static int[] extractPrimeFactors(int n) {
		return IntStream.rangeClosed(1, n)
				.filter(i -> isPrime(i) && (n % i == 0 || n == 1))
				.toArray();
	}
}
