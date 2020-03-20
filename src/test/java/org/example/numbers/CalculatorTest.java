package org.example.numbers;

import org.junit.jupiter.api.Test;

import static org.example.commons.TestConstants.testScanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    void verifyAdd(){
        String input = "10 + 5" + System.lineSeparator();
        assertEquals(10 + 5, Calculator.print(testScanner(input)));
    }

    @Test
    void verifySubtract(){
        String input = "10 - 5" + System.lineSeparator();
        assertEquals(5, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyMultiplication(){
        String input = "10 * 5" + System.lineSeparator();
        assertEquals(50, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyDivision(){
        String input = "10 / 5" + System.lineSeparator();
        assertEquals(2, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyRemainder(){
        String input = "10 % 3" + System.lineSeparator();
        assertEquals(1, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyExponent(){
        String input = "10 ^ 5" + System.lineSeparator();
        assertEquals(100000, Calculator.print(testScanner(input)));
    }

    @Test
    void verifyInvalidInputThrowsIllegalArgumentException(){
        String input = "a + a" + System.lineSeparator();
        assertThrows(IllegalArgumentException.class, () -> Calculator.print(testScanner(input)));
    }

    @Test
    void verifyInvalidOperatorThrowsIllegalArgumentException(){
        String input = "1 v 1" + System.lineSeparator();
        assertThrows(IllegalArgumentException.class, () -> Calculator.print(testScanner(input)));
    }

    @Test
    void verifyDivideByZeroThrowsAssertionError(){
        String input = "10 / 0" + System.lineSeparator();
        assertThrows(AssertionError.class, () -> Calculator.print(testScanner(input)));
    }

    @Test
    void verifyNullThrowsNullPointerException(){
        assertThrows(NullPointerException.class, () -> Calculator.print(null));
    }
}
