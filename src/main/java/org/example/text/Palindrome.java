package org.example.text;

import org.example.constants.AppConstants;
import org.example.utils.StringUtils;

import java.util.Scanner;

/**
 * Checks if the string entered by the user is a palindrome.
 * That is that it reads the same forwards as backwards like “racecar”.
 */
public final class Palindrome {
    private Palindrome() {
    }

    public static boolean displayIfPalindrome(Scanner scanner) {
        try (scanner) {
            System.out.println("Enter a word: ");
            String word = scanner.nextLine();
            return checkIfPalindrome(word);
        } catch (Exception e) {
            AppConstants.printError(e);
            throw e;
        }
    }

    private static boolean checkIfPalindrome(String input) {
        boolean valid = false;
        if (StringUtils.isNotBlank(input)) {
            String reverseInput = new StringBuilder(input).reverse().toString();
            if (input.equals(reverseInput)) {
                valid = true;
                System.out.println("'" + input + "' is a palindrome");
            } else
                System.out.println("'" + input + "' is not a palindrome.");
        }
        return valid;
    }

}
