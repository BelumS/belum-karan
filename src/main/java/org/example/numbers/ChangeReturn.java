package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.err;
import static java.lang.System.out;
import static org.example.numbers.ChangeReturn.USACoins.*;
import static org.example.numbers.ChangeReturn.USADollars.*;
import static org.example.numbers.ChangeReturn.USADollars.FIFTY_DOLLARS;
import static org.example.numbers.ChangeReturn.USADollars.HUNDRED_DOLLARS;

/**
 * The user enters a cost and then the amount of money given.
 * The program will figure out the change, and the number of
 * quarters, dimes, nickels, pennies needed for the change.
 */
public final class ChangeReturn {
    /**
     * Represents the values of the United States cents.
     */
    enum USACoins {
        QUARTER(25),
        DIME(10),
        NICKEL(5),
        PENNY(1);

        private int value;

        USACoins(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    /** Represents the values of the United States Dollar (USD) */
    enum USADollars {
        HUNDRED_DOLLARS(100),
        FIFTY_DOLLARS(50),
        TWENTY_DOLLARS(20),
        TEN_DOLLARS(10),
        FIVE_DOLLARS(5),
        DOLLAR(1);

        private int value;

        USADollars(int value) { this.value = value; }
        private int value() { return this.value; }
    }

    private ChangeReturn() {
    }

    public static void print(Scanner console) {
        try {
            out.println("Enter the item cost: ");
            double costOfItem = NumberConstants.validateEntry(Double.parseDouble(console.next()));
            out.println();

            out.print("Enter your payment amount: ");
            double payment = NumberConstants.validateEntry(Double.parseDouble(console.next()));
            out.println();

            if (payment < costOfItem)
                throw new ArithmeticException("You don't have enough money to purchase this item!");
            calculate((Math.abs(costOfItem - payment)));
        } catch (IllegalArgumentException | InputMismatchException e) {
            err.println("Unable to process the change return due to: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            err.println("An error occurred while processing the change!");
            throw e;
        }
    }

    private static Map<String, Integer> calculate(double money) {
        final int dollars = (int) money;
        int hundreds = dollars / HUNDRED_DOLLARS.value();
        int fifties = (dollars % HUNDRED_DOLLARS.value()) / FIFTY_DOLLARS.value();
        int twenties = (dollars % HUNDRED_DOLLARS.value() % FIFTY_DOLLARS.value()) / TWENTY_DOLLARS.value();
        int tens = (dollars % HUNDRED_DOLLARS.value() % FIFTY_DOLLARS.value() % TWENTY_DOLLARS.value()) / TEN_DOLLARS.value();
        int fives = (dollars % HUNDRED_DOLLARS.value() % FIFTY_DOLLARS.value() % TWENTY_DOLLARS.value() % TEN_DOLLARS.value()) / FIVE_DOLLARS.value();
        int ones = (dollars % HUNDRED_DOLLARS.value() % FIFTY_DOLLARS.value() % TWENTY_DOLLARS.value() % TEN_DOLLARS.value() % FIVE_DOLLARS.value()) / DOLLAR.value();

        final int cents = (int) Math.round((money * 100) - (dollars * 100));
        int quarters = cents / QUARTER.value();
        int dimes = (cents % QUARTER.value()) / DIME.value();
        int nickels = ((cents % QUARTER.value()) % DIME.value()) / NICKEL.value();
        int pennies = cents % QUARTER.value() % DIME.value() % NICKEL.value();

        Map<String, Integer> changeReturn = Stream.of(
                new AbstractMap.SimpleEntry<>(HUNDRED_DOLLARS.name(), 0),
                new AbstractMap.SimpleEntry<>(FIFTY_DOLLARS.name(), 0),
                new AbstractMap.SimpleEntry<>(TWENTY_DOLLARS.name(), 0),
                new AbstractMap.SimpleEntry<>(TEN_DOLLARS.name(), 0),
                new AbstractMap.SimpleEntry<>(FIVE_DOLLARS.name(), 0),
                new AbstractMap.SimpleEntry<>(DOLLAR.name(), 0)
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        out.println(changeReturn);

        out.printf("Change returned: $%.2f = [Hundreds: %d, Fifties: %d, Twenties: %d, Tens: %d, Fives: %d, Ones: %d,"
                 + " Quarters: %d, Dimes: %d, Nickels: %d, Pennies: %d]%n",
                money, hundreds, fifties, twenties, tens, fives, ones, quarters, dimes, nickels, pennies);
        return changeReturn;
    }
}