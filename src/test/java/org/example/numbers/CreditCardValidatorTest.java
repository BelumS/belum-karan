package org.example.numbers;

import org.junit.jupiter.api.Test;

import static org.example.common.TestConstants.testScanner;
import static org.junit.jupiter.api.Assertions.*;

class CreditCardValidatorTest {

    @Test
    void testPrimaryAccountNumberIsValid() {
        String input = "4952322246765399" + System.lineSeparator();
        assertTrue(CreditCardValidator.displayChecksum(testScanner(input)));
    }

    @Test
    void testPrimaryAccountNumberIsNotRecognized() {
        String input = "1234567890123455" + System.lineSeparator();
        assertFalse(CreditCardValidator.displayChecksum(testScanner(input)));
    }

    @Test
    void testPrimaryAccountNumberIsInvalid() {
        String input = "6666666666666666" + System.lineSeparator();
        assertFalse(CreditCardValidator.displayChecksum(testScanner(input)));
    }

    @Test
    void testDisplayCheckSumThrowsException() {
        assertThrows(NullPointerException.class, () -> CreditCardValidator.displayChecksum(null));
    }
}
