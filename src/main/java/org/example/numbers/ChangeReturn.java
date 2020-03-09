package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;
import static java.lang.System.err;
import static org.example.numbers.ChangeReturn.USACurrency.*;

/**
 * The user enters a cost and then the amount of money given. 
 * The program will figure out the change, and the number of 
 *  quarters, dimes, nickels, pennies needed for the change.
 */
public final class ChangeReturn {
    /** Represents the currency values of the United States Dollar (USD) */
    enum USACurrency {
        FIFTY_DOLLARS(50.00),
        TWENTY_DOLLARS(20.00),
        TEN_DOLLARS(10.00),
        FIVE_DOLLARS(5.00),
        DOLLAR(1.00),
        QUARTER(0.25),
        DIME(0.10),
        NICKEL(0.05),
        PENNY(0.01);

        private double value;

        USACurrency(double value) {
            this.value = value;
        }

        public double value() { return value; }
    }

    private ChangeReturn(){}

    public static void print(Scanner console) {
        try {
            out.println("Enter the item cost: ");
            double costOfItem = NumberConstants.validateEntry(Double.parseDouble(console.next()));

            out.print("Enter your payment amount: ");
            double payment = NumberConstants.validateEntry(Double.parseDouble(console.next()));
            out.println();

            calculate(costOfItem - payment);
        } catch (IllegalArgumentException | InputMismatchException e) {
          err.println("Unable to process the change return due to: " + e.getMessage());
          throw e;
        } catch(Exception e) {
            err.println("An error occurred while processing the change!");
            throw e;
        }
    }

    private static void calculate(double money) {
        int quarters = processChangeInCoins(money, QUARTER);
        int dimes = processChangeInCoins(money, DIME);
        int nickels = processChangeInCoins(money, NICKEL);
        int pennies = processChangeInCoins(money, PENNY);
        
        out.printf("Total in USD: $%.2f = [Quarters: %d, Dimes: %d, Nickels: %d, Pennies: %d]%n", money, quarters, dimes, nickels, pennies);
    }

    private static int processChangeInDollars(double change, USACurrency dollarDenomination) {
        if(dollarDenomination == FIFTY_DOLLARS) {
            change -= (int) change;
            change /= FIFTY_DOLLARS.value();
        } else if (dollarDenomination == TWENTY_DOLLARS) {
            change -= (int) change;
            change %= FIFTY_DOLLARS.value();
            change /= TWENTY_DOLLARS.value();
        } else if(dollarDenomination == TEN_DOLLARS) {
            change -= (int) change;
            change %= FIFTY_DOLLARS.value();
            change %= TWENTY_DOLLARS.value();
            change /= TEN_DOLLARS.value();
        } else if(dollarDenomination == FIVE_DOLLARS) {
            change -= (int) change;
            change %= FIFTY_DOLLARS.value();
            change %= TWENTY_DOLLARS.value();
            change %= TEN_DOLLARS.value();
            change /= FIVE_DOLLARS.value();
        } else if(dollarDenomination == DOLLAR) {
            change -= (int) change;
            change %= FIFTY_DOLLARS.value();
            change %= TWENTY_DOLLARS.value();
            change %= TEN_DOLLARS.value();
            change /= DOLLAR.value();
        }
        return (int) change;
    }

    private static int processChangeInCoins(double change, USACurrency coinType) {
        if(coinType == QUARTER) {
            change -= (int) change;
            change /= QUARTER.value();
        } else if (coinType == DIME) {
            change -= (int) change;
            change %= QUARTER.value();
            change /= DIME.value();
        } else if(coinType == NICKEL) {
            change -= (int) change;
            change %= QUARTER.value();
            change %= DIME.value();
            change /= NICKEL.value();
        } else if(coinType == PENNY) {
            change -= (int) change;
            change %= QUARTER.value();
            change %= DIME.value();
            change %= NICKEL.value();
            change /= PENNY.value();
        }
        return (int) change;
    }
}