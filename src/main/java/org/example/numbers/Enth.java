package org.example.numbers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import org.example.common.NumberConstants;

public class Enth {
	private static final int LIMIT = 20;

	private Enth() {
	}

	public static void displayE(Scanner console) {
		try {
			System.out.print("Enter an integer between [0 and 20]: ");
			int choice = console.nextInt();
			System.out.println();

			if (choice == 0)
				System.out.println(2);
			else if (choice > 0 && choice <= LIMIT)
				System.out.println(new BigDecimal(Math.E).setScale(choice, RoundingMode.DOWN));
			else {
				System.out.println(NumberConstants.DECIMAL_OVERFLOW);
				System.exit(-1);
			}
		} catch (Exception e) {
			System.out.println("Failed to Display e: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
