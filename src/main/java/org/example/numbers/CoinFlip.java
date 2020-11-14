package org.example.numbers;

import org.example.common.NumberConstants;
import org.example.common.ValueConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Write some code that simulates flipping a single coin
 * however many times the user decides.
 * <p>
 * The code should record the outcomes
 * and count the number of tails and heads.
 */
public final class CoinFlip {
    private static final String VALUE_HEADS = "Heads";
    private static final String VALUE_TAILS = "Tails";

    private CoinFlip() {
    }

    public static int displayResult(Scanner scanner) {
        try (scanner) {
            System.out.println("Want to flip a coin? ");
            String choice = scanner.next();

            if (ValueConstants.VALUE_Y.equalsIgnoreCase(choice)) {
                System.out.println("How many flips? ");
                int numberOfFlips = Integer.parseInt(scanner.next());

                var coin = flips(ThreadLocalRandom.current(), numberOfFlips);
                return coin.size();
            } else {
                System.out.println("Exiting...");
                return -1;
            }
        } catch (Exception e) {
            System.err.println("An Exception occurred. " + e);
            e.printStackTrace();
            throw e;
        }
    }

    private static List<String> flips(ThreadLocalRandom random, int num) {
        var list = new ArrayList<String>();
        double headCount = 0;
        double tailCount = 0;

        for (int i = 0; i < num; i++) {
            var flip = random.nextBoolean();

            if (flip) {
                headCount++;
                list.add(VALUE_HEADS);
            } else {
                tailCount++;
                list.add(VALUE_TAILS);
            }
        }

        double headPercentage = NumberConstants.percentageValue(headCount, list.size());
        double tailPercentage = NumberConstants.percentageValue(tailCount, list.size());
        System.out.printf("You flipped [%d] times for: [%.2f%% %s] and [%.2f%% %s].%n", list.size(), headPercentage, VALUE_HEADS, tailPercentage, VALUE_TAILS);
        return list;
    }
}
