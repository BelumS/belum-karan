package org.example.numbers;

import org.junit.jupiter.api.Test;

import static org.example.common.TestConstants.testScanner;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TwoCitiesTest {

    @Test
    public void testMiAssertionError() {
        String input = "AA" + System.lineSeparator()
                + "AK" + System.lineSeparator()
                + "-1" + System.lineSeparator();
        assertThrows(AssertionError.class, () -> TwoCities.displayCalculation(testScanner(input)));
    }

    @Test
    public void testMi() {
        String input = "AA" + System.lineSeparator()
                + "AK" + System.lineSeparator()
                + "mi" + System.lineSeparator();
        TwoCities.displayCalculation(testScanner(input));
    }

    @Test
    public void testKmNullPointerException() {
        assertThrows(NullPointerException.class, () -> TwoCities.displayCalculation(null));
    }

    @Test
    public void testKm() {
        String input = "FT" + System.lineSeparator()
                + "MNR" + System.lineSeparator()
                + "km" + System.lineSeparator();
        TwoCities.displayCalculation(testScanner(input));
    }
}
