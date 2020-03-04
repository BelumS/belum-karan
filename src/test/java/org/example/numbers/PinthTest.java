package org.example.numbers;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PinthTest {
    private Scanner console;

    @Test
    void testLowerEdgeCase() {
        console = new Scanner(new ByteArrayInputStream("-1".getBytes()));
        BigDecimal result = Pinth.displayPi(console);
        assertEquals(BigDecimal.ZERO, result);
        console.close();
    }

    @Test
    void testAllBasesCases() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 21; ++i) {
            map.put(i, Integer.toString(i));

            console = new Scanner(new ByteArrayInputStream(map.get(i).getBytes()));
            BigDecimal result = Pinth.displayPi(console);
            assertEquals(BigDecimal.valueOf(Math.PI).setScale(i, RoundingMode.DOWN), result);
        }
        console.close();
    }

    @Test
    void testHigherEdgeCase() {
        console = new Scanner(new ByteArrayInputStream("21".getBytes()));
        BigDecimal result = Pinth.displayPi(console);
        assertEquals(BigDecimal.ZERO, result);
        console.close();
    }
}
