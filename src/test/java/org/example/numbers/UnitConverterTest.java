package org.example.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.junit.platform.commons.util.StringUtils;

import static org.example.commons.TestConstants.testScanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitConverterTest {

    static class DurationTests {

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
                    + "ms" + System.lineSeparator();
            double expected = 31557600000.0;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }
    }

    static class LengthTests {
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
                    + "mm" + System.lineSeparator()
                    + "1000000" + System.lineSeparator()
                    + "mi" + System.lineSeparator();
            double expected = 0.62;
            double actual = UnitConverter.display(testScanner(input));
            assertEquals(expected, actual);
        }

    }
}
