package org.example.numbers;

import java.util.Scanner;
import static java.lang.Integer.parseInt;

/**
 * Mortgage Calculator - Calculate the monthly payments of a fixed term mortgage
 * over given Nth terms at a given interest rate. Also figure out how long it
 * will take the user to pay back the loan. For added complexity, add an option
 * for users to select the compounding interval (Monthly, Weekly, Daily,
 * Continually).
 */
public class MortgageCalculator {
	private MortgageCalculator() {
	}

	private static double calculateFrm(int homePrice, int downPayment, int propertyTax, int homeInsurance,
			int numOfTerms) {
		// P = L * [c * (1 + c)^ n] / [(1 + c)^ n - 1];
		int principal = (homePrice - downPayment) + propertyTax + homeInsurance;
		int monthlyPayments = numOfTerms * 12;
		// double propertyTax = 0.0064; //Maricopa County
		double interestRate = 0.0; // Based on Surprise, AZ

		if (numOfTerms >= 30) {
			interestRate = 0.0529;
		} else if (numOfTerms > 14 && numOfTerms < 30) {
			interestRate = 0.0462;
		} else if (numOfTerms > 4 && numOfTerms < 14) {
			interestRate = 0.0481;
		} else {
			interestRate = 0.04125;
		}

		double interestResult = interestRate / 12;
		return principal * ((interestResult * Math.pow(1 + interestResult, monthlyPayments))
				/ (Math.pow(1 + interestResult, monthlyPayments) - 1));
	}

	public static void printCalculation(Scanner console) {
		try {
			System.out.print("Enter the Home Price: ");
			int price = parseInt(console.next());
			System.out.println();

			System.out.print("Enter the Down Payment: ");
			int downPayment = parseInt(console.next());
			System.out.println();

			System.out.print("Enter the Annual Property Tax: ");
			int propertyTax = parseInt(console.next());
			System.out.println();

			System.out.print("Enter the Annual Insurance Payment: ");
			int homeInsurance = parseInt(console.next());
			System.out.println();

			System.out.print("Enter the Number of Years for the FRM: ");
			int years = parseInt(console.next());
			System.out.println();

			System.out.printf("Your Monthly Payments are: $%.2f%n",
					Math.floor(calculateFrm(price, downPayment, propertyTax, homeInsurance, years)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
