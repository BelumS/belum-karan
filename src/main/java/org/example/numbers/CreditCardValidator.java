package org.example.numbers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Credit Card Validator - Takes in a credit card number from a common credit card vendor
 * (Visa, MasterCard, American Express, Discover) and validates it to make sure that it is
 * a valid number (look into how credit cards use a checksum).
 */
public final class CreditCardValidator {
    private CreditCardValidator() {
    }

    public static boolean displayChecksum(Scanner console) {
        try {
            System.out.println("Enter a 16-digit card number: ");
            String cardNumber = console.next();
            System.out.println();

            int[] array = fillCreditCardArray(cardNumber);

            int firstDigit = array[0];
            if (firstDigit < 4 || firstDigit > 7) {
                System.err.println("ERROR: Credit Card Vendor is not recognized!");
                return false;
            }

            int[] arrayStep2 = doubleEveryOtherDigit(array);
            int[] arrayStep3 = addAndReduceDigits(arrayStep2);
            return checkSum(arrayStep3);
        } catch (Exception e) {
            System.err.println("An Exception occurred in CreditCardValidator.displayChecksum() " + e);
            e.printStackTrace();
            throw e;
        }
    }

    private static int[] fillCreditCardArray(String cardNumber) {
        String[] cardNumberSplitter = cardNumber.split("");
        int[] result = new int[cardNumberSplitter.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(cardNumberSplitter[i]);
        }
        return result;
    }

    private static int[] doubleEveryOtherDigit(int[] result) {
        for (int i = 0; i < result.length - 1; i++) {
            if ((i % 2 == 0) && (i < result.length - 1)) {
                result[i] = result[i] * 2;
            }
        }
        return result;
    }

    private static String[] convertIntArrayToString(int[] src) {
        String[] result = new String[src.length];
        for (int i = 0; i < src.length; i++) {
            result[i] = String.valueOf(src[i]);
        }
        return result;
    }

    private static int[] addAndReduceDigits(int[] dest) {
        String[] strArray = convertIntArrayToString(dest);
        for (int i = 0; i < strArray.length - 1; i++) {
            if (strArray[i].length() == 2) {
                var firstDigit = Integer.parseInt(Character.toString(strArray[i].charAt(0)));
                var secondDigit = Integer.parseInt(Character.toString(strArray[i].charAt(1)));
                dest[i] = firstDigit + secondDigit;
            }
        }
        return dest;
    }

    private static int sumArrayElements(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    private static boolean checkSum(int[] array) {
        boolean passed = false;
        int checkSum = sumArrayElements(array) + array[array.length - 1];
        boolean divisible = checkSum % 10 == 0;

        if (divisible) {
            System.out.println("CheckSum = " + checkSum + ", The PAN is valid!");
            passed = true;
        } else {
            System.out.println("CheckSum = " + checkSum + ", The PAN is invalid");
        }
        return passed;
    }
}
