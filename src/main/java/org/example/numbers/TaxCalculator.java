package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.Scanner;

/**
 * Asks the user to enter a cost and either a country or state tax.
 * It then returns the tax plus the total cost with tax.
 */
public final class TaxCalculator {
    enum USStateTaxes {
        ALABAMA("AL", 9.22),
        ALASKA("AK", 1.76),
        ARIZONA("AZ", 8.4),
        ARKANSAS("AR", 9.47),
        CALIFORNIA("CA", 8.66),
        COLORADO("CO", 7.65),
        CONNECTICUT("CT", 6.35),
        DELAWARE("DE", 0.0),
        DISTRICT_OF_COLUMBIA("DC", 6.00),
        FLORIDA("FL", 7.05),
        GEORGIA("GA", 7.31),
        HAWAII("HI", 4.44),
        IDAHO("ID", 6.03),
        ILLINOIS("IL", 9.08),
        INDIANA("IN", 7),
        IOWA("IA", 6.94),
        KANSAS("KS", 8.68),
        KENTUCKY("KY", 6),
        LOUISIANA("LA", 9.52),
        MAINE("ME", 5.5),
        MARYLAND("MD", 6),
        MASSACHUSETTS("MA", 6.25),
        MICHIGAN("MI", 6),
        MINNESOTA("MN", 7.46),
        MISSISSIPPI("MS", 7.07),
        MISSOURI("MO", 8.18),
        MONTANA("MT", 0.0),
        NEBRASKA("NE", 6.93),
        NEVADA("NV", 8.32),
        NEW_HAMPSHIRE("NH", 0.0),
        NEW_JERSEY("NJ", 6.6),
        NEW_MEXICO("NM", 7.82),
        NEW_YORK("NY", 8.52),
        NORTH_CAROLINA("NC", 6.97),
        NORTH_DAKOTA("ND", 6.86),
        OHIO("OH", 7.17),
        OKLAHOMA("OK", 8.94),
        OREGON("OR", 0.0),
        PENNSLYVANIA("PA", 6.34),
        PUERTO_RICO("PR", 6),
        RHODE_ISLAND("RI", 7),
        SOUTH_CAROLINA("SC", 7.46),
        SOUTH_DAKOTA("SD", 6.4),
        TENNESEE("TN", 9.53),
        TEXAS("TX", 8.19),
        UTAH("UT", 7.18),
        VERMONT("VT", 6.22),
        VIRIGNIA("VA", 5.65),
        WASHINGTON("WA", 9.21),
        WEST_VIRGINIA("WV", 6.41),
        WISCONSIN("WI", 5.46),
        WYOMING("WY", 5.34);

        private final String abbreviation;
        private final double salesTax;

        USStateTaxes(String abbreviation, double salesTax) {
            this.abbreviation = abbreviation;
            this.salesTax = salesTax;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public double getSalesTax() {
            return this.salesTax;
        }

        public String getSalesTaxPercentage() {
            return NumberConstants.roundedCurrencyValue(this.salesTax) + "%";
        }
    }

    //TODO: Add Country Sales Taxes?
    enum CountryTaxes {
        JAMAICA("JAM", 0.0),
        HAITI("HAI", 0.0),
        SIERRA_LEONE("SLL", 0.0),
        LIBERIA("LIB", 0.0),
        ETHIOPIA("ETH", 0.0),
        GHANA("GHA", 0.0),
        KENYA("KEN", 0.0),
        TANZANIA("TZ", 0.0),
        NIGERIA("NGN", 0.0),
        SOUTH_AFRIKA("SAF", 0.0);

        private final String abbreviation;
        private final double salesTax;

        CountryTaxes(String abbreviation, double salesTax) {
            this.abbreviation = abbreviation;
            this.salesTax = salesTax;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public double getSalesTax() {
            return this.salesTax;
        }

        public String getSalesTaxPercentage() {
            return NumberConstants.roundedCurrencyValue(this.salesTax) + "%";
        }
    }

    public static void displayTaxes(Scanner console) {
        System.out.println("Enter the cost of the item: $");
        String cost = console.next();
        System.out.println();

        System.out.println("Enter the State/Country Tax: ");
        String tax = console.next();
        System.out.println();

        double intTax = Double.parseDouble(tax);
        if(intTax > 0.0) {
            System.out.println("The cost of the item is: $" + cost);
        } else {
            System.out.println("No sales tax, the cost of the item is: $" + cost);
        }
    }
}
