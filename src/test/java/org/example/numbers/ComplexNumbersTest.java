package org.example.numbers;

import org.example.common.TestConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ComplexNumbersTest {

    @Test
    void testSum() {
        var input = "5.5" + System.lineSeparator()
                + "1.2" + System.lineSeparator()
                + "6.0" + System.lineSeparator()
                + "9.0" + System.lineSeparator()
                + "+" + System.lineSeparator();
        var expected = ComplexNumbers.displayEquation(TestConstants.testScanner(input));
        assertNotNull(expected);
    }

    @Test
    void testDifference() {
        var input = "5.5" + System.lineSeparator()
                + "1.2" + System.lineSeparator()
                + "6.0" + System.lineSeparator()
                + "9.0" + System.lineSeparator()
                + "-" + System.lineSeparator();
        var expected = ComplexNumbers.displayEquation(TestConstants.testScanner(input));
        assertNotNull(expected);
    }

    @Test
    void testMultiply() {
        var input = "5.5" + System.lineSeparator()
                + "1.2" + System.lineSeparator()
                + "6.0" + System.lineSeparator()
                + "9.0" + System.lineSeparator()
                + "*" + System.lineSeparator();
        var expected = ComplexNumbers.displayEquation(TestConstants.testScanner(input));
        assertNotNull(expected);
    }

    @Test
    void testDivision() {
        var input = "5.5" + System.lineSeparator()
                + "1.2" + System.lineSeparator()
                + "6.0" + System.lineSeparator()
                + "9.0" + System.lineSeparator()
                + "/" + System.lineSeparator();
        var expected = ComplexNumbers.displayEquation(TestConstants.testScanner(input));
        assertNotNull(expected);
    }

    @Test
    void testComplexNumberIllegalOperation() {
        var input = "5.5" + System.lineSeparator()
                + "1.2" + System.lineSeparator()
                + "6.0" + System.lineSeparator()
                + "9.0" + System.lineSeparator()
                + "x" + System.lineSeparator();
        assertThrows(IllegalArgumentException.class, () -> ComplexNumbers.displayEquation(TestConstants.testScanner(input)));
    }
}
