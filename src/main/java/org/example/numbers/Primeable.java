package org.example.numbers;

import java.util.stream.IntStream;

public interface Primeable {

	static boolean isPrime(int n) throws IllegalArgumentException {
			if (n != 2 && n % 2 == 0)
				return false;

			return n < 4 || IntStream.range(3, n)
				.filter(i -> i % 2 == 1 && i * i <= n)
				.noneMatch(i -> n % i == 0);
	}

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

	static int[] extractPrimeFactors(int n) {
		return IntStream.rangeClosed(1, n)
				.filter(i -> isPrime(i) && (n % i == 0 || n == 1))
				.toArray();
	}
}
