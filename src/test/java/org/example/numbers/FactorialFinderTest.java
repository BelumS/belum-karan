package org.example.numbers;

import org.example.common.TestConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialFinderTest {

    @Test
    void testFactorials() {
        var actual = FactorialFinder.displayFactorials(TestConstants.testScanner("5"));
        assertEquals("120", actual);
    }

    @Test
    void testFactorialsThrowsNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> FactorialFinder.displayFactorials(TestConstants.testScanner("a")));
    }
}
