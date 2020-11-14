package org.example.numbers;

import org.example.common.TestConstants;
import org.example.constants.ValueConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoinFlipTest {

    @Test
    void test1Flip() {
        String input = ValueConstants.VALUE_Y + System.lineSeparator()
                + 1 + System.lineSeparator();
        int expected = 1;
        int actual = CoinFlip.displayResult(TestConstants.testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void test5Flips() {
        String input = ValueConstants.VALUE_Y + System.lineSeparator()
                + 5 + System.lineSeparator();
        int expected = 5;
        int actual = CoinFlip.displayResult(TestConstants.testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void test100Flips() {
        String input = ValueConstants.VALUE_Y + System.lineSeparator()
                + 100 + System.lineSeparator();
        int expected = 100;
        int actual = CoinFlip.displayResult(TestConstants.testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testNoFlip() {
        String input = ValueConstants.VALUE_N + System.lineSeparator();
        int expected = -1;
        int actual = CoinFlip.displayResult(TestConstants.testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testDisplayResultThrowsException() {
        assertThrows(Exception.class, () -> CoinFlip.displayResult(null));
    }

}
