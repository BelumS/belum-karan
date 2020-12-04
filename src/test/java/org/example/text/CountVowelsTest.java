package org.example.text;

import org.example.common.TestConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountVowelsTest {

    @Test
    void testLowVowels() {
        String input = "Test Word" + System.lineSeparator();
        int expected = 2;
        int actual = CountVowels.displayVowels(TestConstants.testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testHighVowels() {
        String input = "Amanirenas" + System.lineSeparator();
        int expected = 5;
        int actual = CountVowels.displayVowels(TestConstants.testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testDisplayVowelsThrowsAssertionError() {
        String input = "1 " + System.lineSeparator();
        assertThrows(Error.class, () -> CountVowels.displayVowels(TestConstants.testScanner(input)));
    }
}
