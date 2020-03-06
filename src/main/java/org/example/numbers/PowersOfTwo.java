package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.*;

import static java.lang.System.*;

public class PowersOfTwo {
	private PowersOfTwo(){}

	public static Map<String, Long> simpleCalculatePowers(Scanner console) {
		int limit = 0;
		try {
			Map<String, Long> twosTable = new LinkedHashMap<>();
			out.print("Enter an exponent and view its place in the Two's Table: ");
			limit = Integer.parseInt(console.next());
			out.println();

			for (int i = 0; i <= limit; i++) {
				twosTable.put("2^"+i, (long) Math.pow(2, i));
			}
			out.println(twosTable);
			return twosTable;
		} catch (NumberFormatException | InputMismatchException e) {
			err.println(NumberConstants.INVALID_INPUT);
			throw e;
		} catch (Exception e) {
			err.println("Failed to process the 2's Table!");
			throw e;
		}
	}
}
