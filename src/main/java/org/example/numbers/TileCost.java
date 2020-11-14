package org.example.numbers;

import java.util.Scanner;

import static java.lang.System.err;
import static org.example.constants.NumberConstants.validateEntry;

/**
 * Calculate the total cost of tile it would take to
 * cover a floor plan of width and height, using a 
 * cost entered by the user.
 * @author bsahn on 26-09-2019
 **/
public class TileCost {
    private TileCost() {}

    /**
     * Reads the user input, and then calculates the total cost of tile installation.
     * @param console A standard input <code>Scanner</code>, shared amongst the algorithms that require
     *  user input.
     * @return <code>double</code> value that represents the total tile cost.
     * @throws IllegalArgumentException If the user input is a negative number, or higher than the max allowed value.
     * @throws NumberFormatException If the user input is a letter, or special character instead of a number.
     */
    public static double calculate(Scanner console) throws IllegalArgumentException, NumberFormatException {
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
        } catch (NumberFormatException e) {
            err.println("Invalid entry for the calculation.");
            throw e;
        } catch (Exception e) {
            err.println("An error occurred when calculating the tile cost.");
           throw e;
        }
    }
}
