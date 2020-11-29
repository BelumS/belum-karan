package org.example.text;

import org.example.common.TestConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    private List<String> list;

    @BeforeEach
    void setup() {
        list = FizzBuzz.displayText(TestConstants.testScanner("15" + System.lineSeparator()));
    }

    @Test
    void testList() {
        assertNotNull(list);
    }

    @Test
    void testThrowsException() {
        assertThrows(Exception.class, () -> FizzBuzz.displayText(null));
    }

    @Test
    void testEmptyList() {
        list = FizzBuzz.displayText(TestConstants.testScanner("0" + System.lineSeparator()));
        assertEquals(0, list.size());
    }

    @Test
    void testThrees() {
        for (int i = 2; i <= list.size(); i += 3) {
            if (i % 3 == 0)
                assertEquals("Fizz", list.get(i));
        }
    }

    @Test
    void testFives() {
        for (int i = 2; i <= list.size(); i += 5) {
            if (i % 5 == 0)
                assertEquals("Buzz", list.get(i));
        }
    }

    @Test
    void testFifteens() {
        for (int i = 2; i <= list.size(); i += 15) {
            if (i % 15 == 0)
                assertEquals("FizzBuzz", list.get(i));
        }
    }

    @Test
    void testNumbers() {
        for (int i = 0; i < list.size(); ++i) {
            if (!(list.get(i).startsWith("F") || list.get(i).startsWith("B"))) {
                assertEquals(Integer.toString(i + 1), list.get(i));
            }
        }
    }
}
