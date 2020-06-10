package org.example.numbers;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import static org.example.commons.TestConstants.testScanner;
import static org.junit.jupiter.api.Assertions.*;

public class UnitConverterTest {

    @Test
    public void testThrowsIllegalArgumentException1(){
        String input = "ABC" + System.lineSeparator();
        assertThrows(IllegalArgumentException.class, () ->  UnitConverter.display(testScanner(input)));
    }

    @Test
    public void testThrowsIllegalArgumentException2(){
        String input = "1" + System.lineSeparator();
        assertThrows(IllegalArgumentException.class, () ->  UnitConverter.display(testScanner(input)));
    }

    @Test
    public void testThrowsInputMismatchException(){
        String input = "T" + System.lineSeparator()
                + "ms" + System.lineSeparator()
                + "a" + System.lineSeparator();
        assertThrows(NumberFormatException.class, () ->  UnitConverter.display(testScanner(input)));
    }

    @Test
    public void testThrowsException1(){
        assertThrows(Exception.class, () ->  UnitConverter.display(null));
    }

    @Test
    public void testThrowsException2(){
        String input = "T" + System.lineSeparator()
                + "a" + System.lineSeparator();
        assertThrows(Exception.class, () ->  UnitConverter.display(testScanner(input)));
    }

    @Nested
    class DurationTests {

