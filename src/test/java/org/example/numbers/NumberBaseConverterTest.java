package org.example.numbers;


import org.junit.jupiter.api.Test;

import static org.example.common.TestConstants.testScanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberBaseConverterTest {

    @Test
    void validateDecimalToBinary() {
        String input = "decimal" + System.lineSeparator()
                + "15" + System.lineSeparator();
        String expected = "1111";
        String actual = NumberBaseConverter.print(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void validateBinaryToDecimal() {
        String input = "binary" + System.lineSeparator()
                + "11111111" + System.lineSeparator();

        String expected = "255";
        String actual = NumberBaseConverter.print(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void invalidEntryThrowsInputMismatchException() {
        assertThrows(IllegalArgumentException.class, () -> NumberBaseConverter.print(testScanner("a")));
    }

    @Test
    void nullEntryThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> NumberBaseConverter.print(null));
    }

    @Test
    void lowEdgeCaseThrowsIllegalArgumentException() {
        String input = "decimal" + System.lineSeparator()
                + "-1" + System.lineSeparator();
        assertThrows(IllegalArgumentException.class, () -> NumberBaseConverter.print(testScanner(input)));
    }

    @Test
    void highEdgeCaseThrowsIllegalArgumentException() {
        String input = "binary" + System.lineSeparator()
                + "-1" + System.lineSeparator();
        assertThrows(IllegalArgumentException.class, () -> NumberBaseConverter.print(testScanner(input)));
    }
}
