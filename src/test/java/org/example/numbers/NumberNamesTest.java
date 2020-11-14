package org.example.numbers;

import org.example.common.TestConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberNamesTest {

    @Test
    void testDisplayNames0() {
        String input = "0" + System.lineSeparator();
        String actual = NumberNames.displayNames(TestConstants.testScanner(input));
        assertEquals("Zero", actual);
    }

    @Test
    void testDisplayNames1() {
        String input = "1" + System.lineSeparator();
        String actual = NumberNames.displayNames(TestConstants.testScanner(input));
        assertEquals("One", actual);
    }

    @Test
    void testDisplayNames19() {
        String input = "19" + System.lineSeparator();
        String actual = NumberNames.displayNames(TestConstants.testScanner(input));
        assertEquals("Nineteen", actual);
    }

    @Test
    void testDisplayNames28() {
        String input = "28" + System.lineSeparator();
        String actual = NumberNames.displayNames(TestConstants.testScanner(input));
        assertEquals("Twenty Eight", actual);
    }

    @Test
    void testDisplayNames100() {
        String input = "100" + System.lineSeparator();
        String actual = NumberNames.displayNames(TestConstants.testScanner(input));
        assertEquals("One Hundred", actual);
    }

    @Test
    void testDisplayNames1000() {
        String input = "1000" + System.lineSeparator();
        String actual = NumberNames.displayNames(TestConstants.testScanner(input));
        assertEquals("One Thousand", actual);
    }

    @Test
    void testDisplayNames10000() {
        String input = "10000" + System.lineSeparator();
        String actual = NumberNames.displayNames(TestConstants.testScanner(input));
        assertEquals("Ten Thousand", actual);
    }

    @Test
    void testDisplayNames100000() {
        String input = "100000" + System.lineSeparator();
        String actual = NumberNames.displayNames(TestConstants.testScanner(input));
        assertEquals("One Hundred Thousand", actual);
    }

    @Test
    void testDisplayNames1000000() {
        String input = "1000000" + System.lineSeparator();
        String actual = NumberNames.displayNames(TestConstants.testScanner(input));
        assertEquals("One Million", actual);
    }

    @Test
    void testDisplayNames10000000() {
        String input = "10000000" + System.lineSeparator();
        String actual = NumberNames.displayNames(TestConstants.testScanner(input));
        assertEquals("Ten Million", actual);
    }

    @Test
    void testDisplayNames100000000() {
        String input = "100000000" + System.lineSeparator();
        String actual = NumberNames.displayNames(TestConstants.testScanner(input));
        assertEquals("One Hundred Million", actual);
    }

    @Test
    void testDisplayNames1000000000() {
        String input = "1000000000" + System.lineSeparator();
        String actual = NumberNames.displayNames(TestConstants.testScanner(input));
        assertEquals("One Billion", actual);
    }

    @Test
    void testDisplayNamesMaxInteger() {
        String input = Integer.MAX_VALUE + System.lineSeparator();
        String actual = NumberNames.displayNames(TestConstants.testScanner(input));
        assertEquals("Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven", actual);
    }

    @Test
    void testDisplayNamesOverMaxIntegerThrowsException() {
        long overFlowInt = Integer.MAX_VALUE + 1L;
        String input = overFlowInt + System.lineSeparator();
        assertThrows(Exception.class, () -> NumberNames.displayNames(TestConstants.testScanner(input)));
    }

    @Test
    void testDisplayNamesThrowsException() {
        assertThrows(Exception.class, () -> NumberNames.displayNames(null));
    }
}