        @Test
        public void testMillisecondsThrowsIllegalArgumentException(){
            String input = "T" + System.lineSeparator()
                    + "ms" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "1" + System.lineSeparator();
            assertThrows(IllegalArgumentException.class, () ->  UnitConverter.display(testScanner(input)));
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
        void testMillisecondsToWeks() {
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
                    + "3600" + System.lineSeparator()
                    + "hr" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testSecondsToDays() {
            String input = "T" + System.lineSeparator()
                    + "sec" + System.lineSeparator()
                    + "86400" + System.lineSeparator()
                    + "d" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testSecondsToMonths() {
            String input = "T" + System.lineSeparator()
                    + "sec" + System.lineSeparator()
                    + "3000000" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 1.14;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testSecondsToWeeks() {
            String input = "T" + System.lineSeparator()
                    + "sec" + System.lineSeparator()
                    + "6048000" + System.lineSeparator()
                    + "w" + System.lineSeparator();
            double expected = 10;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testSecondsToYears() {
            String input = "T" + System.lineSeparator()
                    + "sec" + System.lineSeparator()
                    + "31557600" + System.lineSeparator()
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
        void testMinutesToSeconds() {
            String input = "T" + System.lineSeparator()
                    + "min" + System.lineSeparator()
                    + "5" + System.lineSeparator()
                    + "sec" + System.lineSeparator();
            double expected = 300;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMinutesToItself() {
            String input = "T" + System.lineSeparator()
                    + "min" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "min" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMinutesToHours() {
            String input = "T" + System.lineSeparator()
                    + "min" + System.lineSeparator()
                    + "100" + System.lineSeparator()
                    + "hr" + System.lineSeparator();
            double expected = 1.67;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMinutesToDays() {
            String input = "T" + System.lineSeparator()
                    + "min" + System.lineSeparator()
                    + "1440" + System.lineSeparator()
                    + "d" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMinutesToWeeks() {
            String input = "T" + System.lineSeparator()
                    + "min" + System.lineSeparator()
                    + "10080" + System.lineSeparator()
                    + "w" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMinutesToMonths() {
            String input = "T" + System.lineSeparator()
                    + "min" + System.lineSeparator()
                    + "43830" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMinutesToYears() {
            String input = "T" + System.lineSeparator()
                    + "min" + System.lineSeparator()
                    + "525960" + System.lineSeparator()
                    + "yr" + System.lineSeparator();
            double expected = 1;
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
        void testHoursToSeconds() {
            String input = "T" + System.lineSeparator()
                    + "hr" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "sec" + System.lineSeparator();
            double expected = 3600;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testHoursToMinutes() {
            String input = "T" + System.lineSeparator()
                    + "hr" + System.lineSeparator()
                    + "1.6667" + System.lineSeparator()
                    + "min" + System.lineSeparator();
            double expected = 100;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testHoursToItself() {
            String input = "T" + System.lineSeparator()
                    + "hr" + System.lineSeparator()
                    + "100" + System.lineSeparator()
                    + "hr" + System.lineSeparator();
            double expected = 100;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testHoursToDays() {
            String input = "T" + System.lineSeparator()
                    + "hr" + System.lineSeparator()
                    + "72" + System.lineSeparator()
                    + "d" + System.lineSeparator();
            double expected = 3;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testHoursToWeeks() {
            String input = "T" + System.lineSeparator()
                    + "hr" + System.lineSeparator()
                    + "168" + System.lineSeparator()
                    + "w" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testHoursToMonths() {
            String input = "T" + System.lineSeparator()
                    + "hr" + System.lineSeparator()
                    + "730.5" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testHoursToYears() {
            String input = "T" + System.lineSeparator()
                    + "hr" + System.lineSeparator()
                    + "876600" + System.lineSeparator()
                    + "yr" + System.lineSeparator();
            double expected = 100;
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
        void testDaysToSeconds() {
            String input = "T" + System.lineSeparator()
                    + "d" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "sec" + System.lineSeparator();
            double expected = 86400;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testDaysToMinutes() {
            String input = "T" + System.lineSeparator()
                    + "d" + System.lineSeparator()
                    + "10" + System.lineSeparator()
                    + "min" + System.lineSeparator();
            double expected = 14400;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testDaysToHours() {
            String input = "T" + System.lineSeparator()
                    + "d" + System.lineSeparator()
                    + "10" + System.lineSeparator()
                    + "hr" + System.lineSeparator();
            double expected = 240;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testDaysToItself() {
            String input = "T" + System.lineSeparator()
                    + "d" + System.lineSeparator()
                    + "10" + System.lineSeparator()
                    + "d" + System.lineSeparator();
            double expected = 10;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testDaysToWeeks() {
            String input = "T" + System.lineSeparator()
                    + "d" + System.lineSeparator()
                    + "28" + System.lineSeparator()
                    + "w" + System.lineSeparator();
            double expected = 4;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testDaysToMonths() {
            String input = "T" + System.lineSeparator()
                    + "d" + System.lineSeparator()
                    + "30" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testDaysToYears() {
            String input = "T" + System.lineSeparator()
                    + "d" + System.lineSeparator()
                    + "730" + System.lineSeparator()
                    + "yr" + System.lineSeparator();
            double expected = 2;
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
        void testWeeksToSeconds() {
            String input = "T" + System.lineSeparator()
                    + "w" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "sec" + System.lineSeparator();
            double expected = 604800;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testWeeksToMinutes() {
            String input = "T" + System.lineSeparator()
                    + "w" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "min" + System.lineSeparator();
            double expected = 10080;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testWeeksToHours() {
            String input = "T" + System.lineSeparator()
                    + "w" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "hr" + System.lineSeparator();
            double expected = 168;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testWeeksToDays() {
            String input = "T" + System.lineSeparator()
                    + "w" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "d" + System.lineSeparator();
            double expected = 7;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testWeeksToItself() {
            String input = "T" + System.lineSeparator()
                    + "w" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "w" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testWeeksToMonths() {
            String input = "T" + System.lineSeparator()
                    + "w" + System.lineSeparator()
                    + "4" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testWeeksToYears() {
            String input = "T" + System.lineSeparator()
                    + "w" + System.lineSeparator()
                    + "104" + System.lineSeparator()
                    + "yr" + System.lineSeparator();
            double expected = 2;
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
        void testMonthsToSeconds() {
            String input = "T" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "sec" + System.lineSeparator();
            double expected = 2629800;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMonthsToMinutes() {
            String input = "T" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "min" + System.lineSeparator();
            double expected = 43830;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMonthsToHours() {
            String input = "T" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "hr" + System.lineSeparator();
            double expected = 731;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMonthsToDays() {
            String input = "T" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "d" + System.lineSeparator();
            double expected = 30;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMonthsToWeeks() {
            String input = "T" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "w" + System.lineSeparator();
            double expected = 4;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMonthsToItself() {
            String input = "T" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMonthsToYears() {
            String input = "T" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "36" + System.lineSeparator()
                    + "yr" + System.lineSeparator();
            double expected = 3;
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
        void testYearsToSeconds() {
            String input = "T" + System.lineSeparator()
                    + "yr" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "sec" + System.lineSeparator();
            double expected = 31557600;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testYearsToMinutes() {
            String input = "T" + System.lineSeparator()
                    + "yr" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "min" + System.lineSeparator();
            double expected = 525960;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testYearsToHours() {
            String input = "T" + System.lineSeparator()
                    + "yr" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "hr" + System.lineSeparator();
            double expected = 8766;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testYearsToDays() {
            String input = "T" + System.lineSeparator()
                    + "yr" + System.lineSeparator()
                    + "2" + System.lineSeparator()
                    + "d" + System.lineSeparator();
            double expected = 730;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testYearsToWeeks() {
            String input = "T" + System.lineSeparator()
                    + "yr" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "w" + System.lineSeparator();
            double expected = 52;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testYearsToMonths() {
            String input = "T" + System.lineSeparator()
                    + "yr" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 12;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testYearsToItself() {
            String input = "T" + System.lineSeparator()
                    + "yr" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "yr" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }
    }

    @Nested
    class LengthTests {
        @Test
        public void testMmThrowsIllegalArgumentException(){
            String input = "L" + System.lineSeparator()
                    + "mm" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "1" + System.lineSeparator();
            assertThrows(IllegalArgumentException.class, () ->  UnitConverter.display(testScanner(input)));
        }

        //MM
        @Test
        void testMmToMm() {
            String input = "L" + System.lineSeparator()
                    + "mm" + System.lineSeparator()
                    + "15" + System.lineSeparator()
                    + "mm" + System.lineSeparator();
            double expected = 15;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMmToCm() {
            String input = "L" + System.lineSeparator()
                    + "mm" + System.lineSeparator()
                    + "10" + System.lineSeparator()
                    + "cm" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMmToIn() {
            String input = "L" + System.lineSeparator()
                    + "mm" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "in" + System.lineSeparator();
            double expected = 0.04;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMmToFt() {
            String input = "L" + System.lineSeparator()
                    + "mm" + System.lineSeparator()
                    + "10" + System.lineSeparator()
                    + "ft" + System.lineSeparator();
            double expected = 0.03;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMmToYd() {
            String input = "L" + System.lineSeparator()
                    + "mm" + System.lineSeparator()
                    + "1000" + System.lineSeparator()
                    + "yd" + System.lineSeparator();
            double expected = 1.09;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMmToM() {
            String input = "L" + System.lineSeparator()
                    + "mm" + System.lineSeparator()
                    + "1000" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMmToKm() {
            String input = "L" + System.lineSeparator()
                    + "mm" + System.lineSeparator()
                    + "1000000" + System.lineSeparator()
                    + "km" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMmToMi() {
            String input = "L" + System.lineSeparator()
                    + "mm" + System.lineSeparator()
                    + "1000000" + System.lineSeparator()
                    + "mi" + System.lineSeparator();
            double expected = 0.62;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //CM
        @Test
        void testCmToMm() {
            String input = "L" + System.lineSeparator()
                    + "cm" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "mm" + System.lineSeparator();
            double expected = 10;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testCmToCm() {
            String input = "L" + System.lineSeparator()
                    + "cm" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "cm" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testCmToIn() {
            String input = "L" + System.lineSeparator()
                    + "cm" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "in" + System.lineSeparator();
            double expected = 0.39;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testCmToFt() {
            String input = "L" + System.lineSeparator()
                    + "cm" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ft" + System.lineSeparator();
            double expected = 0.03;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testCmToYd() {
            String input = "L" + System.lineSeparator()
                    + "cm" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "yd" + System.lineSeparator();
            double expected = 0.01;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testCmToM() {
            String input = "L" + System.lineSeparator()
                    + "cm" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 0.01;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testCmToKm() {
            String input = "L" + System.lineSeparator()
                    + "cm" + System.lineSeparator()
                    + "10000" + System.lineSeparator()
                    + "km" + System.lineSeparator();
            double expected = 0.1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testCmToMi() {
            String input = "L" + System.lineSeparator()
                    + "cm" + System.lineSeparator()
                    + "10000" + System.lineSeparator()
                    + "mi" + System.lineSeparator();
            double expected = 0.06;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //IN
        @Test
        void testInToMm() {
            String input = "L" + System.lineSeparator()
                    + "in" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "mm" + System.lineSeparator();
            double expected = 25.4;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testInToCm() {
            String input = "L" + System.lineSeparator()
                    + "in" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "cm" + System.lineSeparator();
            double expected = 2.54;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testInToIn() {
            String input = "L" + System.lineSeparator()
                    + "in" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "in" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testInToFt() {
            String input = "L" + System.lineSeparator()
                    + "in" + System.lineSeparator()
                    + "12" + System.lineSeparator()
                    + "ft" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testInToYd() {
            String input = "L" + System.lineSeparator()
                    + "in" + System.lineSeparator()
                    + "36" + System.lineSeparator()
                    + "yd" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testInToM() {
            String input = "L" + System.lineSeparator()
                    + "in" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 0.03;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testInToKm() {
            String input = "L" + System.lineSeparator()
                    + "in" + System.lineSeparator()
                    + "10000" + System.lineSeparator()
                    + "km" + System.lineSeparator();
            double expected = 0.25;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testInToMi() {
            String input = "L" + System.lineSeparator()
                    + "in" + System.lineSeparator()
                    + "10000" + System.lineSeparator()
                    + "mi" + System.lineSeparator();
            double expected = 0.16;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //FT
        @Test
        void testFtToMm() {
            String input = "L" + System.lineSeparator()
                    + "ft" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "mm" + System.lineSeparator();
            double expected = 304.8;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testFtToCm() {
            String input = "L" + System.lineSeparator()
                    + "ft" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "cm" + System.lineSeparator();
            double expected = 30.48;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testFtToIn() {
            String input = "L" + System.lineSeparator()
                    + "ft" + System.lineSeparator()
                    + "12" + System.lineSeparator()
                    + "in" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testFtToFt() {
            String input = "L" + System.lineSeparator()
                    + "ft" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ft" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testFtToYd() {
            String input = "L" + System.lineSeparator()
                    + "ft" + System.lineSeparator()
                    + "3" + System.lineSeparator()
                    + "yd" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testFtToM() {
            String input = "L" + System.lineSeparator()
                    + "ft" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 0.3;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testFtToKm() {
            String input = "L" + System.lineSeparator()
                    + "ft" + System.lineSeparator()
                    + "100" + System.lineSeparator()
                    + "km" + System.lineSeparator();
            double expected = 0.03;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testFtToMi() {
            String input = "L" + System.lineSeparator()
                    + "ft" + System.lineSeparator()
                    + "10000" + System.lineSeparator()
                    + "mi" + System.lineSeparator();
            double expected = 1.89;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //YD
        @Test
        void testYdToMm() {
            String input = "L" + System.lineSeparator()
                    + "yd" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "mm" + System.lineSeparator();
            double expected = 914.4;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testYdToCm() {
            String input = "L" + System.lineSeparator()
                    + "yd" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "cm" + System.lineSeparator();
            double expected = 91.44;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testYdToIn() {
            String input = "L" + System.lineSeparator()
                    + "yd" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "in" + System.lineSeparator();
            double expected = 36;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testYdToFt() {
            String input = "L" + System.lineSeparator()
                    + "yd" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ft" + System.lineSeparator();
            double expected = 3;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testYdToYd() {
            String input = "L" + System.lineSeparator()
                    + "yd" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "yd" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testYdToM() {
            String input = "L" + System.lineSeparator()
                    + "yd" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 0.91;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testYdToKm() {
            String input = "L" + System.lineSeparator()
                    + "yd" + System.lineSeparator()
                    + "1000" + System.lineSeparator()
                    + "km" + System.lineSeparator();
            double expected = 0.91;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testYdToMi() {
            String input = "L" + System.lineSeparator()
                    + "yd" + System.lineSeparator()
                    + "10000" + System.lineSeparator()
                    + "mi" + System.lineSeparator();
            double expected = 5.68;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //M
        @Test
        void testMToMm() {
            String input = "L" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "mm" + System.lineSeparator();
            double expected = 1000;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMToCm() {
            String input = "L" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "cm" + System.lineSeparator();
            double expected = 100;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMToIn() {
            String input = "L" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "in" + System.lineSeparator();
            double expected = 39.37;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMToFt() {
            String input = "L" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ft" + System.lineSeparator();
            double expected = 3.28;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMToYd() {
            String input = "L" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "yd" + System.lineSeparator();
            double expected = 1.09;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMToM() {
            String input = "L" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMToKm() {
            String input = "L" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "1000" + System.lineSeparator()
                    + "km" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMToMi() {
            String input = "L" + System.lineSeparator()
                    + "m" + System.lineSeparator()
                    + "10000" + System.lineSeparator()
                    + "mi" + System.lineSeparator();
            double expected = 6.21;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //KM
        @Test
        void testKmToMm() {
            String input = "L" + System.lineSeparator()
                    + "km" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "mm" + System.lineSeparator();
            double expected = 1000000;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testKmToCm() {
            String input = "L" + System.lineSeparator()
                    + "km" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "cm" + System.lineSeparator();
            double expected = 100000;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testKmToIn() {
            String input = "L" + System.lineSeparator()
                    + "km" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "in" + System.lineSeparator();
            double expected = 39370.08;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testKmToFt() {
            String input = "L" + System.lineSeparator()
                    + "km" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ft" + System.lineSeparator();
            double expected = 3280.84;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testKmToYd() {
            String input = "L" + System.lineSeparator()
                    + "km" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "yd" + System.lineSeparator();
            double expected = 1093.61;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testKmToM() {
            String input = "L" + System.lineSeparator()
                    + "km" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 1000;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testKmToKm() {
            String input = "L" + System.lineSeparator()
                    + "km" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "km" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testKmToMi() {
            String input = "L" + System.lineSeparator()
                    + "km" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "mi" + System.lineSeparator();
            double expected = 0.62;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //MI
        @Test
        void testMiToMm() {
            String input = "L" + System.lineSeparator()
                    + "mi" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "mm" + System.lineSeparator();
            double expected = 1609343.95;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMiToCm() {
            String input = "L" + System.lineSeparator()
                    + "mi" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "cm" + System.lineSeparator();
            double expected = 160934.4;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMiToIn() {
            String input = "L" + System.lineSeparator()
                    + "mi" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "in" + System.lineSeparator();
            double expected = 63359.99;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMiToFt() {
            String input = "L" + System.lineSeparator()
                    + "mi" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ft" + System.lineSeparator();
            double expected = 5280;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMiToYd() {
            String input = "L" + System.lineSeparator()
                    + "mi" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "yd" + System.lineSeparator();
            double expected = 1760;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMiToM() {
            String input = "L" + System.lineSeparator()
                    + "mi" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "m" + System.lineSeparator();
            double expected = 1609.34;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMiToKm() {
            String input = "L" + System.lineSeparator()
                    + "mi" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "km" + System.lineSeparator();
            double expected = 1.61;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMiToMi() {
            String input = "L" + System.lineSeparator()
                    + "mi" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "mi" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }
    }

    @Nested
    class MassTests {
        @Test
        public void testMgThrowsIllegalArgumentException(){
            String input = "M" + System.lineSeparator()
                    + "mg" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "1" + System.lineSeparator();
            assertThrows(IllegalArgumentException.class, () ->  UnitConverter.display(testScanner(input)));
        }

        //MG
        @Test
        void testMgToMg() {
            String input = "M" + System.lineSeparator()
                    + "mg" + System.lineSeparator()
                    + "10" + System.lineSeparator()
                    + "mg" + System.lineSeparator();
            double expected = 10;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMgToG() {
            String input = "M" + System.lineSeparator()
                    + "mg" + System.lineSeparator()
                    + "10" + System.lineSeparator()
                    + "g" + System.lineSeparator();
            double expected = 0.01;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMgToOz() {
            String input = "M" + System.lineSeparator()
                    + "mg" + System.lineSeparator()
                    + "10000" + System.lineSeparator()
                    + "oz" + System.lineSeparator();
            double expected = 0.35;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMgToLb() {
            String input = "M" + System.lineSeparator()
                    + "mg" + System.lineSeparator()
                    + "45444" + System.lineSeparator()
                    + "lb" + System.lineSeparator();
            double expected = 0.1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMgToKg() {
            String input = "M" + System.lineSeparator()
                    + "mg" + System.lineSeparator()
                    + "1000000" + System.lineSeparator()
                    + "kg" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testMgToT() {
            String input = "M" + System.lineSeparator()
                    + "mg" + System.lineSeparator()
                    + "1000000000" + System.lineSeparator()
                    + "t" + System.lineSeparator();
            double expected = 1.1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //G
        @Test
        void testGToMg() {
            String input = "M" + System.lineSeparator()
                    + "g" + System.lineSeparator()
                    + "15" + System.lineSeparator()
                    + "mg" + System.lineSeparator();
            double expected = 15000;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testGToG() {
            String input = "M" + System.lineSeparator()
                    + "g" + System.lineSeparator()
                    + "15" + System.lineSeparator()
                    + "g" + System.lineSeparator();
            double expected = 15;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testGToOz() {
            String input = "M" + System.lineSeparator()
                    + "g" + System.lineSeparator()
                    + "28" + System.lineSeparator()
                    + "oz" + System.lineSeparator();
            double expected = 0.99;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testGToLb() {
            String input = "M" + System.lineSeparator()
                    + "g" + System.lineSeparator()
                    + "454" + System.lineSeparator()
                    + "lb" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testGToKg() {
            String input = "M" + System.lineSeparator()
                    + "g" + System.lineSeparator()
                    + "1000" + System.lineSeparator()
                    + "kg" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testGToT() {
            String input = "M" + System.lineSeparator()
                    + "g" + System.lineSeparator()
                    + "1000000" + System.lineSeparator()
                    + "t" + System.lineSeparator();
            double expected = 1.1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //OZ
        @Test
        void testOzToMg() {
            String input = "M" + System.lineSeparator()
                    + "oz" + System.lineSeparator()
                    + "15" + System.lineSeparator()
                    + "mg" + System.lineSeparator();
            double expected = 425242.8;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testOzToG() {
            String input = "M" + System.lineSeparator()
                    + "oz" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "g" + System.lineSeparator();
            double expected = 28.35;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testOzToOz() {
            String input = "M" + System.lineSeparator()
                    + "oz" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "oz" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testOzToLb() {
            String input = "M" + System.lineSeparator()
                    + "oz" + System.lineSeparator()
                    + "16" + System.lineSeparator()
                    + "lb" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testOzToKg() {
            String input = "M" + System.lineSeparator()
                    + "oz" + System.lineSeparator()
                    + "35.3" + System.lineSeparator()
                    + "kg" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testOzToT() {
            String input = "M" + System.lineSeparator()
                    + "oz" + System.lineSeparator()
                    + "32000" + System.lineSeparator()
                    + "t" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //LB
        @Test
        void testLbToMg() {
            String input = "M" + System.lineSeparator()
                    + "lb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "mg" + System.lineSeparator();
            double expected = 453592.32;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testLbToG() {
            String input = "M" + System.lineSeparator()
                    + "lb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "g" + System.lineSeparator();
            double expected = 453.59;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testLbToOz() {
            String input = "M" + System.lineSeparator()
                    + "lb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "oz" + System.lineSeparator();
            double expected = 16;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testLbToLb() {
            String input = "M" + System.lineSeparator()
                    + "lb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "lb" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testLbToKg() {
            String input = "M" + System.lineSeparator()
                    + "lb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "kg" + System.lineSeparator();
            double expected = 0.45;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testLbToT() {
            String input = "M" + System.lineSeparator()
                    + "lb" + System.lineSeparator()
                    + "2000" + System.lineSeparator()
                    + "t" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //KG
        @Test
        void testKgToMg() {
            String input = "M" + System.lineSeparator()
                    + "kg" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "mg" + System.lineSeparator();
            double expected = 1000000;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testKgToG() {
            String input = "M" + System.lineSeparator()
                    + "kg" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "g" + System.lineSeparator();
            double expected = 1000;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testKgToOz() {
            String input = "M" + System.lineSeparator()
                    + "kg" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "oz" + System.lineSeparator();
            double expected = 35.27;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testKgToLb() {
            String input = "M" + System.lineSeparator()
                    + "kg" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "lb" + System.lineSeparator();
            double expected = 2.2;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testKgToKg() {
            String input = "M" + System.lineSeparator()
                    + "kg" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "kg" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testKgToT() {
            String input = "M" + System.lineSeparator()
                    + "kg" + System.lineSeparator()
                    + "1000" + System.lineSeparator()
                    + "t" + System.lineSeparator();
            double expected = 1.1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //T
        @Test
        void testTToMg() {
            String input = "M" + System.lineSeparator()
                    + "t" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "mg" + System.lineSeparator();
            double expected = 907184700;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testTToG() {
            String input = "M" + System.lineSeparator()
                    + "t" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "g" + System.lineSeparator();
            double expected = 907185;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testTToOz() {
            String input = "M" + System.lineSeparator()
                    + "t" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "oz" + System.lineSeparator();
            double expected = 32000;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testTToLb() {
            String input = "M" + System.lineSeparator()
                    + "t" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "lb" + System.lineSeparator();
            double expected = 2000;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testTToKg() {
            String input = "M" + System.lineSeparator()
                    + "t" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "kg" + System.lineSeparator();
            double expected = 907.18;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testTToT() {
            String input = "M" + System.lineSeparator()
                    + "t" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "t" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }
    }

    @Nested
    class TemperatureTests {
        @Test
        public void testCThrowsIllegalArgumentException(){
            String input = "TEMP" + System.lineSeparator()
                    + "c" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "1" + System.lineSeparator();
            assertThrows(IllegalArgumentException.class, () ->  UnitConverter.display(testScanner(input)));
        }

        //C
        @Test
        void testCToC() {
            String input = "TEMP" + System.lineSeparator()
                    + "C" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "C" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testCToF() {
            String input = "TEMP" + System.lineSeparator()
                    + "C" + System.lineSeparator()
                    + "0" + System.lineSeparator()
                    + "F" + System.lineSeparator();
            double expected = 32;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testCToK() {
            String input = "TEMP" + System.lineSeparator()
                    + "C" + System.lineSeparator()
                    + "0" + System.lineSeparator()
                    + "K" + System.lineSeparator();
            double expected = 273.15;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //F
        @Test
        void testFToC() {
            String input = "TEMP" + System.lineSeparator()
                    + "F" + System.lineSeparator()
                    + "0" + System.lineSeparator()
                    + "C" + System.lineSeparator();
            double expected = -17.77;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testFToF() {
            String input = "TEMP" + System.lineSeparator()
                    + "F" + System.lineSeparator()
                    + "0" + System.lineSeparator()
                    + "F" + System.lineSeparator();
            double expected = 0;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testFToK() {
            String input = "TEMP" + System.lineSeparator()
                    + "F" + System.lineSeparator()
                    + "0" + System.lineSeparator()
                    + "K" + System.lineSeparator();
            double expected = 255.37;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //K
        @Test
        void testKToC() {
            String input = "TEMP" + System.lineSeparator()
                    + "K" + System.lineSeparator()
                    + "0" + System.lineSeparator()
                    + "C" + System.lineSeparator();
            double expected = -273.15;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testKToF() {
            String input = "TEMP" + System.lineSeparator()
                    + "K" + System.lineSeparator()
                    + "0" + System.lineSeparator()
                    + "F" + System.lineSeparator();
            double expected = -459.67;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void testKToK() {
            String input = "TEMP" + System.lineSeparator()
                    + "K" + System.lineSeparator()
                    + "0" + System.lineSeparator()
                    + "K" + System.lineSeparator();
            double expected = 0;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }
    }

    @Nested
    class VolumeTests {
        @Test
        public void testMlThrowsIllegalArgumentException(){
            String input = "V" + System.lineSeparator()
                    + "ml" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "1" + System.lineSeparator();
            assertThrows(IllegalArgumentException.class, () ->  UnitConverter.display(testScanner(input)));
        }

        //ML
        @Test
        public void MlToMl() {
            String input = "V" + System.lineSeparator()
                    + "ml" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ml" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void MlToTsp() {
            String input = "V" + System.lineSeparator()
                    + "ml" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tsp" + System.lineSeparator();
            double expected = 0.2;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void MlToTbsp() {
            String input = "V" + System.lineSeparator()
                    + "ml" + System.lineSeparator()
                    + "100" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator();
            double expected = 6.76;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void MlToFloz() {
            String input = "V" + System.lineSeparator()
                    + "ml" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator();
            double expected = 0.03;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void MlToCup() {
            String input = "V" + System.lineSeparator()
                    + "ml" + System.lineSeparator()
                    + "1000" + System.lineSeparator()
                    + "cup" + System.lineSeparator();
            double expected = 4.16;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void MlToPt() {
            String input = "V" + System.lineSeparator()
                    + "ml" + System.lineSeparator()
                    + "1000" + System.lineSeparator()
                    + "pt" + System.lineSeparator();
            double expected = 2.11;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void MlToQt() {
            String input = "V" + System.lineSeparator()
                    + "ml" + System.lineSeparator()
                    + "1000" + System.lineSeparator()
                    + "qt" + System.lineSeparator();
            double expected = 1.05;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void MlToL() {
            String input = "V" + System.lineSeparator()
                    + "ml" + System.lineSeparator()
                    + "1000" + System.lineSeparator()
                    + "l" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void MlToGal() {
            String input = "V" + System.lineSeparator()
                    + "ml" + System.lineSeparator()
                    + "1000" + System.lineSeparator()
                    + "gal" + System.lineSeparator();
            double expected = 0.26;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //TSP
        @Test
        public void TspToMl() {
            String input = "V" + System.lineSeparator()
                    + "tsp" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ml" + System.lineSeparator();
            double expected = 4.92;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TspToTsp() {
            String input = "V" + System.lineSeparator()
                    + "tsp" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tsp" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TspToTbsp() {
            String input = "V" + System.lineSeparator()
                    + "tsp" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator();
            double expected = 0.33;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TspToFloz() {
            String input = "V" + System.lineSeparator()
                    + "tsp" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator();
            double expected = 0.16;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TspToCup() {
            String input = "V" + System.lineSeparator()
                    + "tsp" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "cup" + System.lineSeparator();
            double expected = 0.02;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TspToPt() {
            String input = "V" + System.lineSeparator()
                    + "tsp" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "pt" + System.lineSeparator();
            double expected = 0.01;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TspToQt() {
            String input = "V" + System.lineSeparator()
                    + "tsp" + System.lineSeparator()
                    + "100" + System.lineSeparator()
                    + "qt" + System.lineSeparator();
            double expected = 0.52;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TspToL() {
            String input = "V" + System.lineSeparator()
                    + "tsp" + System.lineSeparator()
                    + "100" + System.lineSeparator()
                    + "l" + System.lineSeparator();
            double expected = 0.49;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TspToGal() {
            String input = "V" + System.lineSeparator()
                    + "tsp" + System.lineSeparator()
                    + "100" + System.lineSeparator()
                    + "gal" + System.lineSeparator();
            double expected = 0.13;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //TBSP
        @Test
        public void TbspToMl() {
            String input = "V" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ml" + System.lineSeparator();
            double expected = 14.78;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TbspToTsp() {
            String input = "V" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tsp" + System.lineSeparator();
            double expected = 3;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TbspToTbsp() {
            String input = "V" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator()
                    + "3" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator();
            double expected = 3;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TbspToFloz() {
            String input = "V" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator()
                    + "3" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator();
            double expected = 1.5;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TbspToCup() {
            String input = "V" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator()
                    + "3" + System.lineSeparator()
                    + "cup" + System.lineSeparator();
            double expected = 0.18;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TbspToPt() {
            String input = "V" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator()
                    + "3" + System.lineSeparator()
                    + "pt" + System.lineSeparator();
            double expected = 0.09;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TbspToQt() {
            String input = "V" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "qt" + System.lineSeparator();
            double expected = 0.01;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TbspToL() {
            String input = "V" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "l" + System.lineSeparator();
            double expected = 0.01;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void TbspToGal() {
            String input = "V" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator()
                    + "10" + System.lineSeparator()
                    + "gal" + System.lineSeparator();
            double expected = 0.03;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //Fl. Oz.
        @Test
        public void FlozToMl() {
            String input = "V" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ml" + System.lineSeparator();
            double expected = 29.57;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void FlozToTsp() {
            String input = "V" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tsp" + System.lineSeparator();
            double expected = 5.99;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void FlozToTbsp() {
            String input = "V" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator();
            double expected = 1.99;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void FlozToFloz() {
            String input = "V" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator()
                    + "1.99" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator();
            double expected = 1.99;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void FlozToCup() {
            String input = "V" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator()
                    + "1.99" + System.lineSeparator()
                    + "cup" + System.lineSeparator();
            double expected = 0.24;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void FlozToPt() {
            String input = "V" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator()
                    + "1.99" + System.lineSeparator()
                    + "pt" + System.lineSeparator();
            double expected = 0.12;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void FlozToQt() {
            String input = "V" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator()
                    + "2" + System.lineSeparator()
                    + "qt" + System.lineSeparator();
            double expected = 0.06;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void FlozToL() {
            String input = "V" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator()
                    + "2" + System.lineSeparator()
                    + "l" + System.lineSeparator();
            double expected = 0.05;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void FlozToGal() {
            String input = "V" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator()
                    + "2" + System.lineSeparator()
                    + "gal" + System.lineSeparator();
            double expected = 0.01;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //Cup
        @Test
        public void cupToMl() {
            String input = "V" + System.lineSeparator()
                    + "cup" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ml" + System.lineSeparator();
            double expected = 240;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void cupToTsp() {
            String input = "V" + System.lineSeparator()
                    + "cup" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tsp" + System.lineSeparator();
            double expected = 48.69;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void cupToTbsp() {
            String input = "V" + System.lineSeparator()
                    + "cup" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator();
            double expected = 16.23;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void cupToFloz() {
            String input = "V" + System.lineSeparator()
                    + "cup" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator();
            double expected = 8.11;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void cupToCup() {
            String input = "V" + System.lineSeparator()
                    + "cup" + System.lineSeparator()
                    + "2" + System.lineSeparator()
                    + "cup" + System.lineSeparator();
            double expected = 2;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void cupToPt() {
            String input = "V" + System.lineSeparator()
                    + "cup" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "pt" + System.lineSeparator();
            double expected = 0.5;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void cupToQt() {
            String input = "V" + System.lineSeparator()
                    + "cup" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "qt" + System.lineSeparator();
            double expected = 0.25;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void cupToL() {
            String input = "V" + System.lineSeparator()
                    + "cup" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "l" + System.lineSeparator();
            double expected = 0.24;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void cupToGal() {
            String input = "V" + System.lineSeparator()
                    + "cup" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "gal" + System.lineSeparator();
            double expected = 0.06;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //PT
        @Test
        public void PtToMl() {
            String input = "V" + System.lineSeparator()
                    + "pt" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ml" + System.lineSeparator();
            double expected = 473.17;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void PtToTsp() {
            String input = "V" + System.lineSeparator()
                    + "pt" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tsp" + System.lineSeparator();
            double expected = 96;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void PtToTbsp() {
            String input = "V" + System.lineSeparator()
                    + "pt" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator();
            double expected = 31.99;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void PtToFloz() {
            String input = "V" + System.lineSeparator()
                    + "pt" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator();
            double expected = 16;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void PtToCup() {
            String input = "V" + System.lineSeparator()
                    + "pt" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "cup" + System.lineSeparator();
            double expected = 1.97;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void PtToPt() {
            String input = "V" + System.lineSeparator()
                    + "pt" + System.lineSeparator()
                    + "1.97" + System.lineSeparator()
                    + "pt" + System.lineSeparator();
            double expected = 1.97;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void PtToQt() {
            String input = "V" + System.lineSeparator()
                    + "pt" + System.lineSeparator()
                    + "25" + System.lineSeparator()
                    + "qt" + System.lineSeparator();
            double expected = 12.5;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void PtToL() {
            String input = "V" + System.lineSeparator()
                    + "pt" + System.lineSeparator()
                    + "20" + System.lineSeparator()
                    + "l" + System.lineSeparator();
            double expected = 9.46;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void PtToGal() {
            String input = "V" + System.lineSeparator()
                    + "pt" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "gal" + System.lineSeparator();
            double expected = 0.12;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //QT
        @Test
        public void QtToMl() {
            String input = "V" + System.lineSeparator()
                    + "qt" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ml" + System.lineSeparator();
            double expected = 946.35;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void QtToTsp() {
            String input = "V" + System.lineSeparator()
                    + "qt" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tsp" + System.lineSeparator();
            double expected = 192;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void QtToTbsp() {
            String input = "V" + System.lineSeparator()
                    + "qt" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator();
            double expected = 63.99;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void QtToFloz() {
            String input = "V" + System.lineSeparator()
                    + "qt" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator();
            double expected = 32;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void QtToCup() {
            String input = "V" + System.lineSeparator()
                    + "qt" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "cup" + System.lineSeparator();
            double expected = 3.94;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void QtToPt() {
            String input = "V" + System.lineSeparator()
                    + "qt" + System.lineSeparator()
                    + "1000" + System.lineSeparator()
                    + "pt" + System.lineSeparator();
            double expected = 2000;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void QtToQt() {
            String input = "V" + System.lineSeparator()
                    + "qt" + System.lineSeparator()
                    + "1000" + System.lineSeparator()
                    + "qt" + System.lineSeparator();
            double expected = 1000;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void QtToL() {
            String input = "V" + System.lineSeparator()
                    + "qt" + System.lineSeparator()
                    + "1000" + System.lineSeparator()
                    + "l" + System.lineSeparator();
            double expected = 946.35;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void QtToGal() {
            String input = "V" + System.lineSeparator()
                    + "qt" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "gal" + System.lineSeparator();
            double expected = 0.25;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //L
        @Test
        public void LToMl() {
            String input = "V" + System.lineSeparator()
                    + "l" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ml" + System.lineSeparator();
            double expected = 1000;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void LToTsp() {
            String input = "V" + System.lineSeparator()
                    + "l" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tsp" + System.lineSeparator();
            double expected = 202.88;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void LToTbsp() {
            String input = "V" + System.lineSeparator()
                    + "l" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator();
            double expected = 67.62;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void LToFloz() {
            String input = "V" + System.lineSeparator()
                    + "l" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator();
            double expected = 33.81;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void LToCup() {
            String input = "V" + System.lineSeparator()
                    + "l" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "cup" + System.lineSeparator();
            double expected = 4.16;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void LToPt() {
            String input = "V" + System.lineSeparator()
                    + "l" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "pt" + System.lineSeparator();
            double expected = 2.11;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void LToQt() {
            String input = "V" + System.lineSeparator()
                    + "l" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "qt" + System.lineSeparator();
            double expected = 1.05;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void LToL() {
            String input = "V" + System.lineSeparator()
                    + "l" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "l" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void LToGal() {
            String input = "V" + System.lineSeparator()
                    + "l" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "gal" + System.lineSeparator();
            double expected = 0.26;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //L
        @Test
        public void GalToMl() {
            String input = "V" + System.lineSeparator()
                    + "gal" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "ml" + System.lineSeparator();
            double expected = 3785.4;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void GalToTsp() {
            String input = "V" + System.lineSeparator()
                    + "gal" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tsp" + System.lineSeparator();
            double expected = 767.99;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void GalToTbsp() {
            String input = "V" + System.lineSeparator()
                    + "gal" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "tbsp" + System.lineSeparator();
            double expected = 255.99;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void GalToFloz() {
            String input = "V" + System.lineSeparator()
                    + "gal" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "fl.oz" + System.lineSeparator();
            double expected = 128;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void GalToCup() {
            String input = "V" + System.lineSeparator()
                    + "gal" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "cup" + System.lineSeparator();
            double expected = 15.77;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void GalToPt() {
            String input = "V" + System.lineSeparator()
                    + "gal" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "pt" + System.lineSeparator();
            double expected = 7.99;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void GalToQt() {
            String input = "V" + System.lineSeparator()
                    + "gal" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "qt" + System.lineSeparator();
            double expected = 3.99;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void GalToL() {
            String input = "V" + System.lineSeparator()
                    + "gal" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "l" + System.lineSeparator();
            double expected = 3.78;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        public void GalToGal() {
            String input = "V" + System.lineSeparator()
                    + "gal" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "gal" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }
    }

    @Nested
    class DigitalStorageTests {
        //Bit
        @Test
        public void testBitThrowsIllegalArgumentException(){
            String input = "DS" + System.lineSeparator()
                    + "bit" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "1" + System.lineSeparator();
            assertThrows(IllegalArgumentException.class, () ->  UnitConverter.display(testScanner(input)));
        }

        @Test
        void bitToBit() {
            String input = "DS" + System.lineSeparator()
                    + "bit" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "bit" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void bitToByte() {
            String input = "DS" + System.lineSeparator()
                    + "bit" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "byte" + System.lineSeparator();
            double expected = 0.12;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //Byte
        @Test
        void byteToBit() {
            String input = "DS" + System.lineSeparator()
                    + "byte" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "bit" + System.lineSeparator();
            double expected = 8;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void byteToByte() {
            String input = "DS" + System.lineSeparator()
                    + "byte" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "byte" + System.lineSeparator();
            double expected = 1;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //KB
        @Test
        void kBToBit() {
            String input = "DS" + System.lineSeparator()
                    + "kb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "bit" + System.lineSeparator();
            double expected = 8 * Math.pow(10, 3);
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void kBToByte() {
            String input = "DS" + System.lineSeparator()
                    + "kb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "byte" + System.lineSeparator();
            double expected = Math.pow(2, 10);
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //MB
        @Test
        void mBToBit() {
            String input = "DS" + System.lineSeparator()
                    + "mb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "bit" + System.lineSeparator();
            double expected = 8 * Math.pow(10, 6);
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void mBToByte() {
            String input = "DS" + System.lineSeparator()
                    + "mb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "byte" + System.lineSeparator();
            double expected = Math.pow(2, 20);
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //GB
        @Test
        void gBToBit() {
            String input = "DS" + System.lineSeparator()
                    + "gb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "bit" + System.lineSeparator();
            double expected = 8 * Math.pow(10, 9);
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void gBToByte() {
            String input = "DS" + System.lineSeparator()
                    + "gb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "byte" + System.lineSeparator();
            double expected = Math.pow(2, 30);
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //TB
        @Test
        void tBToBit() {
            String input = "DS" + System.lineSeparator()
                    + "tb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "bit" + System.lineSeparator();
            double expected = 8 * Math.pow(10, 12);
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void tBToByte() {
            String input = "DS" + System.lineSeparator()
                    + "tb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "byte" + System.lineSeparator();
            double expected = Math.pow(2, 40);
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        //PB
        @Test
        void pBToBit() {
            String input = "DS" + System.lineSeparator()
                    + "pb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "bit" + System.lineSeparator();
            double expected = 8 * Math.pow(10, 15);
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

        @Test
        void pBToByte() {
            String input = "DS" + System.lineSeparator()
                    + "pb" + System.lineSeparator()
                    + "1" + System.lineSeparator()
                    + "byte" + System.lineSeparator();
            double expected = Math.pow(2, 50);
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }
    }
}
