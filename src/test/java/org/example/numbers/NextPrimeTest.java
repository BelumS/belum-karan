package org.example.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.example.common.TestConstants.testScanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NextPrimeTest {

    @Test
    void testNextPrime() {
        String input = "10" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "2" + System.lineSeparator()
                + "3" + System.lineSeparator()
                + "q" + System.lineSeparator();
        List<Integer> expected = Arrays.asList(1, 3, 5);
        List<Integer> actual = NextPrime.infinitePrimes(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void invalidInputThrowsNumberFormatException() {
        String input = "a" + System.lineSeparator();
        assertThrows(NumberFormatException.class, () -> NextPrime.infinitePrimes(testScanner(input)));
    }

    @Test
    void invalidInputThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> NextPrime.infinitePrimes(null));
    }
}
