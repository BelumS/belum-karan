package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.Scanner;

/**
 * @author bsahn on 26-09-2019
 * Calculate the total cost of tile it would take to
 * cover a floor plan of width and height, using a cost entered by the
 * user.
 **/
public class TileCost {
    private TileCost() {
    }

    public static void calculate(Scanner console) {
        try {
            System.out.println();
            System.out.print("Enter the total Square Feet: ");
            int sqFt = validateEntry(Integer.parseInt(console.next()));
            System.out.println();

            System.out.print("Enter the price per tile: $");
            double costPerTile = validateEntry(Double.parseDouble(console.next()));
            System.out.println();

            System.out.print("Enter the Labor Cost: $");
            int labor = validateEntry(Integer.parseInt(console.next()));
            System.out.println();

            System.out.print("Enter the Other Material Cost: $");
            int otherMats = validateEntry(Integer.parseInt(console.next()));
            System.out.println();

            System.out.print("Enter the Removal Cost: $");
            int removalOfOldSurface = validateEntry(Integer.parseInt(console.next()));
            System.out.println();

            System.out.print("Enter the Prep Cost: $");
            int areaPrep = validateEntry(Integer.parseInt(console.next()));
            System.out.println();

            final double total = (costPerTile * sqFt) + removalOfOldSurface + areaPrep + labor + otherMats;
            System.out.printf("The total cost of installation for %dsqft of tile is $%.2f.%n", sqFt, total);
        } catch (NumberFormatException | ArithmeticException e) {
            NumberConstants.printError(e, "Invalid entry for the calculation.");
        } catch (final Exception e) {
            NumberConstants.printError(e, "An error occurred when calculating the tile cost.");
        }
    }

    private static int validateEntry(int val) {
        if (val < 0)
            throw new ArithmeticException(NumberConstants.NEGATIVE_NUMBER);
        return val;
    }

    private static double validateEntry(double val) {
        if (val < 0.0)
            throw new ArithmeticException(NumberConstants.NEGATIVE_NUMBER);
        return val;
    }
}
