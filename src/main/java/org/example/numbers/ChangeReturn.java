package org.example.numbers;

import java.util.Scanner;

/**
 **Change Return Program** - The user enters a cost and then the amount of money given. 
 * The program will figure out the change and the number of 
 *  quarters, dimes, nickels, pennies needed for the change.
 */
public final class ChangeReturn {
    private ChangeReturn(){}

    public static void print(Scanner console) {
        try {
            System.out.print("Enter how much money you have, in USD: ");
            double cash = Double.parseDouble(console.next());
            System.out.println();

            calculate(cash);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void calculate(double money) {
        double pennies = money * 100;
        int quarters =  (int) pennies / 25;
        int dimes = (int) pennies / 10;
        double nickels = (int) pennies / 5;
        
        System.out.printf("Total: $%.2f = [Quarters: %d, Dimes: %d, Nickels: %.0f, Pennies: %.0f]%n", money, quarters, dimes, nickels, pennies);
    }

}