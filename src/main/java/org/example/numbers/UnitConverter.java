package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;
import static org.example.numbers.UnitConverter.DurationUnits.*;

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
            out.print("Choose a measurement: {[T]ime, [L]ength, [M]ass, [Temp]erature, [C]urrency, [V]olume}");
            String choice = console.next();
            out.println();
            switch (choice.toUpperCase()) {
                case "T":
                    result = convertDuration(console);
                    break;
                case "L":
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

    private static double convertDuration(Scanner console) {
        double result = 0;

        out.println("Choose a Duration: [M]illisecond[s], [Sec]onds, [Min]utes, [H]ou[r]s, [D]ays, [W]eeks, [M]onths, [Y]ea[r]s");
        String from = console.next();
        out.println();

        out.println("How many units?: ");
        long units = Long.parseLong(console.next());
        out.println();

        out.println("Choose a Converting Duration: [M]illisecond[s], [Sec]onds, [Min]utes, [H]ou[r]s, [D]ays, [W]eeks, [M]onths, [Y]ea[r]s");
        String to = console.next();
        out.println();

        switch (to.toLowerCase()) {
            case "ms":
                result = milliSeconds(from, units);
                break;
            case "sec":
                result = seconds(from, units);
                break;
            case "min":
                result = minutes(from, units);
                break;
            case "hr":
                result = hours(from, units);
                break;
            case "d":
                result = days(from, units);
                break;
            case "w":
                result = weeks(from, units);
                break;
            case "m":
                result = months(from, units);
                break;
            case "yr":
                result = years(from, units);
                break;
            default:
                throw new IllegalArgumentException(from + " is not a valid input!");
        }
        double roundedResult = NumberConstants.roundedValues(result);
        out.printf("%d%s(s) = %.2f%s(s).%n", units, from, roundedResult, to);
        return roundedResult;
    }

    static class DurationUnits {
        private DurationUnits() {
        }

        static long milliSeconds(String from, long units) {
            if (from.equalsIgnoreCase("ms")) {
                return units;
            } else if (from.equalsIgnoreCase("sec")) {
                return units * 1000L;
            } else if (from.equalsIgnoreCase("min")) {
                return units * 1000L * 60;
            } else if (from.equalsIgnoreCase("hr")) {
                return units * 1000L * 3600;
            } else if (from.equalsIgnoreCase("d")) {
                return units * 1000L * 3600 * 24;
            } else if (from.equalsIgnoreCase("w")) {
                return units * 1000L * 3600 * 24 * 7;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 2629800000L;
            } else if (from.equalsIgnoreCase("yr")) {
                return units * 31557600000L;
            }
            return -1;
        }

        static long seconds(String from, long units) {
            if (from.equalsIgnoreCase("ms")) {
                return units / 1000L;
            } else if (from.equalsIgnoreCase("sec")) {
                return units;
            } else if (from.equalsIgnoreCase("min")) {
                return units * 60;
            } else if (from.equalsIgnoreCase("hr")) {
                return units * 3600;
            } else if (from.equalsIgnoreCase("d")) {
                return units * 3600 * 24;
            } else if (from.equalsIgnoreCase("w")) {
                return units * 3600 * 24 * 7;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 2629800L;
            } else if (from.equalsIgnoreCase("yr")) {
                return units * 31557600L;
            }
            return -1;
        }

        static double minutes(String from, long units) {
            if (from.equalsIgnoreCase("ms")) {
                return units / 60000.0;
            } else if (from.equalsIgnoreCase("sec")) {
                return units / 60.0;
            } else if (from.equalsIgnoreCase("min")) {
                return units;
            } else if (from.equalsIgnoreCase("hr")) {
                return units * 60.0;
            } else if (from.equalsIgnoreCase("d")) {
                return units * 60 * 24.0;
            } else if (from.equalsIgnoreCase("w")) {
                return units * 60 * 24 * 7.0;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 43830.0;
            } else if (from.equalsIgnoreCase("yr")) {
                return units * 525960.0;
            }
            return -1;
        }

        static long hours(String from, long units) {
            if (from.equalsIgnoreCase("ms")) {
                return units / 3600000;
            } else if (from.equalsIgnoreCase("sec")) {
                return units / 3600;
            } else if (from.equalsIgnoreCase("min")) {
                return units / 60;
            } else if (from.equalsIgnoreCase("hr")) {
                return units;
            } else if (from.equalsIgnoreCase("d")) {
                return units * 24;
            } else if (from.equalsIgnoreCase("w")) {
                return units * 24 * 7;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 731;
            } else if (from.equalsIgnoreCase("yr")) {
                return units * 8766;
            }
            return -1;
        }

        static long days(String from, long units) {
            if (from.equalsIgnoreCase("ms")) {
                return units / 8640000;
            } else if (from.equalsIgnoreCase("sec")) {
                return units / 86400;
            } else if (from.equalsIgnoreCase("min")) {
                return units / 1440;
            } else if (from.equalsIgnoreCase("hr")) {
                return units / 24;
            } else if (from.equalsIgnoreCase("d")) {
                return units;
            } else if (from.equalsIgnoreCase("w")) {
                return units * 7;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 30;
            } else if (from.equalsIgnoreCase("yr")) {
                return units * 365;
            }
            return -1;
        }

        static long weeks(String from, long units) {
            if (from.equalsIgnoreCase("ms")) {
                return units / 604800000;
            } else if (from.equalsIgnoreCase("sec")) {
                return units / 604800;
            } else if (from.equalsIgnoreCase("min")) {
                return units / 10080;
            } else if (from.equalsIgnoreCase("hr")) {
                return units / 168;
            } else if (from.equalsIgnoreCase("d")) {
                return units / 7;
            } else if (from.equalsIgnoreCase("w")) {
                return units;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 4;
            } else if (from.equalsIgnoreCase("yr")) {
                return units * 52;
            }
            return -1;
        }

        static long months(String from, long units) {
            if (from.equalsIgnoreCase("ms")) {
                return units / 2629800000L;
            } else if (from.equalsIgnoreCase("sec")) {
                return units / 2629800;
            } else if (from.equalsIgnoreCase("min")) {
                return units / 43830;
            } else if (from.equalsIgnoreCase("hr")) {
                return units / 731;
            } else if (from.equalsIgnoreCase("d")) {
                return units / 30;
            } else if (from.equalsIgnoreCase("w")) {
                return units / 4;
            } else if (from.equalsIgnoreCase("m")) {
                return units;
            } else if (from.equalsIgnoreCase("yr")) {
                return units * 12;
            }
            return -1;
        }

        static long years(String from, long units) {
            if (from.equalsIgnoreCase("ms")) {
                return units / 31557600000L;
            } else if (from.equalsIgnoreCase("sec")) {
                return units / 31557600;
            } else if (from.equalsIgnoreCase("min")) {
                return units / 525960;
            } else if (from.equalsIgnoreCase("hr")) {
                return units / 8766;
            } else if (from.equalsIgnoreCase("d")) {
                return units / 365;
            } else if (from.equalsIgnoreCase("w")) {
                return units / 52;
            } else if (from.equalsIgnoreCase("m")) {
                return units / 12;
            } else if (from.equalsIgnoreCase("yr")) {
                return units;
            }
            return -1;
        }
    }

    static class LengthUnits {
        private LengthUnits() {
        }

        static double inches(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units * 25.4;
            } else if (from.equalsIgnoreCase("dm")) {
                return units * 0.254;
            } else if (from.equalsIgnoreCase("cm")) {
                return units * 2.54;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 0.0254;
            } else if (from.equalsIgnoreCase("km")) {
                return units * 0.0000254;
            } else if (from.equalsIgnoreCase("in")) {
                return units;
            } else if (from.equalsIgnoreCase("ft")) {
                return units * 0.08333333;
            } else if (from.equalsIgnoreCase("yd")) {
                return units * 0.02777778;
            } else if (from.equalsIgnoreCase("mi")) {
                return units * 0.00001578283;
            }
            return -1;
        }

        static double feet(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units * 304.8;
            } else if (from.equalsIgnoreCase("dm")) {
                return units * 3.048;
            } else if (from.equalsIgnoreCase("cm")) {
                return units * 30.48;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 0.3048;
            } else if (from.equalsIgnoreCase("km")) {
                return units * 0.0003048;
            } else if (from.equalsIgnoreCase("in")) {
                return units * 12;
            } else if (from.equalsIgnoreCase("ft")) {
                return units;
            } else if (from.equalsIgnoreCase("yd")) {
                return units * 0.3333333;
            } else if (from.equalsIgnoreCase("mi")) {
                return units * 0.0001893939;
            }
            return -1;
        }

        static double yards(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units * 914.4;
            } else if (from.equalsIgnoreCase("dm")) {
                return units * 9.144;
            } else if (from.equalsIgnoreCase("cm")) {
                return units * 91.44;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 0.9144;
            } else if (from.equalsIgnoreCase("km")) {
                return units * 0.0009144;
            } else if (from.equalsIgnoreCase("in")) {
                return units * 36;
            } else if (from.equalsIgnoreCase("ft")) {
                return units * 3;
            } else if (from.equalsIgnoreCase("yd")) {
                return units;
            } else if (from.equalsIgnoreCase("mi")) {
                return units * 0.0005681818;
            }
            return -1;
        }

        static double miles(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units / 1609344;
            } else if (from.equalsIgnoreCase("dm")) {
                return units / 16093.44;
            } else if (from.equalsIgnoreCase("cm")) {
                return units / 160934.4;
            } else if (from.equalsIgnoreCase("m")) {
                return units / 1609.344;
            } else if (from.equalsIgnoreCase("km")) {
                return units / 1.609344;
            } else if (from.equalsIgnoreCase("in")) {
                return units / 63360;
            } else if (from.equalsIgnoreCase("ft")) {
                return units / 5280;
            } else if (from.equalsIgnoreCase("yd")) {
                return units / 1760;
            } else if (from.equalsIgnoreCase("mi")) {
                return units;
            }
            return -1;
        }

        static double decimeters(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units * 100;
            } else if (from.equalsIgnoreCase("dm")) {
                return units;
            } else if (from.equalsIgnoreCase("cm")) {
                return units * 10;
            } else if (from.equalsIgnoreCase("m")) {
                return units / 10;
            } else if (from.equalsIgnoreCase("km")) {
                return units / 1000;
            } else if (from.equalsIgnoreCase("in")) {
                return units * 3.937008;
            } else if (from.equalsIgnoreCase("ft")) {
                return units * 0.328084;
            } else if (from.equalsIgnoreCase("yd")) {
                return units * 0.10936133120002;
            } else if (from.equalsIgnoreCase("mi")) {
                return units * 0.00006213712;
            }
            return -1;
        }

        static double millimeters(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units;
            } else if (from.equalsIgnoreCase("dm")) {
                return units / 100.0;
            } else if (from.equalsIgnoreCase("cm")) {
                return units / 10.0;
            } else if (from.equalsIgnoreCase("m")) {
                return units / 1000.0;
            } else if (from.equalsIgnoreCase("km")) {
                return units / 1000000;
            } else if (from.equalsIgnoreCase("in")) {
                return units * 0.03937008;
            } else if (from.equalsIgnoreCase("ft")) {
                return units * 0.00328084;
            } else if (from.equalsIgnoreCase("yd")) {
                return units * 0.0010936133333;
            } else if (from.equalsIgnoreCase("mi")) {
                return units * 0.0000006213712121022726;
            }
            return -1;
        }

        static double centimeters(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units * 10;
            } else if (from.equalsIgnoreCase("dm")) {
                return units / 10;
            } else if (from.equalsIgnoreCase("cm")) {
                return units;
            } else if (from.equalsIgnoreCase("m")) {
                return units / 100.0;
            } else if (from.equalsIgnoreCase("km")) {
                return units / 100000;
            } else if (from.equalsIgnoreCase("in")) {
                return units * 0.3937008;
            } else if (from.equalsIgnoreCase("ft")) {
                return units * 0.0328084;
            } else if (from.equalsIgnoreCase("yd")) {
                return units * 0.01093613;
            } else if (from.equalsIgnoreCase("mi")) {
                return units * 0.000006213712;
            }
            return -1;
        }

        static double meters(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units * 1000;
            } else if (from.equalsIgnoreCase("dm")) {
                return units * 10;
            } else if (from.equalsIgnoreCase("cm")) {
                return units * 100;
            } else if (from.equalsIgnoreCase("m")) {
                return units;
            } else if (from.equalsIgnoreCase("km")) {
                return units / 1000;
            } else if (from.equalsIgnoreCase("in")) {
                return units * 39.4;
            } else if (from.equalsIgnoreCase("ft")) {
                return units * 3.3;
            } else if (from.equalsIgnoreCase("yd")) {
                return units * 1.1;
            } else if (from.equalsIgnoreCase("mi")) {
                return units * 0.0006213712;
            }
            return -1;
        }

        static double kilometers(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units * 100000;
            } else if (from.equalsIgnoreCase("dm")) {
                return units * 1000;
            } else if (from.equalsIgnoreCase("cm")) {
                return units * 10000;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 1000;
            } else if (from.equalsIgnoreCase("km")) {
                return units;
            } else if (from.equalsIgnoreCase("in")) {
                return units * 39370.08;
            } else if (from.equalsIgnoreCase("ft")) {
                return units * 3280.8;
            } else if (from.equalsIgnoreCase("yd")) {
                return units * 1093.6;
            } else if (from.equalsIgnoreCase("mi")) {
                return units * 0.6213712;
            }
            return -1;
        }
    }

    static class MassUnits {
        private MassUnits() {
        }

    }
}
