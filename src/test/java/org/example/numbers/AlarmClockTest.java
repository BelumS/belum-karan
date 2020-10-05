package org.example.numbers;

import org.junit.jupiter.api.Test;

import static org.example.common.TestConstants.testScanner;

public class AlarmClockTest {

    @Test
    public void testDefaultTime() throws Exception {
        String input = "N" + System.lineSeparator()
                + "N" + System.lineSeparator();
        AlarmClock.displayAlarm(testScanner(input));
    }

    @Test
    public void testSetAlarm() throws Exception {
        String input = "Y" + System.lineSeparator()
                + "10" + System.lineSeparator()
                + "10" + System.lineSeparator()
                + "N" + System.lineSeparator();
        AlarmClock.displayAlarm(testScanner(input));
    }

    @Test
    public void testSetTime() throws Exception {
        String input = "N" + System.lineSeparator()
                + "Y" + System.lineSeparator()
                + "23" + System.lineSeparator()
                + "23" + System.lineSeparator();
        AlarmClock.displayAlarm(testScanner(input));
    }

    @Test
    public void testSetTimeAndAlarm() throws Exception {
        String input = "Y" + System.lineSeparator()
                + "12" + System.lineSeparator()
                + "12" + System.lineSeparator()
                + "Y" + System.lineSeparator()
                + "23" + System.lineSeparator()
                + "58" + System.lineSeparator();
        AlarmClock.displayAlarm(testScanner(input));
    }

    @Test
    public void testDefaultAlarm() throws Exception {
        String input = "N" + System.lineSeparator()
                + "Y" + System.lineSeparator()
                + "0" + System.lineSeparator()
                + "0" + System.lineSeparator();
        AlarmClock.displayAlarm(testScanner(input));
    }
}
