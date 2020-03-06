package org.example.numbers;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import static org.example.commons.TestConstants.testScanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EnthTest {
    @Test
    void testLowerEdgeCase() {
        assertThrows(IllegalArgumentException.class, () -> Enth.displayE(testScanner("-1")));

    }

    @Test
    void testAllBasesCases() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 21; ++i) {
            map.put(i, Integer.toString(i));
            assertEquals(BigDecimal.valueOf(Math.E).setScale(i, RoundingMode.DOWN), Enth.displayE(testScanner(map.get(i))));
        }
    }

    @Test
    void testHigherEdgeCase() {
        assertThrows(IllegalArgumentException.class, () -> Enth.displayE(testScanner("21")));
    }

    @Test
    void testInputMismatchException() {
        assertThrows(InputMismatchException.class, () -> Enth.displayE(testScanner("a")));
    }

    @Test
    void testNullPointerException() {
        assertThrows(NullPointerException.class, () -> Enth.displayE(null));
    }
}
