package org.example.numbers;

import static java.lang.System.out;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

import java.util.Scanner;

/**
 * Binary to Decimal and Back Converter** Develop a converter to convert a
 * decimal number to binary, or a binary number (base 2) to its decimal (base 10)
 * equivalent.
 */
public class NumberBaseConverter {
    private NumberBaseConverter() {
    }

    public static void print(Scanner console) {
        try {
            out.print("Are you converting from Binary or Decimal?: ");
            String choice = console.next();
            out.println();

            out.printf("Enter a '%s' number: %n", choice);
            int number = parseInt(console.next());
            out.println();

            out.println("\nValue: " + print(choice, number));
        } catch (Exception e) {
            console.close();
            e.printStackTrace();
        }
    }

    private static String print(String choice, int val) {
        if (choice.equalsIgnoreCase("binary")) {
            return convertBinaryToDecimal(val);
        } else if(choice.equalsIgnoreCase("decimal"))
            return toBinaryString(val);
        return "Invalid Option!";
    }

    private static String convertBinaryToDecimal(int binary) {
        return Integer.toString(parseInt(Integer.toString(binary), 2));
    }
}