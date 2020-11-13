package org.example.numbers;

import java.util.Scanner;

/**
 * Fast Exponentiation - Ask the user to enter 2 integers a and b
 * and output a^b (i.e. pow(a,b)) in O(lg n) time complexity.
 */
public final class FastExponentiation {
    private FastExponentiation() {
    }

    public static double displayResult(Scanner scanner) {
        try (scanner) {
            System.out.println("Enter the first number: ");
            String a = scanner.next();

            System.out.println("Enter the second number: ");
            String b = scanner.next();

            double equation = fastExponent(a, b);

            System.out.println("[" + a + "^" + b + " = " + equation + "]");
            return equation;
        } catch (Exception e) {
            System.err.println("An Exception occurred " + e);
            throw e;
        }
    }

    private static double fastExponent(String inputA, String inputB) {
        int a = Integer.parseInt(inputA);
        int b = Integer.parseInt(inputB);
        double temp = 0;

        if (b == 0)
            return 1;
        else {
            temp = Math.pow(a, b / 2.0);
            if (b % 2 == 0)
                return temp * temp;
            else {
                temp = Math.pow(a, (b - 1.0) / 2.0);
                return temp * temp * a;
            }
        }
    }
}
