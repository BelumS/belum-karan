package org.example.numbers;

import org.example.common.ValueConstants;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * A happy number is defined by the following process.
 * <br/><br/>
 * <p>
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * <br/><br/>
 * <p>
 * <p>
 * Those numbers for which this process ends in 1 are happy numbers,
 * while those that do not end in 1 are unhappy numbers.
 * <br/><br/>
 * <p>
 * <p>
 * Display an example of your output here. Find first 8 happy numbers.
 **/
public final class HappyNumbers {
    private static final List<Integer> LIST = new ArrayList<>();

    private HappyNumbers() {
    }

    public static void displayNumbers(Scanner scanner) {
        try (scanner) {
            System.out.println("Want to Run the Scanner?: ");
            String choice = scanner.next();

            if (ValueConstants.VALUE_Y.equalsIgnoreCase(choice)) {
                for (int i = 1; i < 50; i++) {
                    isHappy(i);
                }
                System.out.println("The first 8 Happy Numbers are: " + LIST.subList(0, 8));
            } else if (ValueConstants.VALUE_N.equalsIgnoreCase(choice)) {
                System.out.println("Goodbye! ");
            } else {
                throw new InputMismatchException("'" + choice + "' is not an accepted input!");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.err.println("An input Exception occurred: " + e);
            throw e;
        } catch (Exception e) {
            System.err.println("An Error occurred: " + e);
            throw e;
        }
    }

    private static int happyNumber(int number) {
        assert number > 0;
        int rem = 0;
        int sum = 0;

        while (number > 0) {
            rem = number % 10;
            sum += (rem * rem);
            number /= 10;
        }
        return sum;
    }

    private static void isHappy(int number) {
        int result = number;
        while (result != 1 && result != 4) {
            result = happyNumber(result);
        }

        if (result == 1)
            LIST.add(number);
    }

}
