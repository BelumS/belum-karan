package org.example.numbers;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.example.commons.TestConstants.testScanner;
import static org.example.numbers.Fibonacci.sequence;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {

    @Test
    void validateBaseCases() {
        Map<String, Long> actual = sequence(testScanner("10"));
        assertFalse(actual.isEmpty());
    }

    @Test
    void validateHighEdgeCase() {
        assertThrows(IllegalArgumentException.class, () -> sequence(testScanner(Long.toString(Long.MAX_VALUE))));
    }

    @Test
    void validateLowEdgeCase() {
        assertThrows(IllegalArgumentException.class, () -> sequence(testScanner(Long.toString(Long.MIN_VALUE))));
    }

    @Test
    void testNullPointerException() {
        assertThrows(NullPointerException.class, () -> sequence(null));
    }
}
