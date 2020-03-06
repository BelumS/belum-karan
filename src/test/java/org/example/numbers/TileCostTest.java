package org.example.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.example.commons.TestConstants.testScanner;

public class TileCostTest {

    @Test
    void verifyTileCost() {
        int squareFeet = 1000;
        double costPerTile = 4.30;
        int otherMaterials = 120;
        int laborCost = 200;
        int removalOfOldSurface = 100;
        int preparationCost = 200;

        String input = squareFeet + System.lineSeparator()
                + costPerTile + System.lineSeparator()
                + laborCost + System.lineSeparator()
                + otherMaterials + System.lineSeparator()
                + removalOfOldSurface + System.lineSeparator()
                + preparationCost + System.lineSeparator();

        double expected = (costPerTile * squareFeet) + removalOfOldSurface + preparationCost + laborCost + otherMaterials;
        double actual = TileCost.calculate(testScanner(input));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void tileCost_throwsNumberFormatException() {
        Assertions.assertThrows(NumberFormatException.class, () -> TileCost.calculate(testScanner("a")));
    }

    @Test
    void testNegativeSquareFeet_throwsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TileCost.calculate(testScanner("-1")));
    }

    @Test
    void testNegativeCostPerTile_throwsIllegalArgumentException() {
        int squareFeet = 1000;
        double costPerTile = -4.30;

        String input = squareFeet + System.lineSeparator()
                + costPerTile + System.lineSeparator();

        Assertions.assertThrows(IllegalArgumentException.class, () -> TileCost.calculate(testScanner(input)));
    }

    @Test
    void tileCost_throwsNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> TileCost.calculate(null));
    }
}
