package org.example.numbers;

import org.junit.jupiter.api.Test;

import static org.example.commons.TestConstants.testScanner;

public class TwoCitiesTest {

    @Test
    public void test() {
        String input = "A" + System.lineSeparator()
                + "B" + System.lineSeparator()
                + "mi" + System.lineSeparator();
        TwoCities.displayCalculation(testScanner(input));
    }
}
