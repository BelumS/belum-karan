package org.example.text;

import org.example.constants.AppConstants;
import org.example.utils.StringUtils;

import java.util.Scanner;

/**
 * Enter a string and the program counts the number of vowels in the text.
 * For added complexity have it report a sum of each vowel found.
 **/
public final class CountVowels {
    private CountVowels() {
    }

    public static int displayVowels(Scanner scanner) {
        try (scanner) {
            System.out.println("Enter a word: ");
            String words = StringUtils.validateWords(scanner.nextLine());

            int numberOfVowels = countVowelsFrom(words);
            System.out.println("\"" + words + "\" has " + numberOfVowels + " vowels.");
            return numberOfVowels;
        } catch (Error | Exception e) {
            AppConstants.printError(e);
            throw e;
        }
    }

    private static int countVowelsFrom(String input) {
        assert input != null && !input.isEmpty();
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (StringUtils.hasFirstVowel(input.charAt(i))) {
                counter++;
            }
        }
        return counter;
    }
}
