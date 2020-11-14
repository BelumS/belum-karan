package org.example.text;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Represents the FizzBuzz algorithm
 */
public final class FizzBuzz {
    private FizzBuzz(){}

    /**
     * Generates the FizzBuzz algorithm
     * @param limit the integer upper bound for the algorithm
     * @return the list of values for the algorithm
     */
    public static List<String> fizzBuzzStream(int limit) {
        return IntStream.rangeClosed(1, limit)
                .limit(100L)
                .mapToObj(n -> (n % 5 == 0 || n % 3 == 0)
                        ? ((n % 3 == 0) ? "Fizz" : "") + ((n % 5 == 0) ? "Buzz" : "")
                        : Integer.toString(n))
                .collect(Collectors.toList());
    }
}
