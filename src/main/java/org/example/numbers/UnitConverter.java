package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.EnumSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;
import static org.example.numbers.UnitConverter.DurationUnits.*;
import static org.example.numbers.UnitConverter.LengthUnits.*;

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
                    result = convertLength(console);
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
        double units = Double.parseDouble(console.next());
        out.println();

        out.println("Choose a Converting Duration: [M]illisecond[s], [Sec]onds, [Min]utes, [H]ou[r]s, [D]ays, [W]eeks, [M]onths, [Y]ea[r]s");
        String to = console.next();
        out.println();

        switch (to.toLowerCase()) {
            case "ms":
                result = milliSeconds(from, units);
                to = Durations.MILLISECOND.name().toLowerCase();
                break;
            case "sec":
                result = seconds(from, units);
                to = Durations.SECOND.name().toLowerCase();
                break;
            case "min":
                result = minutes(from, units);
                to = Durations.MINUTE.name().toLowerCase();
                break;
            case "hr":
                result = hours(from, units);
                to = Durations.HOUR.name().toLowerCase();
                break;
            case "d":
                result = days(from, units);
                to = Durations.DAY.name().toLowerCase();
                break;
            case "w":
                result = weeks(from, units);
                to = Durations.WEEK.name().toLowerCase();
                break;
            case "m":
                result = months(from, units);
                to = Durations.MONTH.name().toLowerCase();
                break;
            case "yr":
                result = years(from, units);
                to = Durations.YEAR.name().toLowerCase();
                break;
            default:
                throw new IllegalArgumentException(from + " is not a valid input!");
        }
        double roundedResult = NumberConstants.roundedValues(result);
        out.printf("%.2f %s(s) = %.2f %s(s).%n", units, getDurationFrom(from), roundedResult, to);
        return roundedResult;
    }

    private static String getDurationFrom(String from) {
        return EnumSet.allOf(Durations.class).stream()
                .filter(d -> from.equalsIgnoreCase(d.getAbbreviation()))
                .findFirst()
                .map(d -> d.name().toLowerCase()).orElse(from);
    }

    private static double convertLength(Scanner console) {
        double result = 0;

        out.println("Choose a Length: [M]illi[m]eters, [C]enti[m]eters, [In]ches, [F]ee[t], [M]eters, [Y]ar[d]s, [K]ilo[m]eters, [Mi]les");
        String from = console.next();
        out.println();

        out.println("How many units?: ");
        double units = Double.parseDouble(console.next());
        out.println();

        out.println("Choose a Converting Length: [M]illi[m]eters, [C]enti[m]eters, [In]ches, [F]ee[t], [M]eters, [Y]ar[d]s, [K]ilo[m]eters, [Mi]les");
        String to = console.next();
        out.println();

        switch (to.toLowerCase()) {
            case "mm":
                to = Lengths.MILLIMETER.name().toLowerCase();
                result = millimeters(from, units);
                break;
            case "cm":
                to = Lengths.CENTIMETER.name().toLowerCase();
                result = centimeters(from, units);
                break;
            case "in":
                to = Lengths.INCH.name().toLowerCase();
                result = inches(from, units);
                break;
            case "ft":
                to = Lengths.FEET.name().toLowerCase();
                result = feet(from, units);
                break;
            case "yd":
                to = Lengths.YARD.name().toLowerCase();
                result = yards(from, units);
                break;
            case "m":
                to = Lengths.METER.name().toLowerCase();
                result = meters(from, units);
                break;
            case "km":
                to = Lengths.KILOMETER.name().toLowerCase();
                result = kilometers(from, units);
                break;
            case "mi":
                to = Lengths.MILE.name().toLowerCase();
                result = miles(from, units);
                break;
            default:
                throw new IllegalArgumentException(from + " is not a valid input!");
        }
        double roundedResult = NumberConstants.roundedValues(result);
        out.printf("%.2f %s(s) = %.2f %s(s).%n", units, getLengthFrom(from), roundedResult, to);
        return roundedResult;
    }

    private static String getLengthFrom(String from) {
        return EnumSet.allOf(Lengths.class).stream()
                .filter(d -> from.equalsIgnoreCase(d.getAbbreviation()))
                .findFirst()
                .map(d -> d.name().toLowerCase()).orElse(from);
    }

    static class DurationUnits {
        enum Durations {
            MILLISECOND("ms"),
            SECOND("sec"),
            MINUTE("min"),
            HOUR("hr"),
            DAY("d"),
            WEEK("wk"),
            MONTH("m"),
            YEAR("yr");

            private final String abbreviation;

            Durations(String abbreviation) {
                this.abbreviation = abbreviation;
            }

            public String getAbbreviation() {
                return this.abbreviation;
            }
        }
        private DurationUnits() {
        }

        static double milliSeconds(String from, double units) {
            if (from.equalsIgnoreCase("ms")) {
                return units;
            } else if (from.equalsIgnoreCase("sec")) {
                return units * 1000.0;
            } else if (from.equalsIgnoreCase("min")) {
                return units * 1000.0 * 60;
            } else if (from.equalsIgnoreCase("hr")) {
                return units * 1000.0 * 3600;
            } else if (from.equalsIgnoreCase("d")) {
                return units * 1000.0 * 3600 * 24;
            } else if (from.equalsIgnoreCase("w")) {
                return units * 1000.0 * 3600 * 24 * 7;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 2629800000.0;
            } else if (from.equalsIgnoreCase("yr")) {
                return units * 31557600000.0;
            }
            return -1;
        }

        static double seconds(String from, double units) {
            if (from.equalsIgnoreCase("ms")) {
                return units / 1000.0;
            } else if (from.equalsIgnoreCase("sec")) {
                return units;
            } else if (from.equalsIgnoreCase("min")) {
                return units * 60.0;
            } else if (from.equalsIgnoreCase("hr")) {
                return units * 3600.0;
            } else if (from.equalsIgnoreCase("d")) {
                return units * 3600 * 24.0;
            } else if (from.equalsIgnoreCase("w")) {
                return units * 3600 * 24 * 7.0;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 2629800.0;
            } else if (from.equalsIgnoreCase("yr")) {
                return units * 31557600.0;
            }
            return -1;
        }

        static double minutes(String from, double units) {
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

        static double hours(String from, double units) {
            if (from.equalsIgnoreCase("ms")) {
                return units / 3600000.0;
            } else if (from.equalsIgnoreCase("sec")) {
                return units / 3600.0;
            } else if (from.equalsIgnoreCase("min")) {
                return units / 60.0;
            } else if (from.equalsIgnoreCase("hr")) {
                return units;
            } else if (from.equalsIgnoreCase("d")) {
                return units * 24.0;
            } else if (from.equalsIgnoreCase("w")) {
                return units * 24 * 7.0;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 731.0;
            } else if (from.equalsIgnoreCase("yr")) {
                return units * 8766.0;
            }
            return -1;
        }

        static double days(String from, double units) {
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

        static double weeks(String from, double units) {
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

        static double months(String from, double units) {
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

        static double years(String from, double units) {
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
        enum Lengths {
            MILLIMETER("mm"),
            CENTIMETER("cm"),
            INCH("in"),
            FEET("ft"),
            YARD("yd"),
            METER("m"),
            KILOMETER("km"),
            MILE("mi");

            private final String abbreviation;

            Lengths(String abbreviation) {
                this.abbreviation = abbreviation;
            }

            public String getAbbreviation() {
                return this.abbreviation;
            }
        }

        private LengthUnits() {
        }

        static double millimeters(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units;
            } else if (from.equalsIgnoreCase("cm")) {
                return units * 10.0;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 1000.0;
            } else if (from.equalsIgnoreCase("km")) {
                return units * 1000000;
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
                return units / 10;
            } else if (from.equalsIgnoreCase("cm")) {
                return units;
            } else if (from.equalsIgnoreCase("m")) {
                return units / 100.0;
            } else if (from.equalsIgnoreCase("km")) {
                return units / 100000;
            } else if (from.equalsIgnoreCase("in")) {
                return units / 0.3937008;
            } else if (from.equalsIgnoreCase("ft")) {
                return units / 0.0328084;
            } else if (from.equalsIgnoreCase("yd")) {
                return units / 0.01093613;
            } else if (from.equalsIgnoreCase("mi")) {
                return units / 0.000006213712;
            }
            return -1;
        }

        static double inches(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units / 25.4;
            } else if (from.equalsIgnoreCase("cm")) {
                return units / 2.54;
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
                return units / 304.8;
            } else if (from.equalsIgnoreCase("cm")) {
                return units / 30.48;
            } else if (from.equalsIgnoreCase("m")) {
                return units / 0.3048;
            } else if (from.equalsIgnoreCase("km")) {
                return units / 0.0003048;
            } else if (from.equalsIgnoreCase("in")) {
                return units / 12;
            } else if (from.equalsIgnoreCase("ft")) {
                return units;
            } else if (from.equalsIgnoreCase("yd")) {
                return units / 0.3333333;
            } else if (from.equalsIgnoreCase("mi")) {
                return units / 0.0001893939;
            }
            return -1;
        }

        static double yards(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units / 914.4;
            } else if (from.equalsIgnoreCase("cm")) {
                return units / 91.44;
            } else if (from.equalsIgnoreCase("m")) {
                return units / 0.9144;
            } else if (from.equalsIgnoreCase("km")) {
                return units / 0.0009144;
            } else if (from.equalsIgnoreCase("in")) {
                return units / 36;
            } else if (from.equalsIgnoreCase("ft")) {
                return units / 3;
            } else if (from.equalsIgnoreCase("yd")) {
                return units;
            } else if (from.equalsIgnoreCase("mi")) {
                return units / 0.0005681818;
            }
            return -1;
        }

        static double meters(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units / 1000;
            } else if (from.equalsIgnoreCase("cm")) {
                return units / 100;
            } else if (from.equalsIgnoreCase("m")) {
                return units;
            } else if (from.equalsIgnoreCase("km")) {
                return units / 1000;
            } else if (from.equalsIgnoreCase("in")) {
                return units / 39.37008;
            } else if (from.equalsIgnoreCase("ft")) {
                return units / 3.28084;
            } else if (from.equalsIgnoreCase("yd")) {
                return units / 1.093613;
            } else if (from.equalsIgnoreCase("mi")) {
                return units / 0.0006213712;
            }
            return -1;
        }

        static double kilometers(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units / 1000000;
            } else if (from.equalsIgnoreCase("cm")) {
                return units / 100000;
            } else if (from.equalsIgnoreCase("m")) {
                return units / 1000;
            } else if (from.equalsIgnoreCase("km")) {
                return units;
            } else if (from.equalsIgnoreCase("in")) {
                return units / 39370.08;
            } else if (from.equalsIgnoreCase("ft")) {
                return units / 3280.84;
            } else if (from.equalsIgnoreCase("yd")) {
                return units / 1093.613;
            } else if (from.equalsIgnoreCase("mi")) {
                return units / 0.6213712;
            }
            return -1;
        }

        static double miles(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units / 1609344;
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
    }

    static class MassUnits {
        private MassUnits() {
        }

    }
}
