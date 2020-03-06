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
        BigDecimal result = Enth.displayE(testScanner("-1"));
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    void testAllBasesCases() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 21; ++i) {
            map.put(i, Integer.toString(i));
            BigDecimal result = Enth.displayE(testScanner(map.get(i)));
            assertEquals(BigDecimal.valueOf(Math.E).setScale(i, RoundingMode.DOWN), result);
        }
    }

    @Test
    void testHigherEdgeCase() {
        BigDecimal result = Enth.displayE(testScanner("21"));
        assertEquals(BigDecimal.ZERO, result);
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
