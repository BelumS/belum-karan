package org.example.numbers;

import org.example.common.NumberConstants;
import org.example.common.StringUtils;

import java.util.EnumSet;
import java.util.Optional;
import java.util.Scanner;

/**
 * Asks the user to enter a cost and either a country or state tax.
 * It then returns the tax plus the total cost with tax.
 */
public final class TaxCalculator {
    private enum USStateTaxes {
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
        PENNSYLVANIA("PA", 6.34),
        PUERTO_RICO("PR", 6),
        RHODE_ISLAND("RI", 7),
        SOUTH_CAROLINA("SC", 7.46),
        SOUTH_DAKOTA("SD", 6.4),
        TENNESSEE("TN", 9.53),
        TEXAS("TX", 8.19),
        UTAH("UT", 7.18),
        VERMONT("VT", 6.22),
        VIRGINIA("VA", 5.65),
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

        public String getSimpleName() {
            String name = this.name();
            String delimiter = "_";

            if (name.contains(delimiter)) {
                String[] names = name.split(delimiter);
                String first = StringUtils.capitalize(names[0].toLowerCase());
                String last = StringUtils.capitalize(names[1].toLowerCase());

                if (names.length == 2) {
                    return first + " " + last;
                } else if (names.length == 3) {
                    return first + " " + names[1].toLowerCase() + " " + StringUtils.capitalize(names[2].toLowerCase());
                }
            }

            name = name.toLowerCase();
            return StringUtils.capitalize(name);
        }
    }

    private enum CountryTaxes {
        JAMAICA("JAM", 16.5),
        HAITI("HAI", 10),
        SIERRA_LEONE("SLL", 15),
        LIBERIA("LIB", 0.0),
        ETHIOPIA("ETH", 15),
        GHANA("GHA", 12.5),
        KENYA("KEN", 14),
        TANZANIA("TZ", 18),
        NIGERIA("NGN", 7.5),
        SOUTH_AFRIKA("SAF", 15);

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

        public String getSimpleName() {
            String name = this.name();
            final String delimiter = "_";

            if (name.contains(delimiter)) {
                String[] names = name.split(delimiter);
                String first = StringUtils.capitalize(names[0].toLowerCase());
                String last = StringUtils.capitalize(names[1].toLowerCase());

                if (names.length == 2) {
                    return first + " " + last;
                }
            }

            name = name.toLowerCase();
            return StringUtils.capitalize(name);
        }
    }

    public static double calculateSalesTax(Scanner console) {
        System.out.println("Enter the cost of the item: $");
        String cost = console.next();
        System.out.println();

        System.out.println("Enter the State/Country abbreviation: ");
        String zone = console.next();
        System.out.println();

        var stateTax = findStateTaxInfo(zone);
        var countryTax = findCountryTaxInfo(zone);
        if (stateTax.isPresent()) {
            var tax = stateTax.get();
            if (tax.getSalesTax() > 0.0) {
                cost = String.valueOf(NumberConstants.roundedValues(Double.parseDouble(cost) * ((tax.getSalesTax() / 100) + 1)));
                System.out.println("In " + tax.getSimpleName() + " the sales tax is " + tax.getSalesTaxPercentage() + ", and the cost of the item is: $" + cost);
            } else {
                System.out.println("In " + tax.getSimpleName() + ", the cost of the item is: $" + cost);
            }
        } else {
            var tax = countryTax.get();
            if (tax.getSalesTax() > 0.0) {
                cost = String.valueOf(NumberConstants.roundedValues(Double.parseDouble(cost) * ((tax.getSalesTax() / 100) + 1)));
                System.out.println("In " + tax.getSimpleName() + " the sales tax is " + tax.getSalesTaxPercentage() + ", and the cost of the item is: $" + cost);
            } else {
                System.out.println("In " + tax.getSimpleName() + ", the cost of the item is: $" + cost);
            }
        }


        return Double.parseDouble(cost);
    }

    private static Optional<USStateTaxes> findStateTaxInfo(String region) {
        assert region != null && region.length() >= 1;
        return EnumSet.allOf(USStateTaxes.class).stream()
                .filter(state -> region.equalsIgnoreCase(state.getAbbreviation()))
                .findFirst();
    }

    private static Optional<CountryTaxes> findCountryTaxInfo(String region) {
        assert region != null && region.length() >= 1;
        return EnumSet.allOf(CountryTaxes.class).stream()
                .filter(country -> region.equalsIgnoreCase(country.getAbbreviation()))
                .findFirst();
    }

}
