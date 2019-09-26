package org.example.numbers;

import java.util.Scanner;

public class PowersOfTwo {
	private PowersOfTwo(){}

	public static void simpleCalculatePowers(Scanner console) {
		try {
			System.out.print("Enter an exponent and view its place in the Two's Table: ");
			int limit = Integer.parseInt(console.next());
			System.out.println();

			for (int i = 0; i <= limit; i++) {
				System.out.printf("2^%d = %d%n", i, Long.valueOf((long) Math.pow(2, i)));
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
