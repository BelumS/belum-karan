package org.example.numbers;

import org.junit.jupiter.api.Test;

import static org.example.commons.TestConstants.testScanner;
import static org.junit.jupiter.api.Assertions.*;

public class MortgageCalculatorTest {
    private static final int HOME_PRICE = 200000;
    private static final int DOWN_PAYMENT = 50000;
    private static final double PROPERTY_TAX = 0.0064;
    private static final double INSURANCE_PAYMENT = 202.30;

    @Test
    void verifyMortgageCalculator5Years() {
        String input = HOME_PRICE + System.lineSeparator()
                + DOWN_PAYMENT + System.lineSeparator()
                + PROPERTY_TAX + System.lineSeparator()
                + INSURANCE_PAYMENT + System.lineSeparator()
                + "5" + System.lineSeparator()
                + "D" + System.lineSeparator()
                + System.lineSeparator()
                + "500" + System.lineSeparator();
        double expected = 500;
        double actual = MortgageCalculator.printCalculation(testScanner(input));
        assertTrue(expected < actual);
    }

    @Test
    void verifyMortgageCalculator10Years() {
        String input = HOME_PRICE + System.lineSeparator()
                + DOWN_PAYMENT + System.lineSeparator()
                + PROPERTY_TAX + System.lineSeparator()
                + INSURANCE_PAYMENT + System.lineSeparator()
                + "10" + System.lineSeparator()
                + "W" + System.lineSeparator()
                + System.lineSeparator()
                + "0" + System.lineSeparator();

        double expected = 1313.33;
        double actual = MortgageCalculator.printCalculation(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void verifyMortgageCalculator15Years() {
        String input = HOME_PRICE + System.lineSeparator()
                + DOWN_PAYMENT + System.lineSeparator()
                + PROPERTY_TAX + System.lineSeparator()
                + INSURANCE_PAYMENT + System.lineSeparator()
                + "15" + System.lineSeparator()
                + "M" + System.lineSeparator()
                + System.lineSeparator()
                + "1000" + System.lineSeparator();

        double expected = 873.83;
        double actual = MortgageCalculator.printCalculation(testScanner(input));
        assertTrue(expected < actual);
    }

    @Test
    void verifyMortgageCalculator30Years() {
        String input = HOME_PRICE + System.lineSeparator()
                + DOWN_PAYMENT + System.lineSeparator()
                + PROPERTY_TAX + System.lineSeparator()
                + INSURANCE_PAYMENT + System.lineSeparator()
                + "30" + System.lineSeparator()
                + "C" + System.lineSeparator()
                + System.lineSeparator()
                + "3000" + System.lineSeparator();

        double expected = 439.89;
        double actual = MortgageCalculator.printCalculation(testScanner(input));
        assertTrue(expected < actual);
    }

    @Test
    void verifyInvalidInputThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> MortgageCalculator.printCalculation(testScanner("a")));
    }

    @Test
    void verifyInvalidInterestTermThrowsIllegalArgumentException() {
        String input = HOME_PRICE + System.lineSeparator()
                + DOWN_PAYMENT + System.lineSeparator()
                + PROPERTY_TAX + System.lineSeparator()
                + INSURANCE_PAYMENT + System.lineSeparator()
                + "5" + System.lineSeparator()
                + "ABC" + System.lineSeparator();
        assertThrows(IllegalArgumentException.class, () -> MortgageCalculator.printCalculation(testScanner(input)));
    }

    @Test
    void verifyNullThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> MortgageCalculator.printCalculation(null));
    }
}
