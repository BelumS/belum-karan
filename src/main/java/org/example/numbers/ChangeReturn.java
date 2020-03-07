package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.Scanner;

import static java.lang.System.*;
import static java.lang.System.err;

/**
 **Change Return Program** - The user enters a cost and then the amount of money given. 
 * The program will figure out the change and the number of 
 *  quarters, dimes, nickels, pennies needed for the change.
 */
public final class ChangeReturn {
    private ChangeReturn(){}

    public static void print(Scanner console) {
        try {
            out.print("Enter how much money you have, in USD: ");
            double cash = Double.parseDouble(console.next());
            out.println();

            if(cash < 0.0)
                throw new IllegalArgumentException(NumberConstants.NEGATIVE_NUMBER);

            calculate(cash);
        } catch (IllegalArgumentException e) {
          err.println(NumberConstants.INVALID_INPUT);
          throw e;
        } catch(Exception e) {
            err.println("An error occurred while processing the change!");
            throw e;
        }
    }

    private static void calculate(double money) {
        double pennies = money * 100;
        int quarters =  (int) pennies / 25;
        int dimes = (int) pennies / 10;
        double nickels = (int) pennies / 5;
        
        out.printf("Total: $%.2f = [Quarters: %d, Dimes: %d, Nickels: %.0f, Pennies: %.0f]%n", money, quarters, dimes, nickels, pennies);
    }

}