package org.example.numbers;

import org.example.constants.NumberConstants;

import java.util.*;

import static java.lang.System.*;

/**
 * Generates a table of 2 exponents.
 */
public class PowersOfTwo {
	private PowersOfTwo(){}

	/**
	 * Generates the powers of 2 table.
	 * @param console the keyboard input shared from the Numbers menu.
	 * @return a map holding two's table
	 * @throws NumberFormatException If an invalid input is used
	 */
	public static Map<String, Long> simpleCalculatePowers(Scanner console) {
		int limit = 0;
		try {
			Map<String, Long> twosTable = new LinkedHashMap<>();
			out.print("Enter an exponent to view its place in the Two's Table: ");
			limit = NumberConstants.validateEntry(Integer.parseInt(console.next()));
			out.println();

			for (int i = 0; i <= limit; i++) {
				twosTable.put("2^"+i, (long) Math.pow(2, i));
			}
			out.println(twosTable);
			return twosTable;
		} catch (NumberFormatException e) {
			err.println(NumberConstants.INVALID_INPUT);
			throw e;
		} catch (Exception e) {
			err.println("Failed to process the 2's Table!");
			throw e;
		}
	}
}
