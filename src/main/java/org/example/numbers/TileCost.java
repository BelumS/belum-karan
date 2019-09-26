package org.example.numbers;

import java.util.Scanner;

/**
 * @author bsahn on 26-09-2019 
 * Calculate the total cost of tile it would take to
 * cover a floor plan of width and height, using a cost entered by the
 * user.
 **/
public class TileCost {
	private TileCost(){}

	public static void calculate(Scanner console) {
		try {
			System.out.print("Enter the price per tile $");
			double cost = Double.parseDouble(console.next());

			System.out.println("Enter the Labor Cost: $");
			int labor = Integer.parseInt(console.next());

			System.out.println("Enter the Other Material Cost: $");
			int otherMats = Integer.parseInt(console.next());

			System.out.println("Enter the Removal Cost: $");
			int removalOfOldSurface = Integer.parseInt(console.next());

			System.out.println("Enter the Prep Cost: $");
			int areaPrep = Integer.parseInt(console.next());

			System.out.println("Enter the total Square Feet: ");
			int sqFt = Integer.parseInt(console.next());

			double total = (cost + removalOfOldSurface + areaPrep + labor + otherMats) * sqFt;

			System.out.printf("The total cost of installation for %dsqft of tile is $%.2f.%n", sqFt, total);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
