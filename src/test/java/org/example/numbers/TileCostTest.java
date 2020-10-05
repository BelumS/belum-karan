package org.example.numbers;

import org.junit.jupiter.api.Test;

import static org.example.common.TestConstants.testScanner;
import static org.junit.jupiter.api.Assertions.*;

public class TileCostTest {

    @Test
    void verifyTileCost() throws Exception {
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
        assertEquals(expected, actual);
    }

    @Test
    void tileCost_throwsNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> TileCost.calculate(testScanner("a")));
    }

    @Test
    void testNegativeSquareFeet_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> TileCost.calculate(testScanner("-1")));
    }

    @Test
    void testNegativeCostPerTile_throwsIllegalArgumentException() {
        int squareFeet = 1000;
        double costPerTile = -4.30;

        String input = squareFeet + System.lineSeparator()
                + costPerTile + System.lineSeparator();

        assertThrows(IllegalArgumentException.class, () -> TileCost.calculate(testScanner(input)));
    }

    @Test
    void tileCost_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> TileCost.calculate(null));
    }
}
