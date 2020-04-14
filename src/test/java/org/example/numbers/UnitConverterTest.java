package org.example.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.commons.TestConstants.testScanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitConverterTest {

    @BeforeEach
    void setup() {
    }

    @Test
    void testMsToMs() {
        String input = "T" + System.lineSeparator()
                + "ms" + System.lineSeparator()
                + "15" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 15;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testSecToMs() {
        String input = "T" + System.lineSeparator()
                + "sec" + System.lineSeparator()
                + "10" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 10000;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testMinToMs() {
        String input = "T" + System.lineSeparator()
                + "min" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 60000;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testHrToMs() {
        String input = "T" + System.lineSeparator()
                + "hr" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 3600000;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testDayToMs() {
        String input = "T" + System.lineSeparator()
                + "d" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 86400000;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testWeekToMs() {
        String input = "T" + System.lineSeparator()
                + "w" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 604800000;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testMonthToMs() {
        String input = "T" + System.lineSeparator()
                + "m" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 2629800000.0;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testYearToMs() {
        String input = "T" + System.lineSeparator()
                + "yr" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 31557600000.0;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }
}
