package org.example.numbers;

import java.util.EnumSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * Converts various units between one another
 */
public final class UnitConverter {
    private UnitConverter() {
    }

    /**
     * Displays the converted unit
     *
     * @param console the keyboard input shared from the Numbers menu.
     * @return the converted unit
     * @throws IllegalArgumentException if an invalid number is used
     * @throws InputMismatchException   If an invalid input is used
     */
    public static double display(Scanner console) {
        double result = 0;
        try {
            out.print("Choose a measurement: {[T]ime, [S]pace, [M]ass, [Temp]erature, [C]urrency, [V]olume}");
            String choice = console.next();
            out.println();
            switch (choice.toUpperCase()) {
                case "T":
                    result = calculateTimeUnits(console);
                    break;
                case "S":
                    break;
                case "M":
                    break;
                case "TEMP":
                    break;
                case "C":
                    break;
                case "V":
                    break;
                default:
                    throw new IllegalArgumentException("Error! \"" + choice + "\" does not fit the criteria.");
            }
            return result;
        } catch (InputMismatchException | IllegalArgumentException e) {
            err.println("Unable to process the unit: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            err.printf("An %s occurred while completing the action: %s", e.getClass().getSimpleName(), e.getMessage());
            throw e;
        }
    }

    private static double calculateTimeUnits(Scanner console) {
        long result = 0;

        out.println("Choose a Converting Unit: [M]illisecond[s], [Sec]onds, [Min]utes, [H]ou[r]s, [D]ays, [W]eeks, [M]onths, [Y]ea[r]s");
        String from = console.next();
        out.println();

        out.println("How many units?: ");
        int units = Integer.parseInt(console.next());
        out.println();

        out.println("Choose a Converting Unit: [M]illisecond[s], [Sec]onds, [Min]utes, [H]ou[r]s, [D]ays, [W]eeks, [M]onths, [Y]ea[r]s");
        String to = console.next();
        out.println();

        switch (to.toLowerCase()) {
            case "ms":
                if (from.equalsIgnoreCase("ms")) {
                    result = units;
                } else if (from.equalsIgnoreCase("sec")) {
                    result = units * 1000L;
                } else if (from.equalsIgnoreCase("min")) {
                    result = units * 1000L * 60;
                } else if (from.equalsIgnoreCase("hr")) {
                    result = units * 1000L * 3600;
                } else if (from.equalsIgnoreCase("d")) {
                    result = units * 1000L * 3600 * 24;
                } else if (from.equalsIgnoreCase("w")) {
                    result = units * 1000L * 3600 * 24 * 7;
                } else if (from.equalsIgnoreCase("m")) {
                    result = units * 2629800000L;
                } else if (from.equalsIgnoreCase("yr")) {
                    result = units * 31557600000L;
                }
                break;
            case "sec":
                break;
            case "min":
                break;
            case "hr":
                break;
            case "d":
                break;
            case "W":
                break;
            case "m":
                break;
            case "yr":
                break;
            default:
                throw new IllegalArgumentException(from + " is not a valid input!");
        }

        out.printf("%d%s(s) = %d%s(s).%n", units, from, result, to);
        return result;
    }

    private static long convertTimeUnits(String to, TimeUnit unit, long val) {
        Set<TimeUnit> units = EnumSet.allOf(TimeUnit.class);
        return 0;
    }

}
