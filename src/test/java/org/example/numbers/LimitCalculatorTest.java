package org.example.numbers;

import org.example.common.TestConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LimitCalculatorTest {

    @Test
    void testAddition() {
        String input = "5" + System.lineSeparator()
                + "Y" + System.lineSeparator()
                + "2" + System.lineSeparator()
                + "+" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "4" + System.lineSeparator();
        double actual = LimitCalculator.displayCalculation(TestConstants.testScanner(input));
        assertEquals(401, actual);
    }

    @Test
    void testSubtraction() {
        String input = "5" + System.lineSeparator()
                + "Y" + System.lineSeparator()
                + "2" + System.lineSeparator()
                + "-" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "4" + System.lineSeparator();
        double actual = LimitCalculator.displayCalculation(TestConstants.testScanner(input));
        assertEquals(399, actual);
    }

    @Test
    void testMultiplication() {
        String input = "5" + System.lineSeparator()
                + "Y" + System.lineSeparator()
                + "2" + System.lineSeparator()
                + "*" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "4" + System.lineSeparator();
        double actual = LimitCalculator.displayCalculation(TestConstants.testScanner(input));
        assertEquals(400, actual);
    }

    @Test
    void testDivision() {
        String input = "5" + System.lineSeparator()
                + "Y" + System.lineSeparator()
                + "2" + System.lineSeparator()
                + "/" + System.lineSeparator()
                + "4" + System.lineSeparator()
                + "4" + System.lineSeparator();
        double actual = LimitCalculator.displayCalculation(TestConstants.testScanner(input));
        assertEquals(100, actual);
    }

    @Test
    void testCalculationThrowsException() {
        String input = "0" + System.lineSeparator()
                + "Y" + System.lineSeparator()
                + "0" + System.lineSeparator()
                + "0" + System.lineSeparator()
                + "0" + System.lineSeparator()
                + "0" + System.lineSeparator();
        assertThrows(Exception.class, () -> LimitCalculator.displayCalculation(TestConstants.testScanner(input)));
    }
}
