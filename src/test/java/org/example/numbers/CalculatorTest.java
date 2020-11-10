package org.example.numbers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.example.common.TestConstants.testScanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    @Disabled
    void verifyQuit() {
        String input = "q" + System.lineSeparator();
        assertEquals(0, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyAdd() {
        String input ="n" + System.lineSeparator() + "10 + 5" + System.lineSeparator();
        assertEquals(10 + 5, Calculator.print(testScanner(input)));
    }

    @Test
    void verifySubtract() {
        String input ="n" + System.lineSeparator() + "10 - 5" + System.lineSeparator();
        assertEquals(5, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyMultiplication() {
        String input ="n" + System.lineSeparator() + "10 * 5" + System.lineSeparator();
        assertEquals(50, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyDivision() {
        String input ="n" + System.lineSeparator() + "10 / 5" + System.lineSeparator();
        assertEquals(2, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyRemainder() {
        String input = "n" + System.lineSeparator() + "10 % 3" + System.lineSeparator();
        assertEquals(1, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyFactorial() {
        String input = "s" + System.lineSeparator() + "! 5" + System.lineSeparator();
        assertEquals(120, Calculator.print(testScanner(input)));
    }

    @Test
    void verifySquareRoot() {
        String input = "s" + System.lineSeparator() + "sqrt 100" + System.lineSeparator();
        assertEquals(10, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyExponent() {
        String input = "n" + System.lineSeparator() + "5 ^ 2" + System.lineSeparator();
        assertEquals(25, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyPi() {
        String input = "s" + System.lineSeparator() + "pi 0" + System.lineSeparator();
        assertEquals(0, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyE() {
        String input = "s" + System.lineSeparator() + "e 1" + System.lineSeparator();
        assertEquals(2.72, Calculator.print(testScanner(input)));
    }

    @Test
    void verifySin() {
        String input = "s" + System.lineSeparator() + "sin 0" + System.lineSeparator();
        assertEquals(0, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyCos() {
        String input = "s" + System.lineSeparator() + "cos 30" + System.lineSeparator();
        assertEquals(0.15425144988758405, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyTan() {
        String input = "s" + System.lineSeparator() + "tan 45" + System.lineSeparator();
        assertEquals(1.6197751905438615, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyLog() {
        String input = "s" + System.lineSeparator() + "log 10" + System.lineSeparator();
        assertEquals(1, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyNaturalLog() {
        String input = "s" + System.lineSeparator() + "ln 10" + System.lineSeparator();
        assertEquals(2.302585092994046, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyInverseSquareRoot() {
        String input = "i" + System.lineSeparator() + "isqrt 6" + System.lineSeparator();
        assertEquals(Math.pow(6, 2), Calculator.print(testScanner(input)));
    }

    @Test
    void verifyInverseSin() {
        String input = "i" + System.lineSeparator() + "isin 1" + System.lineSeparator();
        assertEquals(1.1883951057781212, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyInverseCosine() {
        String input = "i" + System.lineSeparator() + "icos 1" + System.lineSeparator();
        assertEquals(1.8508157176809255, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyInverseTangent() {
        String input = "i" + System.lineSeparator() + "itan 1" + System.lineSeparator();
        assertEquals(0.6420926159343306, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyInverseLog() {
        String input = "i" + System.lineSeparator() + "ilog 3" + System.lineSeparator();
        assertEquals(Math.pow(10, 3), Calculator.print(testScanner(input)));
    }

    @Test
    void verifyInverseNaturalLog() {
        String input = "i" + System.lineSeparator() + "iln 10" + System.lineSeparator();
        assertEquals(Math.pow(Math.E, 10), Calculator.print(testScanner(input)));
    }

    @Test
    void verifyInvalidScientificInputThrowsIllegalArgumentException() {
        String input = "s" + System.lineSeparator() + "a a" + System.lineSeparator();
        assertThrows(IllegalArgumentException.class, () -> Calculator.print(testScanner(input)));
    }

    @Test
    void verifyInvalidInverseInputThrowsIllegalArgumentException() {
        String input = "i" + System.lineSeparator() + "a a" + System.lineSeparator();
        assertThrows(IllegalArgumentException.class, () -> Calculator.print(testScanner(input)));
    }

    @Test
    void verifyInvalidInputThrowsIllegalArgumentException() {
        String input = "n" + System.lineSeparator()
                + "a + a" + System.lineSeparator();
        assertThrows(IllegalArgumentException.class, () -> Calculator.print(testScanner(input)));
    }

    @Test
    void verifyInvalidOperatorThrowsIllegalArgumentException() {
        String input = "n" + System.lineSeparator()
                + "1 v 1" + System.lineSeparator();
        assertThrows(IllegalArgumentException.class, () -> Calculator.print(testScanner(input)));
    }

    @Test
    void verifyDivideByZeroThrowsAssertionError() {
        String input = "n" + System.lineSeparator()
                + "10 / 0" + System.lineSeparator();
        assertThrows(AssertionError.class, () -> Calculator.print(testScanner(input)));
    }

    @Test
    void verifyNullThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> Calculator.print(null));
    }
}
