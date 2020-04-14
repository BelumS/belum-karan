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
    void testMillisecondsToItself() {
        String input = "T" + System.lineSeparator()
                + "ms" + System.lineSeparator()
                + "15" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 15;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testMillisecondsToSeconds() {
        String input = "T" + System.lineSeparator()
                + "ms" + System.lineSeparator()
                + "1000" + System.lineSeparator()
                + "sec" + System.lineSeparator();
        double expected = 1;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testMillisecondsToMinutes() {
        String input = "T" + System.lineSeparator()
                + "ms" + System.lineSeparator()
                + "60000" + System.lineSeparator()
                + "min" + System.lineSeparator();
        double expected = 1;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testMillisecondsToHours() {
        String input = "T" + System.lineSeparator()
                + "ms" + System.lineSeparator()
                + "3600000" + System.lineSeparator()
                + "hr" + System.lineSeparator();
        double expected = 1;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testMillisecondsToDays() {
        String input = "T" + System.lineSeparator()
                + "ms" + System.lineSeparator()
                + "8640000" + System.lineSeparator()
                + "d" + System.lineSeparator();
        double expected = 1;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testMillisecondsToWeeks() {
        String input = "T" + System.lineSeparator()
                + "ms" + System.lineSeparator()
                + "604800000" + System.lineSeparator()
                + "w" + System.lineSeparator();
        double expected = 1;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testMillisecondsToMonths() {
        String input = "T" + System.lineSeparator()
                + "ms" + System.lineSeparator()
                + "2629800000" + System.lineSeparator()
                + "m" + System.lineSeparator();
        double expected = 1;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testMillisecondsToYears() {
        String input = "T" + System.lineSeparator()
                + "ms" + System.lineSeparator()
                + "31557600000" + System.lineSeparator()
                + "yr" + System.lineSeparator();
        double expected = 1;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testMinutesToMilliseconds() {
        String input = "T" + System.lineSeparator()
                + "min" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 60000;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testHoursToMilliseconds() {
        String input = "T" + System.lineSeparator()
                + "hr" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 3600000;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testDaysToMilliseconds() {
        String input = "T" + System.lineSeparator()
                + "d" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 86400000;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testWeeksToMilliseconds() {
        String input = "T" + System.lineSeparator()
                + "w" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 604800000;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testMonthsToMilliseconds() {
        String input = "T" + System.lineSeparator()
                + "m" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 2629800000.0;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testYearsToMilliseconds() {
        String input = "T" + System.lineSeparator()
                + "yr" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 31557600000.0;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testSecondsToMilliseconds() {
        String input = "T" + System.lineSeparator()
                + "sec" + System.lineSeparator()
                + "10" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 10000;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testSecondsToItself() {
        String input = "T" + System.lineSeparator()
                + "sec" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "sec" + System.lineSeparator();
        double expected = 1;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testSecondsToMinutes() {
        String input = "T" + System.lineSeparator()
                + "sec" + System.lineSeparator()
                + "100" + System.lineSeparator()
                + "min" + System.lineSeparator();
        double expected = 1.67;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testSecondsToHours() {
        String input = "T" + System.lineSeparator()
                + "sec" + System.lineSeparator()
                + "10" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 10000;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testSecondsToDays() {
        String input = "T" + System.lineSeparator()
                + "sec" + System.lineSeparator()
                + "10" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 10000;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testSecondsToWeeks() {
        String input = "T" + System.lineSeparator()
                + "sec" + System.lineSeparator()
                + "10" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 10000;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testSecondsToYears() {
        String input = "T" + System.lineSeparator()
                + "sec" + System.lineSeparator()
                + "10" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 10000;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }



    @Test
    void testMinutesToItself() {
        String input = "T" + System.lineSeparator()
                + "yr" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 31557600000.0;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testHoursToItself() {
        String input = "T" + System.lineSeparator()
                + "yr" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 31557600000.0;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testDaysToItself() {
        String input = "T" + System.lineSeparator()
                + "yr" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 31557600000.0;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testWeeksToItself() {
        String input = "T" + System.lineSeparator()
                + "yr" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 31557600000.0;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }

    @Test
    void testYearsToItself() {
        String input = "T" + System.lineSeparator()
                + "yr" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "ms" + System.lineSeparator();
        double expected = 31557600000.0;
        double actual = UnitConverter.display(testScanner(input));
        assertEquals(expected, actual);
    }
}
