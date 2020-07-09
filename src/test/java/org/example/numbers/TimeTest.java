package org.example.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimeTest {
    private Time time;

    @BeforeEach
    public void setup(){
        time = new Time(0, 0);
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
    public void testSetMinutes() {
        int expected = 30;
        time.setMinutes(expected);
        int actual = time.getMinutes();
        assertEquals(expected, actual);
    }
}
