package org.example.numbers;

import org.junit.jupiter.api.Test;

import static org.example.commons.TestConstants.testScanner;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrimeFactorsTest {

    @Test
    void validatePrimeNumbers() {
        String input = "100" + System.lineSeparator();
        int[] expected = new int[] {1, 2, 5};
        int[] actual = PrimeFactors.calculate(testScanner(input));
        assertArrayEquals(expected, actual);
    }

    @Test
    void invalidInputThrowsNumberFormatException() {
        String input = "a" + System.lineSeparator();
        assertThrows(NumberFormatException.class, () -> PrimeFactors.calculate(testScanner(input)));
    }

    @Test
    void invalidInputThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> PrimeFactors.calculate(null));
    }

    @Test
    void lowerEdgeCaseInputThrowsNumberFormatException() {
        String input = "-1" + System.lineSeparator();
        assertThrows(IllegalArgumentException.class, () -> PrimeFactors.calculate(testScanner(input)));
    }

    @Test
    void higherEdgeCaseInputThrowsNumberFormatException() {
        String input = Integer.MAX_VALUE + System.lineSeparator();
        assertThrows(IllegalArgumentException.class, () -> PrimeFactors.calculate(testScanner(input)));
    }
}
