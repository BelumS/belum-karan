package org.example.numbers;

import org.example.common.TestConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FastExponentiationTest {

    @Test
    void testResult() {
        String input = "1" + System.lineSeparator()
                + "2" + System.lineSeparator();
        double actual = FastExponentiation.displayResult(TestConstants.testScanner(input));
        assertEquals(1, actual);
    }

    @Test
    void testResultWhereBEquals0() {
        String input = "100" + System.lineSeparator()
                + "0" + System.lineSeparator();
        double actual = FastExponentiation.displayResult(TestConstants.testScanner(input));
        assertEquals(1, actual);
    }

    @Test
    void testResultWhereBIsOdd() {
        String input = "10" + System.lineSeparator()
                + "3" + System.lineSeparator();
        double actual = FastExponentiation.displayResult(TestConstants.testScanner(input));
        assertEquals(1000, actual);
    }

    @Test
    void testResultThrowsException() {
        String input = "a" + System.lineSeparator();
        assertThrows(Exception.class, () -> FastExponentiation.displayResult(TestConstants.testScanner(input)));
    }

}
