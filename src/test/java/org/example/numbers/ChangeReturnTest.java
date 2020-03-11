package org.example.numbers;

import org.example.commons.TestConstants;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ChangeReturnTest {

    @Test
    void verifyChangeReturn() {
        double cost = 200.00;
        double payment = 399.79;

        String input = cost + System.lineSeparator()
                + payment + System.lineSeparator();

        List<Integer> expectedValues = Arrays.asList(1, 1, 2, 0, 1, 4, 3, 0, 0, 4);
        Map<String, Integer> actual = ChangeReturn.print(TestConstants.testScanner(input));
        assertArrayEquals(expectedValues.toArray(), actual.values().toArray());
    }

    @Test
    void insufficientPayment_throwsArithmeticException() {
        double cost = 200.00;
        double payment = 199.79;

        String input = cost + System.lineSeparator()
                + payment + System.lineSeparator();

        assertThrows(ArithmeticException.class, () -> ChangeReturn.print(TestConstants.testScanner(input)));
    }

    @Test
    void invalidInput_throwsNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> ChangeReturn.print(TestConstants.testScanner("FAIL")));
    }

    @Test
    void lowEdgeCaseInput_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> ChangeReturn.print(TestConstants.testScanner("-1.0")));
    }

    @Test
    void highEdgeCaseInput_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> ChangeReturn.print(TestConstants.testScanner(Double.toString(Double.MAX_VALUE))));
    }
}
