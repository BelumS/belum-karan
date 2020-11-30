package org.example.text;

import org.example.common.TestConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PigLatinTest {

    @Test
    void testPigLatinThrowsException() {
        String input = "BCD" + System.lineSeparator();
        assertThrows(Exception.class, () -> PigLatin.displayGame(TestConstants.testScanner(input)));
    }

    @Test
    void testBanana() {
        String input = "Banana" + System.lineSeparator();
        assertEquals("anana-bay", PigLatin.displayGame(TestConstants.testScanner(input)));
    }

    @Test
    void testApple() {
        String input = "Apple" + System.lineSeparator();
        assertEquals("apple-ay", PigLatin.displayGame(TestConstants.testScanner(input)));
    }

    @Test
    void testPig() {
        String input = "Pig" + System.lineSeparator();
        assertEquals("ig-pay", PigLatin.displayGame(TestConstants.testScanner(input)));
    }
}
