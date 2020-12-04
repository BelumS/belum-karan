package org.example.text;

import org.example.constants.AppConstants;

import java.util.Scanner;

import static org.example.constants.ValueConstants.VALUE_BLANK;

/**
 * Counts the number of individual words in a string.
 * For added complexity read these strings in from a
 * text file and generate a summary.
 */
public final class CountWords {
    private CountWords() {
    }

    public static int displayCount(Scanner scanner) {
        try (scanner) {
            System.out.println("Write a sentence: ");
            String sentence = scanner.nextLine();

            int numberOfWords = countWords(sentence);
            System.out.println("'" + sentence + "' has " + numberOfWords + " word(s).");
            return numberOfWords;
        } catch (Exception e) {
            AppConstants.printError(e);
            throw e;
        }
    }

    private static int countWords(String input) {
        if (input.contains(VALUE_BLANK)) {
            return input.split(VALUE_BLANK).length;
        } else
            return 1;
    }

}
