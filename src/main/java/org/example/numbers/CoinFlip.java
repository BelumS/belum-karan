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
    private static final String HEADS = "Heads";
    private static final String TAILS = "Tails";

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
        double headCount = 0;
        double tailCount = 0;
        var list = new ArrayList<String>();
        for (int i = 0; i < num; i++) {
            var flip = random.nextBoolean();

            if (flip) {
                headCount++;
                list.add(HEADS);
            } else {
                tailCount++;
                list.add(TAILS);
            }
        }

        double headPercentage = NumberConstants.roundedValues(headCount / list.size()) * 100;
        double tailPercentage = NumberConstants.roundedValues(tailCount / list.size()) * 100;
        System.out.printf("You flipped [%d] times for: [%.2f%% %s] and [%.2f%% %s].%n", list.size(), headPercentage, HEADS, tailPercentage, TAILS);
        return list;
    }
}
