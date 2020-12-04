package org.example.text;

import org.example.constants.AppConstants;
import org.example.utils.StringUtils;

import java.util.Scanner;

/**
 * Pig Latin - Pig Latin is a game of alterations played on the English language game.
 * To create the Pig Latin form of an English word the initial consonant sound is
 * transposed to the end of the word and an ay is affixed (Ex.: "banana" would yield anana-bay).
 * Read Wikipedia for more information on rules.
 */
public final class PigLatin {
    private PigLatin() {
    }

    public static String displayGame(Scanner scanner) {
        try (scanner) {
            System.out.println("Enter the words to alter: ");
            String words = scanner.nextLine();

            String result = pigLatin(words);
            System.out.println("'" + words + "' = '" + result + "'");
            return result;
        } catch (Exception e) {
            AppConstants.printError(e);
            throw e;
        }
    }

    private static String pigLatin(String input) throws IllegalArgumentException {
        assert input != null && !input.isEmpty() && !input.isBlank();
        String lowerInput = input.toLowerCase();
        int len = lowerInput.length();
        int index = -1;

        for (int i = 0; i < len; i++) {
            if (StringUtils.hasFirstVowel(lowerInput.charAt(i))) {
                index = i;
                break;
            }
        }

        if (index == -1)
            throw new IllegalArgumentException("No vowels found. Pig Latin not possible.");

        return lowerInput.substring(index) + "-" + lowerInput.substring(0, index) + "ay";
    }
}
