package org.example.numbers;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static org.example.commons.TestConstants.testScanner;
import static org.junit.jupiter.api.Assertions.*;

class PinthTest {
    @Test
    void testLowerEdgeCase() {
        assertThrows(IllegalArgumentException.class, () -> Pinth.displayPi(testScanner("-1")));
    }

    @Test
    void testAllBasesCases() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 21; ++i) {
            map.put(i, Integer.toString(i));
            BigDecimal result = Pinth.displayPi(testScanner(map.get(i)));
            assertEquals(BigDecimal.valueOf(Math.PI).setScale(i, RoundingMode.DOWN), result);
        }
    }

    @Test
    void testHigherEdgeCase() {
        assertThrows(IllegalArgumentException.class, () -> Pinth.displayPi(testScanner("21")));
    }

    @Test
    void testInputMismatchException() {
        assertThrows(NumberFormatException.class, () -> Pinth.displayPi(testScanner("a")));
    }

    @Test
    void testNullPointerException() {
        assertThrows(NullPointerException.class, () -> Pinth.displayPi(null));
    }
}
