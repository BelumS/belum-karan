package org.example.numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.System.err;
import static java.lang.System.out;
import static org.example.constants.NumberConstants.roundedCurrencyValue;
import static org.example.constants.NumberConstants.validateEntry;

/**
 * Calculate the monthly payments of a fixed term mortgage
 * over given Nth terms at a given interest rate. Also figure out how long it
 * will take the user to pay back the loan. For added complexity, add an option
 * for users to select the compounding interval (Monthly, Weekly, Daily, Continually).
 */
public class MortgageCalculator {
    private MortgageCalculator() {
    }

    /**
     * Displays the mortgage calculation.
     *
     * @param console the keyboard input shared from the Numbers menu.
     * @return the fixed rate mortgage calculation
     * @throws IllegalArgumentException if an invalid number is used
     * @throws InputMismatchException   If an invalid input is used
     */
    public static double printCalculation(Scanner console) {
        try {
            out.println("Enter the Home Price: ");
            int price = validateEntry(parseInt(console.next()));

            out.println("Enter the Down Payment: ");
            int downPayment = validateEntry(parseInt(console.next()));

            out.println("Enter the Annual Property Tax: ");
            double propertyTax = validateEntry(parseDouble(console.next()));

            out.println("Enter the Annual Insurance Payment: ");
            double homeInsurance = validateEntry(parseDouble(console.next()));

            out.println("Enter the Number of Years for the FRM: ");
            int years = validateEntry(parseInt(console.next()));

            out.println("Which interest rate option?: [D]aily, [W]eekly, [M]onthly, [C]ontinually?: ");
            String compoundInterestChoice = console.next();

            double standardPayment = roundedCurrencyValue(calculateCompoundingFRM(console, price, downPayment, compoundInterestChoice, propertyTax, homeInsurance, years));
            out.printf("Your Monthly Payments are: $%.2f%n", standardPayment);

            return standardPayment;
        } catch (IllegalArgumentException | InputMismatchException e) {
            err.println("Unable to complete the calculation due to: " + e.getMessage());
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            err.println("An error occurred while performing the calculation.");
            e.printStackTrace();
            throw e;
        }
    }

    private static double calculateCompoundingFRM(Scanner console, int homePrice, int downPayment, String compoundChoice, double propertyTax, double homeInsurance,
                                                  int numOfTerms) {
        double principal = (homePrice - downPayment) + propertyTax + homeInsurance;
        int monthlyPayments = numOfTerms * 12;
        double interestRate = 0.04125;

        if (numOfTerms > 29) {
            interestRate = 0.0529;
        } else if (numOfTerms > 14) {
            interestRate = 0.0462;
        } else if (numOfTerms > 4 && numOfTerms < 14) {
            interestRate = 0.0481;
        }

        double compoundedPrincipal = calculateCompoundingInterest(interestRate, compoundChoice, principal);
        double totalPayment = compoundedPrincipal / monthlyPayments;

        out.println("How much would you like to pay per month?: ");
        double userPayment = validateEntry(parseDouble(console.next()));
        out.printf("It'll take you %.1f years to pay off the house.%n", calculateLoanPaymentTerm(compoundedPrincipal, totalPayment, userPayment));

        return Math.max(totalPayment, userPayment);
    }

    private static double calculateLoanPaymentTerm(double principal, double standardPayment, double userPayment) {
        return roundedCurrencyValue(principal / Math.max(standardPayment, userPayment)) / 12.0;
    }

    private static double calculateCompoundingInterest(double standardRate, String rateName, double principal) {
        int term;
        switch (rateName.toUpperCase()) {
            case "D":
                term = CompoundInterest.DAILY.getInterestTerm();
                break;
            case "W":
                term = CompoundInterest.WEEKLY.getInterestTerm();
                break;
            case "M":
                term = CompoundInterest.MONTHLY.getInterestTerm();
                break;
            case "C":
                return principal * Math.pow(Math.E, standardRate);
            default:
                throw new IllegalArgumentException("Unexpected value: " + rateName.toUpperCase());
        }
        return principal * Math.pow((1 + standardRate / term), term);
    }

    enum CompoundInterest {
        DAILY("D", 365),
        WEEKLY("W", 52),
        MONTHLY("M", 12),
        CONTINUALLY("C", 1);

        private String name;
        private int interestTerm;

        CompoundInterest(String name, int interestTerm) {
            this.name = name;
            this.interestTerm = interestTerm;
        }

        public int getInterestTerm() {
            return interestTerm;
        }
    }
}
