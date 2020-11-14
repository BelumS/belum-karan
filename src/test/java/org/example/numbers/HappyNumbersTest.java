package org.example.numbers;

import org.example.common.TestConstants;
import org.example.common.ValueConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HappyNumbersTest {

    @Test
    void testDisplayNumbers() {
        String input = ValueConstants.VALUE_Y + System.lineSeparator();
        HappyNumbers.displayNumbers(TestConstants.testScanner(input));
        assertNotNull(input);
    }

    @Test
    void testDontDisplayNumbers() {
        String input = ValueConstants.VALUE_N + System.lineSeparator();
        HappyNumbers.displayNumbers(TestConstants.testScanner(input));
        assertNotNull(input);
    }

    @Test
    @DisplayName("Test displayNumbers() throws InputMismatchException")
    void testMismatchException() {
        String input = 1 + System.lineSeparator();
        assertThrows(InputMismatchException.class, () -> HappyNumbers.displayNumbers(TestConstants.testScanner(input)));
    }

    @Test
    @DisplayName("Test displayNumbers() throws NullPointerException")
    void testException() {
        assertThrows(NullPointerException.class, () -> HappyNumbers.displayNumbers(null));
    }
}
