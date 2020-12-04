package org.example.text;

import org.example.common.TestConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountWordsTest {

    @Test
    void testWord() {
        String input = "ABC" + System.lineSeparator();
        int expected = 1;
        int actual = CountWords.displayCount(TestConstants.testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testWords() {
        String input = "A sentence with five words." + System.lineSeparator();
        int expected = 5;
        int actual = CountWords.displayCount(TestConstants.testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testThrowsException() {
        assertThrows(Exception.class, () -> CountWords.displayCount(null));
    }
}
