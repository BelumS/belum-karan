package org.example.numbers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Pinth {
	private static final int LIMIT = 20;

	private Pinth() {
	}

	public static void displayPi() {
		try (Scanner console = new Scanner(System.in)) {
			System.out.print("Enter an integer between [0 and 20]: ");
			int choice = console.nextInt();
			System.out.println();

			if (choice == 0)
				System.out.println(3);
			else if (choice > 0 && choice <= LIMIT)
				System.out.println(new BigDecimal(Math.PI).setScale(choice, RoundingMode.DOWN));
			else {
				System.out.println("Error: Decimal overload!");
				System.exit(-1);
			}
		} catch (Exception e) {
			System.out.println("Failed to Display PI: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
