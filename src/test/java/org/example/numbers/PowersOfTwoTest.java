package org.example.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.example.commons.TestConstants.testScanner;
import static org.example.numbers.PowersOfTwo.*;
import static org.junit.jupiter.api.Assertions.*;

public class PowersOfTwoTest {

    @Test
    void validateTwosTable() {
        String input = "11";
        Map<String, Long> actual = simpleCalculatePowers(testScanner(input));

        Map<String, Long> expected = new LinkedHashMap<>();
        for(int i = 0; i < Integer.parseInt(input); ++i) {
            expected.put("2^"+i, (long) Math.pow(2, i));
            assertEquals(expected.get("2^"+i), actual.get("2^"+i));
        }
    }

    @Test
    void validate_invalidInputThrowsNumberFormatException() {
        assertThrows(NumberFormatException.class, ()-> simpleCalculatePowers(testScanner("a")));
    }

    @Test
    void validate_invalidInputThrowsNullPointerException() {
        assertThrows(NullPointerException.class, ()-> simpleCalculatePowers(null));
    }
}
