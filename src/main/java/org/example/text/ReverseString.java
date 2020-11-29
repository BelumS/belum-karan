package org.example.text;

import org.example.constants.AppConstants;

import java.util.Scanner;

public final class ReverseString {
    private ReverseString() {
    }

    public static String displayReversal(Scanner scanner) {
        try (scanner) {
            System.out.println("Enter a word: ");
            String word = scanner.nextLine();
            System.out.println();

            String reversed = reverse(word);
            System.out.println("'" + word + "' reversed as '" + reversed + "'");
            return reversed;
        } catch (RuntimeException e) {
            AppConstants.printError(e);
            throw e;
        }
    }

    private static String reverse(String input) {
        assert input != null && !input.isEmpty();
        var splitWords = input.split(" ");
        var builder = new StringBuilder();

        for (String splitWord : splitWords) {
            var temp = splitWord.toCharArray();
            for (int j = temp.length - 1; j >= 0; j--) {
                builder.append(temp[j]);
            }
            builder.append(" ");
        }
        return builder.toString().strip();
    }
}
