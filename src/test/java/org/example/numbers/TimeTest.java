package org.example.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimeTest {
    private Time time;

    @BeforeEach
    public void setup(){
        time = new Time(23, 59);
    }

    @Test
    public void defaultConstructor() {
        time = new Time();
        assertNotNull(time);
    }

    @Test
    public void constructor() {
        assertNotNull(time);
    }

    @Test
    public void testSetHours() {
        int expected = 0;
        time.setHours(expected);
        int actual = time.getHours();
        assertEquals(expected, actual);
    }

    @Test
    public void testSetHoursThrowsException() {
        assertThrows(AssertionError.class, () -> time.setHours(25));
    }

    @Test
    public void testSetMinutes() {
        int expected = 30;
        time.setMinutes(expected);
        int actual = time.getMinutes();
        assertEquals(expected, actual);
    }

    @Test
    public void testSetMinutesThrowsException() {
        assertThrows(AssertionError.class, () -> time.setMinutes(63));
    }

    @Test
    public void testIncrementHours() {
        time = new Time(11, 23);
        time.incrementHours();
        int expected = time.getHours();
        assertEquals(expected, 12);
    }

    @Test
    public void testIncrementHoursOverLimit() {
        time.incrementHours();
        int expected = time.getHours();
        assertEquals(expected, 0);
    }

    @Test
    public void testIncrementMinutes() {
        time = new Time(13, 57);
        time.incrementMinutes();
        int actualMins = time.getMinutes();
        assertEquals(58, actualMins);
    }

    @Test
    public void testIncrementMinutesOverLimit() {
        time.incrementMinutes();
        int actualMins = time.getMinutes();
        int actualHours = time.getHours();
        assertEquals(0, actualMins);
        assertEquals(0, actualHours);
    }

    @Test
    public void testShowCurrentTime() {
        time.showCurrentTime();
        assertNotNull(time);
    }
}
