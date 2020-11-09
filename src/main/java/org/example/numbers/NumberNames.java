package org.example.numbers;

import java.util.Scanner;

/**
 * Show how to spell out a number in English.
 * You can use a preexisting implementation or roll your own,
 * but you should support inputs up to at least one million
 * (or the maximum value of your language's default bounded integer type, if that's less).
 * <br/>
 * Optional: Support for inputs other than positive integers (like zero, negative integers, and floating-point numbers).
 */
public final class NumberNames {
    private static final String ZERO_WORD = "Zero";
    private static final String ZERO_NUMBER = "0";
    private static final String HUNDRED = " Hundred";

    private static final String[] SINGLES = new String[]{
            "", " One", " Two", " Three",
            " Four", " Five", " Six", " Seven",
            " Eight", " Nine"
    };

    private static final String[] DOUBLES = new String[]{
            " Ten", " Eleven", " Twelve", " Thirteen",
            " Fourteen", " Fifteen", " Sixteen", " Seventeen",
            " Eighteen", " Nineteen"
    };

    private static final String[] TENS = new String[]{
            "", "", " Twenty", " Thirty",
            " Forty", " Fifty", " Sixty", " Seventy",
            " Eighty", " Ninety"
    };

    private static final String[] HUNDREDS = new String[]{
            "", " Thousand ", " Million ", " Billion "
    };

    private NumberNames() {
    }

    public static String displayNames(Scanner scanner) {
        try (scanner) {
            System.out.println("Enter a number: ");
            String input = scanner.next();

            String result = (input.equalsIgnoreCase(ZERO_NUMBER)) ? ZERO_WORD : convertToWords(input);
            System.out.println(input + " = " + result);
            return result;
        } catch (Exception e) {
            System.out.println("An Exception occurred " + e);
            throw e;
        }
    }

    private static String convertToWords(String input) {
        assert input != null && input.length() > 0;
        int number = Integer.parseInt(input);

        StringBuilder wordBuilder = new StringBuilder();
        int index = 0;

        do {
            int num = number % 1000;
            if (num != 0) {
                String str = convertThreeOrLessDigits(num);
                wordBuilder.insert(0, str + HUNDREDS[index]);
            }
            index++;
            number /= 1000;
        } while (number > 0);
        return wordBuilder.toString().trim();
    }

    private static String convertThreeOrLessDigits(int number) {
        String word = "";
        int num = number % 100;

        if (num < 10) {
            word += SINGLES[num];
        } else if (num < 20) {
            word += DOUBLES[num % 10];
        } else {
            word = TENS[num / 10] + SINGLES[num % 10];
        }
        word = (number / 100 > 0) ? SINGLES[number / 100] + HUNDRED + word : word;
        return word.trim();
    }

}
