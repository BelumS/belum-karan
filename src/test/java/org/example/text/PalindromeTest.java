package org.example.text;

import org.example.common.TestConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @Test
    void testIsPalindrome() {
        String input = "121" + System.lineSeparator();
        assertTrue(Palindrome.displayIfPalindrome(TestConstants.testScanner(input)));
    }

    @Test
    void testIsNotPalindrome() {
        String input = "Juice" + System.lineSeparator();
        assertFalse(Palindrome.displayIfPalindrome(TestConstants.testScanner(input)));
    }

    @Test
    void testThrowException() {
        assertThrows(Exception.class, () -> Palindrome.displayIfPalindrome(null));
    }

}
