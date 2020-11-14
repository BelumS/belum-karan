package org.example.numbers;

import org.example.common.TestConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaxCalculatorTest {

    @Test
    void testMNSalesTax() {
        String input = "100" + System.lineSeparator()
                + "MN" + System.lineSeparator();
        double result = TaxCalculator.calculateSalesTax(TestConstants.testScanner(input));
        Assertions.assertEquals(107.46, result);
    }

    @Test
    void testNHSalesTax() {
        String input = "100" + System.lineSeparator()
                + "NH" + System.lineSeparator();
        double result = TaxCalculator.calculateSalesTax(TestConstants.testScanner(input));
        Assertions.assertEquals(100, result);
    }

    @Test
    void testDCSalesTax() {
        String input = "100" + System.lineSeparator()
                + "DC" + System.lineSeparator();
        double result = TaxCalculator.calculateSalesTax(TestConstants.testScanner(input));
        Assertions.assertEquals(106, result);
    }

    @Test
    void testTZSalesTax() {
        String input = "100" + System.lineSeparator()
                + "TZ" + System.lineSeparator();
        double result = TaxCalculator.calculateSalesTax(TestConstants.testScanner(input));
        Assertions.assertEquals(118, result);
    }

    @Test
    void testLIBSalesTax() {
        String input = "100" + System.lineSeparator()
                + "LIB" + System.lineSeparator();
        double result = TaxCalculator.calculateSalesTax(TestConstants.testScanner(input));
        Assertions.assertEquals(100, result);
    }

    @Test
    void testSLLSalesTax() {
        String input = "100" + System.lineSeparator()
                + "SLL" + System.lineSeparator();
        double result = TaxCalculator.calculateSalesTax(TestConstants.testScanner(input));
        Assertions.assertEquals(115, result);
    }
}
