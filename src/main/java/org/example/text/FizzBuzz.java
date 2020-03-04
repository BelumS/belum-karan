package org.example.text;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class FizzBuzz {
    private FizzBuzz(){}

    public static List<String> fizzBuzzStream(int limit) {
        return IntStream.rangeClosed(1, limit)
                .limit(100L)
                .mapToObj(n -> (n % 5 == 0 || n % 3 == 0)
                        ? ((n % 3 == 0) ? "Fizz" : "") + ((n % 5 == 0) ? "Buzz" : "")
                        : Integer.toString(n))
                .collect(Collectors.toList());
    }
}
