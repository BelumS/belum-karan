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
    private TileCost() {}

    public static double calculate(Scanner console) {
        try {
            System.out.println();
            System.out.print("Enter the total Square Feet: ");
            int squareFeet = validateEntry(Integer.parseInt(console.next()));
            System.out.println();

            System.out.print("Enter the price per tile: $");
            double costPerTile = validateEntry(Double.parseDouble(console.next()));
            System.out.println();

            System.out.print("Enter the Labor Cost: $");
            int laborCost = validateEntry(Integer.parseInt(console.next()));
            System.out.println();

            System.out.print("Enter the Other Material Cost: $");
            int otherMaterials = validateEntry(Integer.parseInt(console.next()));
            System.out.println();

            System.out.print("Enter the Removal Cost: $");
            int removalOfOldSurface = validateEntry(Integer.parseInt(console.next()));
            System.out.println();

            System.out.print("Enter the Prep Cost: $");
            int preparationCost = validateEntry(Integer.parseInt(console.next()));
            System.out.println();

            final double total = (costPerTile * squareFeet) + removalOfOldSurface + preparationCost + laborCost + otherMaterials;
            System.out.printf("The total cost of installation for %dsqft of tile is $%.2f.%n", squareFeet, total);
            return total;
        } catch (NumberFormatException | ArithmeticException e) {
            NumberConstants.printError(e, "Invalid entry for the calculation.");
        } catch (Exception e) {
            NumberConstants.printError(e, "An error occurred when calculating the tile cost.");
        }
        return -1;
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
