package org.example.text;

import org.example.common.TestConstants;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReverseStringTest {

    @Test
    void testReverse() {
        String input = "Reverse String" + System.lineSeparator();
        String expected = "esreveR gnirtS";
        String actual = ReverseString.displayReversal(TestConstants.testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testReverseThrowsInputMismatchException() {
        assertThrows(NullPointerException.class, () -> ReverseString.displayReversal(null));
    }
}
