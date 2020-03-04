package org.example.numbers;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import org.example.common.NumberConstants;

import static java.lang.System.out;
import static java.lang.System.exit;

public final class Pinth {
	private static final int LIMIT = 20;

	private Pinth() {}

	public static BigDecimal displayPi(Scanner console) {
		BigDecimal result = null;
		try {
			out.print("Enter an integer between [0 and 20]: ");
			int choice = console.nextInt();

			if (choice == 0) {
				result = BigDecimal.valueOf(3);
				out.println(result);
			}
			else if (choice > 0 && choice <= LIMIT) {
				result = BigDecimal.valueOf(Math.PI).setScale(choice, RoundingMode.DOWN);
				out.println(result);
			}
			else {
				out.println(choice + " does not fit the criteria.");
				result = BigDecimal.ZERO;
				//exit(-1);
			}
		} catch (NumberFormatException | ArithmeticException e) {
			out.println("Unable to process the number: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			out.println("Failed to Display PI: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
}
