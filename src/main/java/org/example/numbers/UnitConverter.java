package org.example.numbers;

import org.example.common.NumberConstants;
import org.example.numbers.UnitConverter.TemperatureUnits.*;

import java.util.EnumSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;
import static org.example.numbers.UnitConverter.CurrencyUnits.*;
import static org.example.numbers.UnitConverter.CurrencyUnits.Currency.*;
import static org.example.numbers.UnitConverter.DigitalStorageUnits.*;
import static org.example.numbers.UnitConverter.DurationUnits.*;
import static org.example.numbers.UnitConverter.FrequencyUnits.Frequency.*;
import static org.example.numbers.UnitConverter.FrequencyUnits.*;
import static org.example.numbers.UnitConverter.LengthUnits.*;
import static org.example.numbers.UnitConverter.MassUnits.*;
import static org.example.numbers.UnitConverter.SpeedUnits.*;
import static org.example.numbers.UnitConverter.SpeedUnits.Speed.*;
import static org.example.numbers.UnitConverter.TemperatureUnits.*;
import static org.example.numbers.UnitConverter.VolumeUnits.*;

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
            out.print("Choose a measurement: [T]ime, [L]ength, [M]ass, [Temp]erature, [V]olume, [S]peed, [F]requency, [D]igital [S]torage, [C]urrency");
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
                    result = convertMass(console);
                    break;
                case "TEMP":
                    result = convertTemperature(console);
                    break;
                case "C":
                    result = convertCurrency(console);
                    break;
                case "V":
                    result = convertVolume(console);
                    break;
                case "DS":
                    result = convertDigitalStorage(console);
                    break;
                case "S":
                    result = convertSpeed(console);
                    break;
                case "F":
                    result = convertFrequency(console);
                    break;
                default:
                    throw new IllegalArgumentException("Error! \"" + choice + "\" does not fit the criteria.");
            }
            return result;
        } catch (InputMismatchException | IllegalArgumentException e) {
            err.println("Unable to process the unit: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            err.printf("%nAn Exception (%s) occurred while completing the action: %s%n", e.getClass().getSimpleName(), e.getMessage());
            throw e;
        }
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
            if (from.equalsIgnoreCase("sec")) {
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
            return units;
        }

        static double seconds(String from, double units) {
            if (from.equalsIgnoreCase("ms")) {
                return units / 1000.0;
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
            return units;
        }

        static double minutes(String from, double units) {
            if (from.equalsIgnoreCase("ms")) {
                return units / 60000.0;
            } else if (from.equalsIgnoreCase("sec")) {
                return units / 60.0;
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
            return units;
        }

        static double hours(String from, double units) {
            if (from.equalsIgnoreCase("ms")) {
                return units / 3600000.0;
            } else if (from.equalsIgnoreCase("sec")) {
                return units / 3600.0;
            } else if (from.equalsIgnoreCase("min")) {
                return units / 60.0;
            } else if (from.equalsIgnoreCase("d")) {
                return units * 24.0;
            } else if (from.equalsIgnoreCase("w")) {
                return units * 24 * 7.0;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 731.0;
            } else if (from.equalsIgnoreCase("yr")) {
                return units * 8766.0;
            }
            return units;
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
            } else if (from.equalsIgnoreCase("w")) {
                return units * 7;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 30;
            } else if (from.equalsIgnoreCase("yr")) {
                return units * 365;
            }
            return units;
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
            } else if (from.equalsIgnoreCase("m")) {
                return units * 4;
            } else if (from.equalsIgnoreCase("yr")) {
                return units * 52;
            }
            return units;
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
            } else if (from.equalsIgnoreCase("yr")) {
                return units * 12;
            }
            return units;
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
            }
            return units;
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
            if (from.equalsIgnoreCase("cm")) {
                return units * 10.0;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 1000.0;
            } else if (from.equalsIgnoreCase("km")) {
                return units * 1000000;
            } else if (from.equalsIgnoreCase("in")) {
                return units / 0.03937008;
            } else if (from.equalsIgnoreCase("ft")) {
                return units / 0.00328084;
            } else if (from.equalsIgnoreCase("yd")) {
                return units / 0.0010936133333;
            } else if (from.equalsIgnoreCase("mi")) {
                return units / 0.0000006213712121022726;
            }
            return units;
        }

        static double centimeters(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units / 10;
            } else if (from.equalsIgnoreCase("m")) {
                return units * 100.0;
            } else if (from.equalsIgnoreCase("km")) {
                return units * 100000;
            } else if (from.equalsIgnoreCase("in")) {
                return units / 0.3937008;
            } else if (from.equalsIgnoreCase("ft")) {
                return units / 0.0328084;
            } else if (from.equalsIgnoreCase("yd")) {
                return units / 0.01093613;
            } else if (from.equalsIgnoreCase("mi")) {
                return units / 0.000006213712;
            }
            return units;
        }

        static double inches(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units / 25.4;
            } else if (from.equalsIgnoreCase("cm")) {
                return units / 2.54;
            } else if (from.equalsIgnoreCase("m")) {
                return units / 0.0254;
            } else if (from.equalsIgnoreCase("km")) {
                return units / 0.0000254;
            } else if (from.equalsIgnoreCase("ft")) {
                return units * 0.08333333;
            } else if (from.equalsIgnoreCase("yd")) {
                return units / 0.02777778;
            } else if (from.equalsIgnoreCase("mi")) {
                return units / 0.00001578283;
            }
            return units;
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
            } else if (from.equalsIgnoreCase("yd")) {
                return units / 0.3333333;
            } else if (from.equalsIgnoreCase("mi")) {
                return units / 0.0001893939;
            }
            return units;
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
            } else if (from.equalsIgnoreCase("mi")) {
                return units / 0.0005681818;
            }
            return units;
        }

        static double meters(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units / 1000;
            } else if (from.equalsIgnoreCase("cm")) {
                return units / 100;
            } else if (from.equalsIgnoreCase("km")) {
                return units / 0.001;
            } else if (from.equalsIgnoreCase("in")) {
                return units / 39.37008;
            } else if (from.equalsIgnoreCase("ft")) {
                return units / 3.28084;
            } else if (from.equalsIgnoreCase("yd")) {
                return units / 1.093613;
            } else if (from.equalsIgnoreCase("mi")) {
                return units / 0.0006213712;
            }
            return units;
        }

        static double kilometers(String from, double units) {
            if (from.equalsIgnoreCase("mm")) {
                return units / 1000000;
            } else if (from.equalsIgnoreCase("cm")) {
                return units / 100000;
            } else if (from.equalsIgnoreCase("m")) {
                return units / 1000;
            } else if (from.equalsIgnoreCase("in")) {
                return units / 39370.08;
            } else if (from.equalsIgnoreCase("ft")) {
                return units / 3280.84;
            } else if (from.equalsIgnoreCase("yd")) {
                return units / 1093.613;
            } else if (from.equalsIgnoreCase("mi")) {
                return units / 0.6213712;
            }
            return units;
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
            }
            return units;
        }
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


    static class MassUnits {
        enum Mass {
            MILLIGRAM("mg"),
            GRAM("g"),
            OUNCE("oz"),
            POUND("lb"),
            KILOGRAM("kg"),
            TON("t");

            private final String abbreviation;

            Mass(String abbreviation) {
                this.abbreviation = abbreviation;
            }

            public String getAbbreviation() {
                return this.abbreviation;
            }
        }

        private MassUnits() {
        }

        static double milligram(String from, double units) {
            if (from.equalsIgnoreCase("g")) {
                return units * 1000;
            } else if (from.equalsIgnoreCase("oz")) {
                return units * 28349.52;
            } else if (from.equalsIgnoreCase("lb")) {
                return units * 453592.3201;
            } else if (from.equalsIgnoreCase("kg")) {
                return units * 1000000;
            } else if (from.equalsIgnoreCase("t")) {
                return units * 907184700;
            }
            return units;
        }

        static double gram(String from, double units) {
            if (from.equalsIgnoreCase("mg")) {
                return units / 1000;
            } else if (from.equalsIgnoreCase("oz")) {
                return units / 0.03527396;
            } else if (from.equalsIgnoreCase("lb")) {
                return units / 0.002204623;
            } else if (from.equalsIgnoreCase("kg")) {
                return units / 0.001;
            } else if (from.equalsIgnoreCase("t")) {
                return units / 0.000001102311;
            }
            return units;
        }

        static double ounce(String from, double units) {
            if (from.equalsIgnoreCase("mg")) {
                return units / 28349.52;
            } else if (from.equalsIgnoreCase("g")) {
                return units / 28.34952;
            } else if (from.equalsIgnoreCase("lb")) {
                return units / 0.0625;
            } else if (from.equalsIgnoreCase("kg")) {
                return units / 0.02834952;
            } else if (from.equalsIgnoreCase("t")) {
                return units / 0.00003125;
            }
            return units;
        }

        static double pound(String from, double units) {
            if (from.equalsIgnoreCase("mg")) {
                return units / 453592.4;
            } else if (from.equalsIgnoreCase("g")) {
                return units / 453.5924;
            } else if (from.equalsIgnoreCase("oz")) {
                return units / 16;
            } else if (from.equalsIgnoreCase("kg")) {
                return units / 0.4535924;
            } else if (from.equalsIgnoreCase("t")) {
                return units / 0.0005;
            }
            return units;
        }

        static double kilogram(String from, double units) {
            if (from.equalsIgnoreCase("mg")) {
                return units / 1000000;
            } else if (from.equalsIgnoreCase("g")) {
                return units / 1000;
            } else if (from.equalsIgnoreCase("oz")) {
                return units / 35.27396;
            } else if (from.equalsIgnoreCase("lb")) {
                return units / 2.20462249;
            } else if (from.equalsIgnoreCase("t")) {
                return units / 0.001102311;
            }
            return units;
        }

        static double ton(String from, double units) {
            if (from.equalsIgnoreCase("mg")) {
                return units / 907184700;
            } else if (from.equalsIgnoreCase("g")) {
                return units / 907184.7;
            } else if (from.equalsIgnoreCase("oz")) {
                return units / 32000;
            } else if (from.equalsIgnoreCase("lb")) {
                return units / 2000;
            } else if (from.equalsIgnoreCase("kg")) {
                return units / 907.1847;
            }
            return units;
        }
    }

    private static double convertMass(Scanner console) {
        double result = 0;

        out.println("Choose a Mass: [M]illi[g]ram, [G]ram, [O]unce([z]), Pound([lb]), [K]ilo[g]ram, [T]on");
        String from = console.next();
        out.println();

        out.println("How many units?: ");
        double units = Double.parseDouble(console.next());
        out.println();

        out.println("Choose a converting Mass: [M]illi[g]ram, [G]ram, [O]unce([z]), Pound([lb]), [K]ilo[g]ram, [T]on");
        String to = console.next();
        out.println();

        switch (to.toLowerCase()) {
            case "mg":
                to = Mass.MILLIGRAM.name().toLowerCase();
                result = milligram(from, units);
                break;
            case "g":
                to = Mass.GRAM.name().toLowerCase();
                result = gram(from, units);
                break;
            case "oz":
                to = Mass.OUNCE.name().toLowerCase();
                result = ounce(from, units);
                break;
            case "lb":
                to = Mass.POUND.name().toLowerCase();
                result = pound(from, units);
                break;
            case "kg":
                to = Mass.KILOGRAM.name().toLowerCase();
                result = kilogram(from, units);
                break;
            case "t":
                to = Mass.TON.name().toLowerCase();
                result = ton(from, units);
                break;
            default:
                throw new IllegalArgumentException(from + " is not a valid input!");
        }
        double roundedResult = NumberConstants.roundedValues(result);
        out.printf("%.2f %s(s) = %.2f %s(s).%n", units, getMassFrom(from), roundedResult, to);
        return roundedResult;
    }

    private static String getMassFrom(String from) {
        return EnumSet.allOf(Mass.class).stream()
                .filter(d -> from.equalsIgnoreCase(d.getAbbreviation()))
                .findFirst()
                .map(d -> d.name().toLowerCase()).orElse(from);
    }


    static class TemperatureUnits {
        enum Temperature {
            FAHRENHEIT("F"),
            CELSIUS("C"),
            KELVIN("K");

            private final String abbreviation;

            Temperature(String abbreviation) {
                this.abbreviation = abbreviation;
            }

            public String getAbbreviation() {
                return this.abbreviation;
            }
        }

        private TemperatureUnits() {
        }

        static double celsius(String from, double units) {
            if (from.equalsIgnoreCase("f")) {
                return (units - 32) * (5.0 / 9.0);
            } else if (from.equalsIgnoreCase("k")) {
                return units - 273.15;
            }
            return units;
        }

        static double fahrenheit(String from, double units) {
            if (from.equalsIgnoreCase("c")) {
                return (units * 1.8) + 32;
            } else if (from.equalsIgnoreCase("k")) {
                return (units * (9.0 / 5.0)) - 459.67;
            }
            return units;
        }

        static double kelvin(String from, double units) {
            if (from.equalsIgnoreCase("c")) {
                return units + 273.15;
            } else if (from.equalsIgnoreCase("f")) {
                return (units + 459.67) * (5.0 / 9.0);
            }
            return units;
        }
    }

    private static double convertTemperature(Scanner console) {
        double result = 0;

        out.println("Choose a Temp: [C]elsius, [F]ahrenheit, or [K]elvin");
        String from = console.next();
        out.println();

        out.println("How many units?: ");
        double units = Double.parseDouble(console.next());
        out.println();

        out.println("Choose a converting Temp: [C]elsius, [F]ahrenheit, or [K]elvin");
        String to = console.next();
        out.println();

        switch (to.toLowerCase()) {
            case "c":
                to = "°" + Temperature.CELSIUS.getAbbreviation();
                result = celsius(from, units);
                break;
            case "f":
                to = "°" + Temperature.FAHRENHEIT.getAbbreviation();
                result = fahrenheit(from, units);
                break;
            case "k":
                to = Temperature.KELVIN.getAbbreviation();
                result = kelvin(from, units);
                break;
            default:
                throw new IllegalArgumentException(from + " is not a valid input!");
        }
        double roundedResult = NumberConstants.roundedCurrencyValue(result);
        out.printf("%.2f%s = %.2f%s%n", units, getTemperatureFrom(from), roundedResult, to);
        return roundedResult;
    }

    private static String getTemperatureFrom(String from) {
        return EnumSet.allOf(Temperature.class).stream()
                .filter(d -> from.equalsIgnoreCase(d.getAbbreviation()))
                .findFirst()
                .map(d -> "°" + d.getAbbreviation()).orElse("°" + from);
    }


    static class VolumeUnits {
        enum Volume {
            MILLILITER("ml"),
            TEASPOON("tsp"),
            TABLESPOON("tbsp"),
            CUP("cup"),
            FLUID_OUNCE("fl.oz"),
            PINT("pt"),
            QUART("qt"),
            LITER("l"),
            GALLON("gal");

            private final String abbreviation;

            Volume(String abbreviation) {
                this.abbreviation = abbreviation;
            }

            public String getAbbreviation() {
                return this.abbreviation;
            }
        }

        private VolumeUnits() {
        }

        static double milliliter(String from, double units) {
            if (from.equalsIgnoreCase("tsp")) {
                return units * 4.92892;
            } else if (from.equalsIgnoreCase("tbsp")) {
                return units * 14.7868;
            } else if (from.equalsIgnoreCase("fl.oz")) {
                return units * 29.57344;
            } else if (from.equalsIgnoreCase("cup")) {
                return units * 240;
            } else if (from.equalsIgnoreCase("pt")) {
                return units * 473.1765;
            } else if (from.equalsIgnoreCase("qt")) {
                return units * 946.353;
            } else if (from.equalsIgnoreCase("l")) {
                return units * 1000;
            } else if (from.equalsIgnoreCase("gal")) {
                return units * 3785.4;
            }
            return units;
        }

        static double teaspoon(String from, double units) {
            if (from.equalsIgnoreCase("ml")) {
                return units * 0.2028842;
            } else if (from.equalsIgnoreCase("tbsp")) {
                return units * 3.000008;
            } else if (from.equalsIgnoreCase("fl.oz")) {
                return units * 5.999983;
            } else if (from.equalsIgnoreCase("cup")) {
                return units * 48.69221;
            } else if (from.equalsIgnoreCase("pt")) {
                return units * 96;
            } else if (from.equalsIgnoreCase("qt")) {
                return units * 192;
            } else if (from.equalsIgnoreCase("l")) {
                return units * 202.88;
            } else if (from.equalsIgnoreCase("gal")) {
                return units * 767.9979;
            }
            return units;
        }

        static double tablespoon(String from, double units) {
            if (from.equalsIgnoreCase("ml")) {
                return units * 0.06762788;
            } else if (from.equalsIgnoreCase("tsp")) {
                return units * 0.3333324;
            } else if (from.equalsIgnoreCase("fl.oz")) {
                return units * 1.999989;
            } else if (from.equalsIgnoreCase("cup")) {
                return units * 16.23069;
            } else if (from.equalsIgnoreCase("pt")) {
                return units * 31.99993;
            } else if (from.equalsIgnoreCase("qt")) {
                return units * 63.99985;
            } else if (from.equalsIgnoreCase("l")) {
                return units * 67.62788;
            } else if (from.equalsIgnoreCase("gal")) {
                return units * 255.9986;
            }
            return units;
        }

        static double fluidOunce(String from, double units) {
            if (from.equalsIgnoreCase("ml")) {
                return units * 0.03381412154;
            } else if (from.equalsIgnoreCase("tsp")) {
                return units * 0.1666671;
            } else if (from.equalsIgnoreCase("tbsp")) {
                return units * 0.5000027;
            } else if (from.equalsIgnoreCase("cup")) {
                return units * 8.115391;
            } else if (from.equalsIgnoreCase("pt")) {
                return units * 16.005;
            } else if (from.equalsIgnoreCase("qt")) {
                return units * 32.001;
            } else if (from.equalsIgnoreCase("l")) {
                return units * 33.81413;
            } else if (from.equalsIgnoreCase("gal")) {
                return units * 128;
            }
            return units;
        }

        static double cup(String from, double units) {
            if (from.equalsIgnoreCase("ml")) {
                return units * 0.00416666708;
            } else if (from.equalsIgnoreCase("tsp")) {
                return units * 0.020537168704;
            } else if (from.equalsIgnoreCase("tbsp")) {
                return units * 0.0616116727786857;
            } else if (from.equalsIgnoreCase("fl.oz")) {
                return units * 0.123222668473971;
            } else if (from.equalsIgnoreCase("pt")) {
                return units * 1.971569;
            } else if (from.equalsIgnoreCase("qt")) {
                return units * 3.9431378911683117;
            } else if (from.equalsIgnoreCase("l")) {
                return units * 4.166667080009586;
            } else if (from.equalsIgnoreCase("gal")) {
                return units * 15.772501564668286;
            }
            return units;
        }

        static double pint(String from, double units) {
            if (from.equalsIgnoreCase("ml")) {
                return units * 0.002113376;
            } else if (from.equalsIgnoreCase("tsp")) {
                return units * 0.01041666;
            } else if (from.equalsIgnoreCase("tbsp")) {
                return units * 0.03125007;
            } else if (from.equalsIgnoreCase("fl.oz")) {
                return units * 0.06249980125;
            } else if (from.equalsIgnoreCase("cup")) {
                return units * 0.5072103;
            } else if (from.equalsIgnoreCase("qt")) {
                return units * 2;
            } else if (from.equalsIgnoreCase("l")) {
                return units * 2.113376;
            } else if (from.equalsIgnoreCase("gal")) {
                return units * 7.999975;
            }
            return units;
        }

        static double quart(String from, double units) {
            if (from.equalsIgnoreCase("ml")) {
                return units * 0.00105668839745824;
            } else if (from.equalsIgnoreCase("tsp")) {
                return units * 0.005208332576;
            } else if (from.equalsIgnoreCase("tbsp")) {
                return units * 0.01562504;
            } else if (from.equalsIgnoreCase("fl.oz")) {
                return units * 0.0312499;
            } else if (from.equalsIgnoreCase("cup")) {
                return units * 0.2536052;
            } else if (from.equalsIgnoreCase("pt")) {
                return units * 0.5;
            } else if (from.equalsIgnoreCase("l")) {
                return units * 1.056688;
            } else if (from.equalsIgnoreCase("gal")) {
                return units * 3.999987;
            }
            return units;
        }

        static double liter(String from, double units) {
            if (from.equalsIgnoreCase("ml")) {
                return units * 0.001;
            } else if (from.equalsIgnoreCase("tsp")) {
                return units * 0.00492892;
            } else if (from.equalsIgnoreCase("tbsp")) {
                return units * 0.0147868;
            } else if (from.equalsIgnoreCase("fl.oz")) {
                return units * 0.02957344;
            } else if (from.equalsIgnoreCase("cup")) {
                return units * 0.2400000204;
            } else if (from.equalsIgnoreCase("pt")) {
                return units * 0.47317654022;
            } else if (from.equalsIgnoreCase("qt")) {
                return units * 0.94635308044;
            } else if (from.equalsIgnoreCase("gal")) {
                return units * 3.7854003218;
            }
            return units;
        }

        static double gallon(String from, double units) {
            if (from.equalsIgnoreCase("ml")) {
                return units * 0.0002641729;
            } else if (from.equalsIgnoreCase("tsp")) {
                return units * 0.001302087;
            } else if (from.equalsIgnoreCase("tbsp")) {
                return units * 0.003906271;
            } else if (from.equalsIgnoreCase("fl.oz")) {
                return units * 0.0078125;
            } else if (from.equalsIgnoreCase("cup")) {
                return units * 0.06340149;
            } else if (from.equalsIgnoreCase("pt")) {
                return units * 0.1250004;
            } else if (from.equalsIgnoreCase("qt")) {
                return units * 0.2500008;
            } else if (from.equalsIgnoreCase("l")) {
                return units * 0.2641729;
            }
            return units;
        }

    }

    private static String getVolumeFrom(String from) {
        return EnumSet.allOf(Volume.class).stream()
                .filter(d -> from.equalsIgnoreCase(d.getAbbreviation()))
                .findFirst()
                .map(d -> d.name().toLowerCase()).orElse(from);
    }

    private static double convertVolume(Scanner console) {
        double result = 0;

        out.println("Choose a Volume: [T]ea[sp]oon, [M]illi[l]itre, [T]a[b]le[sp]oon, [Fl]uid [O]unce([z]), [Cup], [P]in[t], [Q]uar[t], [L]itre, [Gal]lon");
        String from = console.next();
        out.println();

        out.println("How many units?: ");
        double units = Double.parseDouble(console.next());
        out.println();

        out.println("Choose a Volume: [T]ea[sp]oon, [M]illi[l]itre, [T]a[b]le[sp]oon, [Fl]uid [O]unce([z]), [Cup], [P]in[t], [Q]uar[t], [L]itre, [Gal]lon");
        String to = console.next();
        out.println();

        switch (to.toLowerCase()) {
            case "ml":
                to = Volume.MILLILITER.name().toLowerCase();
                result = milliliter(from, units);
                break;
            case "tsp":
                to = Volume.TEASPOON.name().toLowerCase();
                result = teaspoon(from, units);
                break;
            case "tbsp":
                to = Volume.TABLESPOON.name().toLowerCase();
                result = tablespoon(from, units);
                break;
            case "fl.oz":
                to = Volume.FLUID_OUNCE.name().toLowerCase();
                result = fluidOunce(from, units);
                break;
            case "cup":
                to = Volume.CUP.name().toLowerCase();
                result = cup(from, units);
                break;
            case "pt":
                to = Volume.PINT.name().toLowerCase();
                result = pint(from, units);
                break;
            case "qt":
                to = Volume.QUART.name().toLowerCase();
                result = quart(from, units);
                break;
            case "l":
                to = Volume.LITER.name().toLowerCase();
                result = liter(from, units);
                break;
            case "gal":
                to = Volume.GALLON.name().toLowerCase();
                result = gallon(from, units);
                break;
            default:
                throw new IllegalArgumentException(from + " is not a valid input!");
        }
        double roundedResult = NumberConstants.roundedCurrencyValue(result);
        out.printf("%.2f %s(s) = %.2f %s(s)%n", units, getVolumeFrom(from), roundedResult, to);
        return roundedResult;
    }


    static class DigitalStorageUnits {
        enum DigitalStorage {
            BIT("bit"),
            BYTE("byte"),
            KILOBYTE("kb"),
            MEGABYTE("mb"),
            GIGABYTE("gb"),
            TERABYTE("tb"),
            PETABYTE("pb");

            private final String abbreviation;

            DigitalStorage(String abbreviation) {
                this.abbreviation = abbreviation;
            }

            public String getAbbreviation() {
                return this.abbreviation;
            }
        }

        private DigitalStorageUnits() {
        }

        static double bit(String from, double units) {
            if (from.equalsIgnoreCase("byte")) {
                return units * 8;
            } else if (from.equalsIgnoreCase("kb")) {
                return units * 8 * Math.pow(2, 10);
            } else if (from.equalsIgnoreCase("mb")) {
                return units * 8 * Math.pow(2, 20);
            } else if (from.equalsIgnoreCase("gb")) {
                return units * 8 * Math.pow(2, 30);
            } else if (from.equalsIgnoreCase("tb")) {
                return units * 8 * Math.pow(2, 40);
            } else if (from.equalsIgnoreCase("pb")) {
                return units * 8 * Math.pow(2, 50);
            }
            return units;
        }

        static double fromByte(String from, double units) {
            if (from.equalsIgnoreCase("bit")) {
                return units / 8;
            } else if (from.equalsIgnoreCase("kb")) {
                return units * Math.pow(2, 10);
            } else if (from.equalsIgnoreCase("mb")) {
                return units * Math.pow(2, 20);
            } else if (from.equalsIgnoreCase("gb")) {
                return units * Math.pow(2, 30);
            } else if (from.equalsIgnoreCase("tb")) {
                return units * Math.pow(2, 40);
            } else if (from.equalsIgnoreCase("pb")) {
                return units * Math.pow(2, 50);
            }
            return units;
        }

        static double kilobyte(String from, double units) {
            if (from.equalsIgnoreCase("bit")) {
                return units / (8 * Math.pow(2, 10));
            } else if (from.equalsIgnoreCase("byte")) {
                return units / Math.pow(2, 10);
            } else if (from.equalsIgnoreCase("mb")) {
                return units * Math.pow(2, 10);
            } else if (from.equalsIgnoreCase("gb")) {
                return units * Math.pow(2, 20);
            } else if (from.equalsIgnoreCase("tb")) {
                return units * Math.pow(2, 30);
            } else if (from.equalsIgnoreCase("pb")) {
                return units * Math.pow(2, 40);
            }
            return units;
        }

        static double megabyte(String from, double units) {
            if (from.equalsIgnoreCase("bit")) {
                return units / (8 * Math.pow(2, 20));
            } else if (from.equalsIgnoreCase("byte")) {
                return units / Math.pow(2, 20);
            } else if (from.equalsIgnoreCase("kb")) {
                return units / Math.pow(2, 10);
            } else if (from.equalsIgnoreCase("gb")) {
                return units * Math.pow(2, 10);
            } else if (from.equalsIgnoreCase("tb")) {
                return units * Math.pow(2, 20);
            } else if (from.equalsIgnoreCase("pb")) {
                return units * Math.pow(2, 30);
            }
            return units;
        }

        static double gigabyte(String from, double units) {
            if (from.equalsIgnoreCase("bit")) {
                return units / (8 * Math.pow(2, 30));
            } else if (from.equalsIgnoreCase("byte")) {
                return units / Math.pow(2, 30);
            } else if (from.equalsIgnoreCase("kb")) {
                return units / Math.pow(2, 20);
            } else if (from.equalsIgnoreCase("mb")) {
                return units / Math.pow(2, 10);
            } else if (from.equalsIgnoreCase("tb")) {
                return units * Math.pow(2, 10);
            } else if (from.equalsIgnoreCase("pb")) {
                return units * Math.pow(2, 20);
            }
            return units;
        }

        static double terabyte(String from, double units) {
            if (from.equalsIgnoreCase("bit")) {
                return units / (8 * Math.pow(2, 40));
            } else if (from.equalsIgnoreCase("byte")) {
                return units / Math.pow(2, 40);
            } else if (from.equalsIgnoreCase("kb")) {
                return units / Math.pow(2, 30);
            } else if (from.equalsIgnoreCase("mb")) {
                return units / Math.pow(2, 20);
            } else if (from.equalsIgnoreCase("gb")) {
                return units / Math.pow(2, 10);
            } else if (from.equalsIgnoreCase("pb")) {
                return units * Math.pow(2, 10);
            }
            return units;
        }

        static double petabyte(String from, double units) {
            if (from.equalsIgnoreCase("bit")) {
                return units / (8 * Math.pow(2, 50));
            } else if (from.equalsIgnoreCase("byte")) {
                return units / Math.pow(2, 50);
            } else if (from.equalsIgnoreCase("kb")) {
                return units / Math.pow(2, 40);
            } else if (from.equalsIgnoreCase("mb")) {
                return units / Math.pow(2, 30);
            } else if (from.equalsIgnoreCase("gb")) {
                return units / Math.pow(2, 20);
            } else if (from.equalsIgnoreCase("tb")) {
                return units / Math.pow(2, 10);
            }
            return units;
        }
    }

    private static String getDigitalStorageFrom(String from) {
        return EnumSet.allOf(DigitalStorage.class).stream()
                .filter(d -> from.equalsIgnoreCase(d.getAbbreviation()))
                .findFirst()
                .map(d -> d.name().toLowerCase()).orElse(from);
    }

    private static double convertDigitalStorage(Scanner console) {
        double result = 0;

        out.println("Choose a Digital Storage: [Bit], [Byte], [K]ilo[b]yte, [M]ega[b]yte, [T]era[b]yte, [P]eta[b]yte");
        String from = console.next();
        out.println();

        out.println("How many units?: ");
        double units = Double.parseDouble(console.next());
        out.println();

        out.println("Choose a converting Digital Storage: [Bit], [Byte], [K]ilo[b]yte, [M]ega[b]yte, [T]era[b]yte, [P]eta[b]yte");
        String to = console.next();
        out.println();

        switch (to.toLowerCase()) {
            case "bit":
                to = DigitalStorage.BIT.name().toLowerCase();
                result = bit(from, units);
                break;
            case "byte":
                to = DigitalStorage.BYTE.name().toLowerCase();
                result = fromByte(from, units);
                break;
            case "kb":
                to = DigitalStorage.KILOBYTE.name().toLowerCase();
                result = kilobyte(from, units);
                break;
            case "mb":
                to = DigitalStorage.MEGABYTE.name().toLowerCase();
                result = megabyte(from, units);
                break;
            case "gb":
                to = DigitalStorage.GIGABYTE.name().toLowerCase();
                result = gigabyte(from, units);
                break;
            case "tb":
                to = DigitalStorage.TERABYTE.name().toLowerCase();
                result = terabyte(from, units);
                break;
            case "pb":
                to = DigitalStorage.PETABYTE.name().toLowerCase();
                result = petabyte(from, units);
                break;
            default:
                throw new IllegalArgumentException(from + " is not a valid input!");
        }
        double roundedResult = NumberConstants.roundedCurrencyValue(result);
        out.printf("%.2f %s(s) = %.2f %s(s)%n", units, getDigitalStorageFrom(from), roundedResult, to);
        return roundedResult;
    }


    static class SpeedUnits {
        enum Speed {
            FEET_PER_SECOND("ftps"),
            MILES_PER_HOUR("mph"),
            KILOMETERS_PER_HOUR("kmph");

            private final String abbreviation;

            Speed(String abbreviation) {
                this.abbreviation = abbreviation;
            }

            public String getAbbreviation() {
                return this.abbreviation;
            }
        }

        private SpeedUnits() {
        }

        static double feetPerSecond(String from, double units) {
            if (from.equalsIgnoreCase("kmph")) {
                return units * 0.9113444;
            } else if (from.equalsIgnoreCase("mph")) {
                return units * 1.466667;
            }
            return units;
        }

        static double kilometersPerHour(String from, double units) {
            if (from.equalsIgnoreCase("ftps")) {
                return units * 1.09728;
            } else if (from.equalsIgnoreCase("mph")) {
                return units * 1.609344;
            }
            return units;
        }

        static double milesPerHour(String from, double units) {
            if (from.equalsIgnoreCase("ftps")) {
                return units * 0.6818182;
            } else if (from.equalsIgnoreCase("kmph")) {
                return units * 0.6213712;
            }
            return units;
        }
    }

    private static String getSpeedFrom(String from) {
        return EnumSet.allOf(Speed.class).stream()
                .filter(d -> from.equalsIgnoreCase(d.getAbbreviation()))
                .findFirst()
                .map(d -> d.name().toLowerCase()).orElse(from);
    }

    private static double convertSpeed(Scanner console) {
        double result = 0;

        out.println("Choose a Speed: [F]ee[t] [P]er [S]econd, [K]ilo[m]eters [P]er [H]our, [M]iles [P]er [H]our");
        String from = console.next();
        out.println();

        out.println("How many units?: ");
        double units = Double.parseDouble(console.next());
        out.println();

        out.println("Choose a Speed: [F]ee[t] [P]er [S]econd, [K]ilo[m]eters [P]er [H]our, [M]iles [P]er [H]our");
        String to = console.next();
        out.println();

        switch (to.toLowerCase()) {
            case "ftps":
                to = FEET_PER_SECOND.name().toLowerCase();
                result = feetPerSecond(from, units);
                break;
            case "kmph":
                to = KILOMETERS_PER_HOUR.name().toLowerCase();
                result = kilometersPerHour(from, units);
                break;
            case "mph":
                to = MILES_PER_HOUR.name().toLowerCase();
                result = milesPerHour(from, units);
                break;
            default:
                throw new IllegalArgumentException(from + " is not a valid input!");
        }
        double roundedResult = NumberConstants.roundedCurrencyValue(result);
        out.printf("%.2f %s(s) = %.2f %s(s)%n", units, getSpeedFrom(from), roundedResult, to);
        return roundedResult;
    }


    static class FrequencyUnits {
        enum Frequency {
            HERTZ("hz"),
            KILO_HERTZ("khz"),
            MEGA_HERTZ("mhz"),
            GIGA_HERTZ("ghz"),
            TERA_HERTZ("thz");

            private final String abbreviation;

            Frequency(String abbreviation) {
                this.abbreviation = abbreviation;
            }

            public String getAbbreviation() {
                return this.abbreviation;
            }
        }

        private FrequencyUnits() {
        }

        static double hertz(String from, double units) {
            if (from.equalsIgnoreCase("khz")) {
                return units * Math.pow(10, 3);
            } else if (from.equalsIgnoreCase("mhz")) {
                return units * Math.pow(10, 6);
            } else if (from.equalsIgnoreCase("ghz")) {
                return units * Math.pow(10, 9);
            } else if (from.equalsIgnoreCase("thz")) {
                return units * Math.pow(10, 12);
            }
            return units;
        }

        static double kiloHertz(String from, double units) {
            if (from.equalsIgnoreCase("hz")) {
                return units / Math.pow(10, 3);
            } else if (from.equalsIgnoreCase("mhz")) {
                return units * Math.pow(10, 3);
            } else if (from.equalsIgnoreCase("ghz")) {
                return units * Math.pow(10, 6);
            } else if (from.equalsIgnoreCase("thz")) {
                return units * Math.pow(10, 9);
            }
            return units;
        }

        static double megaHertz(String from, double units) {
            if (from.equalsIgnoreCase("hz")) {
                return units / Math.pow(10, 6);
            } else if (from.equalsIgnoreCase("khz")) {
                return units / Math.pow(10, 3);
            } else if (from.equalsIgnoreCase("ghz")) {
                return units * Math.pow(10, 3);
            } else if (from.equalsIgnoreCase("thz")) {
                return units * Math.pow(10, 6);
            }
            return units;
        }

        static double gigaHertz(String from, double units) {
            if (from.equalsIgnoreCase("hz")) {
                return units / Math.pow(10, 9);
            } else if (from.equalsIgnoreCase("khz")) {
                return units / Math.pow(10, 6);
            } else if (from.equalsIgnoreCase("mhz")) {
                return units / Math.pow(10, 3);
            } else if (from.equalsIgnoreCase("thz")) {
                return units * Math.pow(10, 3);
            }
            return units;
        }

        static double teraHertz(String from, double units) {
            if (from.equalsIgnoreCase("hz")) {
                return units / Math.pow(10, 12);
            } else if (from.equalsIgnoreCase("khz")) {
                return units / Math.pow(10, 9);
            } else if (from.equalsIgnoreCase("mhz")) {
                return units / Math.pow(10, 6);
            } else if (from.equalsIgnoreCase("ghz")) {
                return units / Math.pow(10, 3);
            }
            return units;
        }
    }

    private static String getFrequencyFrom(String from) {
        return EnumSet.allOf(FrequencyUnits.Frequency.class).stream()
                .filter(d -> from.equalsIgnoreCase(d.getAbbreviation()))
                .findFirst()
                .map(d -> d.name().toLowerCase()).orElse(from);
    }

    private static double convertFrequency(Scanner console) {
        double result = 0;

        out.println("Choose a Frequency: [H]ert[z], [K]ilo[h]ert[z], [M]ega[h]ert[z], [G]iga[h]ert[z], [T]era[h]ert[z]");
        String from = console.next();
        out.println();

        out.println("How many units?: ");
        double units = Double.parseDouble(console.next());
        out.println();

        out.println("Choose a converting Frequency: [H]ert[z], [K]ilo[h]ert[z], [M]ega[h]ert[z], [G]iga[h]ert[z], [T]era[h]ert[z]");
        String to = console.next();
        out.println();

        switch (to.toLowerCase()) {
            case "hz":
                to = HERTZ.name().toLowerCase();
                result = hertz(from, units);
                break;
            case "khz":
                to = KILO_HERTZ.name().toLowerCase();
                result = kiloHertz(from, units);
                break;
            case "mhz":
                to = MEGA_HERTZ.name().toLowerCase();
                result = megaHertz(from, units);
                break;
            case "ghz":
                to = GIGA_HERTZ.name().toLowerCase();
                result = gigaHertz(from, units);
                break;
            case "thz":
                to = TERA_HERTZ.name().toLowerCase();
                result = teraHertz(from, units);
                break;
            default:
                throw new IllegalArgumentException(from + " is not a valid input!");
        }
        double roundedResult = NumberConstants.roundedCurrencyValue(result);
        out.printf("%.2f %s(s) = %.2f %s(s)%n", units, getFrequencyFrom(from), roundedResult, to);
        return roundedResult;
    }


    static class CurrencyUnits {
        enum Currency {
            US_DOLLAR("$", "usd", "United States of America"),
            BRITISH_POUND("","gbp", "England"),
            EURO("","Euro", "Europe"),
            LEONES("","sll", "Sierra Leone"),
            LIBERIAN_DOLLAR("","lrd", "Liberia"),
            NAIRA("","ngn", "Nigeria"),
            CEDI("","ghs", "Ghana"),
            TZ_SHILLING("","tzs", "Tanzania/Kenya"),
            RAND("","zar", "Azania (South Africa)"),
            BIRR("","etb", "Ethiopia"),
            DIRHAM("","aed", "United Arab Emirates"),
            YEN("","jpy", "Japan"),
            SGD_DOLLAR("","sgd", "Singapore"),
            YUAN("","cny", "China"),
            RUPEE("","inr", "India");

            private final String symbol;
            private final String code;
            private final String country;

            Currency(String symbol, String code, String country) {
                this.symbol = symbol;
                this.code = code;
                this.country = country;
            }

            public String getSymbol() {
                return this.symbol;
            }

            public String getCode() {
                return this.code;
            }

            public String getCountry() {
                return this.country;
            }
        }

        private CurrencyUnits() {
        }

        static double usDollar(String from, double units) {
            if (from.equalsIgnoreCase(BRITISH_POUND.getCode())) {
                return units * 1.28;
            } else if (from.equalsIgnoreCase(EURO.getCode())) {
                return units * 1.14;
            } else if (from.equalsIgnoreCase(LIBERIAN_DOLLAR.getCode())) {
                return units * 0.0050;
            }  else if (from.equalsIgnoreCase(LEONES.getCode())) {
                return units * 0.000102;
            } else if (from.equalsIgnoreCase(NAIRA.getCode())) {
                return units * 0.0026;
            } else if (from.equalsIgnoreCase(CEDI.getCode())) {
                return units * 0.17;
            } else if (from.equalsIgnoreCase(TZ_SHILLING.getCode())) {
                return units * 0.000432;
            } else if (from.equalsIgnoreCase(RAND.getCode())) {
                return units * 0.06;
            } else if (from.equalsIgnoreCase(BIRR.getCode())) {
                return units * 0.03;
            } else if (from.equalsIgnoreCase(DIRHAM.getCode())) {
                return units * 0.27;
            } else if (from.equalsIgnoreCase(YEN.getCode())) {
                return units * 0.0093;
            } else if (from.equalsIgnoreCase(YUAN.getCode())) {
                return units * 0.14;
            } else if (from.equalsIgnoreCase(SGD_DOLLAR.getCode())) {
                return units * 0.72;
            } else if (from.equalsIgnoreCase(RUPEE.getCode())) {
                return units * 0.01;
            }
            return units;
        }

        static double britishPound(String from, double units) {
            if (from.equalsIgnoreCase(US_DOLLAR.getCode())) {
                return units * 0.78;
            } else if (from.equalsIgnoreCase(EURO.getCode())) {
                return units * 0.89;
            } else if (from.equalsIgnoreCase(LIBERIAN_DOLLAR.getCode())) {
                return units * 0.0039;
            }  else if (from.equalsIgnoreCase(LEONES.getCode())) {
                return units * 0.000080;
            } else if (from.equalsIgnoreCase(NAIRA.getCode())) {
                return units * 0.0020;
            } else if (from.equalsIgnoreCase(CEDI.getCode())) {
                return units * 0.14;
            } else if (from.equalsIgnoreCase(TZ_SHILLING.getCode())) {
                return units * 0.000339;
            } else if (from.equalsIgnoreCase(RAND.getCode())) {
                return units * 0.05;
            } else if (from.equalsIgnoreCase(BIRR.getCode())) {
                return units * 0.02;
            } else if (from.equalsIgnoreCase(DIRHAM.getCode())) {
                return units * 0.21;
            } else if (from.equalsIgnoreCase(YEN.getCode())) {
                return units * 0.0073;
            } else if (from.equalsIgnoreCase(YUAN.getCode())) {
                return units * 0.11;
            } else if (from.equalsIgnoreCase(SGD_DOLLAR.getCode())) {
                return units * 0.57;
            } else if (from.equalsIgnoreCase(RUPEE.getCode())) {
                return units * 0.01;
            }
            return units;
        }

        static double euro(String from, double units) {
            if (from.equalsIgnoreCase(US_DOLLAR.getCode())) {
                return units * 0.88;
            } else if (from.equalsIgnoreCase(BRITISH_POUND.getCode())) {
                return units * 1.12;
            } else if (from.equalsIgnoreCase(LIBERIAN_DOLLAR.getCode())) {
                return units * 0.0044;
            }  else if (from.equalsIgnoreCase(LEONES.getCode())) {
                return units * 0.000090;
            } else if (from.equalsIgnoreCase(NAIRA.getCode())) {
                return units * 0.0023;
            } else if (from.equalsIgnoreCase(CEDI.getCode())) {
                return units * 0.15;
            } else if (from.equalsIgnoreCase(TZ_SHILLING.getCode())) {
                return units * 0.000380;
            } else if (from.equalsIgnoreCase(RAND.getCode())) {
                return units * 0.05;
            } else if (from.equalsIgnoreCase(BIRR.getCode())) {
                return units * 0.02;
            } else if (from.equalsIgnoreCase(DIRHAM.getCode())) {
                return units * 0.24;
            } else if (from.equalsIgnoreCase(YEN.getCode())) {
                return units * 0.0082;
            } else if (from.equalsIgnoreCase(YUAN.getCode())) {
                return units * 0.12;
            } else if (from.equalsIgnoreCase(SGD_DOLLAR.getCode())) {
                return units * 0.64;
            } else if (from.equalsIgnoreCase(RUPEE.getCode())) {
                return units * 0.01;
            }
            return units;
        }

        static double sierraLeoneLeones(String from, double units) {
            if (from.equalsIgnoreCase(US_DOLLAR.getCode())) {
                return units * 9815.2;
            } else if (from.equalsIgnoreCase(BRITISH_POUND.getCode())) {
                return units * 12522;
            } else if (from.equalsIgnoreCase(EURO.getCode())) {
                return units * 11204.00;
            }  else if (from.equalsIgnoreCase(LIBERIAN_DOLLAR.getCode())) {
                return units * 49.53;
            } else if (from.equalsIgnoreCase(NAIRA.getCode())) {
                return units * 25.42;
            } else if (from.equalsIgnoreCase(CEDI.getCode())) {
                return units * 1702.51;
            } else if (from.equalsIgnoreCase(TZ_SHILLING.getCode())) {
                return units * 4.25;
            } else if (from.equalsIgnoreCase(RAND.getCode())) {
                return units * 575.83;
            } else if (from.equalsIgnoreCase(BIRR.getCode())) {
                return units * 284.08;
            } else if (from.equalsIgnoreCase(DIRHAM.getCode())) {
                return units * 2681.82;
            } else if (from.equalsIgnoreCase(YEN.getCode())) {
                return units * 92.32;
            } else if (from.equalsIgnoreCase(YUAN.getCode())) {
                return units * 1394.14;
            } else if (from.equalsIgnoreCase(SGD_DOLLAR.getCode())) {
                return units * 7091.23;
            } else if (from.equalsIgnoreCase(RUPEE.getCode())) {
                return units * 129.83;
            }
            return units;
        }

        static double liberianDollar(String from, double units) {
            if (from.equalsIgnoreCase(US_DOLLAR.getCode())) {
                return units * 199;
            } else if (from.equalsIgnoreCase(BRITISH_POUND.getCode())) {
                return units * 253.88;
            } else if (from.equalsIgnoreCase(EURO.getCode())) {
                return units * 225.97;
            }  else if (from.equalsIgnoreCase(LEONES.getCode())) {
                return units * 0.02;
            } else if (from.equalsIgnoreCase(NAIRA.getCode())) {
                return units * 0.51;
            } else if (from.equalsIgnoreCase(CEDI.getCode())) {
                return units * 34.37;
            } else if (from.equalsIgnoreCase(TZ_SHILLING.getCode())) {
                return units * 0.09;
            } else if (from.equalsIgnoreCase(RAND.getCode())) {
                return units * 12.01;
            } else if (from.equalsIgnoreCase(BIRR.getCode())) {
                return units * 5.79;
            } else if (from.equalsIgnoreCase(DIRHAM.getCode())) {
                return units * 54.19;
            } else if (from.equalsIgnoreCase(YEN.getCode())) {
                return units * 1.86;
            } else if (from.equalsIgnoreCase(YUAN.getCode())) {
                return units * 28.18;
            } else if (from.equalsIgnoreCase(SGD_DOLLAR.getCode())) {
                return units * 143.78;
            } else if (from.equalsIgnoreCase(RUPEE.getCode())) {
                return units * 2.63;
            }
            return units;
        }

        static double nigerianNaira(String from, double units) {
            if (from.equalsIgnoreCase(US_DOLLAR.getCode())) {
                return units * 387.48;
            } else if (from.equalsIgnoreCase(BRITISH_POUND.getCode())) {
                return units * 489.40;
            } else if (from.equalsIgnoreCase(EURO.getCode())) {
                return units * 440.79;
            }  else if (from.equalsIgnoreCase(LEONES.getCode())) {
                return units * 0.04;
            } else if (from.equalsIgnoreCase(LIBERIAN_DOLLAR.getCode())) {
                return units * 1.95;
            } else if (from.equalsIgnoreCase(CEDI.getCode())) {
                return units * 66.98;
            } else if (from.equalsIgnoreCase(TZ_SHILLING.getCode())) {
                return units * 0.17;
            } else if (from.equalsIgnoreCase(RAND.getCode())) {
                return units * 22.65;
            } else if (from.equalsIgnoreCase(BIRR.getCode())) {
                return units * 11.18;
            } else if (from.equalsIgnoreCase(DIRHAM.getCode())) {
                return units * 105.51;
            } else if (from.equalsIgnoreCase(YEN.getCode())) {
                return units * 3.63;
            } else if (from.equalsIgnoreCase(YUAN.getCode())) {
                return units * 54.85;
            } else if (from.equalsIgnoreCase(SGD_DOLLAR.getCode())) {
                return units * 278.98;
            } else if (from.equalsIgnoreCase(RUPEE.getCode())) {
                return units * 5.09;
            }
            return units;
        }

        static double ghanianCedi(String from, double units) {
            if (from.equalsIgnoreCase(US_DOLLAR.getCode())) {
                return units * 5.78;
            } else if (from.equalsIgnoreCase(BRITISH_POUND.getCode())) {
                return units * 7.31;
            } else if (from.equalsIgnoreCase(EURO.getCode())) {
                return units * 6.58;
            }  else if (from.equalsIgnoreCase(LEONES.getCode())) {
                return units * 0.000587;
            } else if (from.equalsIgnoreCase(LIBERIAN_DOLLAR.getCode())) {
                return units * 0.03;
            } else if (from.equalsIgnoreCase(NAIRA.getCode())) {
                return units * 0.01;
            } else if (from.equalsIgnoreCase(TZ_SHILLING.getCode())) {
                return units * 0.0025;
            } else if (from.equalsIgnoreCase(RAND.getCode())) {
                return units * 0.34;
            } else if (from.equalsIgnoreCase(BIRR.getCode())) {
                return units * 0.17;
            } else if (from.equalsIgnoreCase(DIRHAM.getCode())) {
                return units * 1.58;
            } else if (from.equalsIgnoreCase(YEN.getCode())) {
                return units * 0.05;
            } else if (from.equalsIgnoreCase(YUAN.getCode())) {
                return units * 0.82;
            } else if (from.equalsIgnoreCase(SGD_DOLLAR.getCode())) {
                return units * 4.17;
            } else if (from.equalsIgnoreCase(RUPEE.getCode())) {
                return units * 0.08;
            }
            return units;
        }

        static double tanzanianShilling(String from, double units) {
            if (from.equalsIgnoreCase(US_DOLLAR.getCode())) {
                return units * 2315.92;
            } else if (from.equalsIgnoreCase(BRITISH_POUND.getCode())) {
                return units * 2925.10;
            } else if (from.equalsIgnoreCase(EURO.getCode())) {
                return units * 2634.55;
            }  else if (from.equalsIgnoreCase(LEONES.getCode())) {
                return units * 0.24;
            } else if (from.equalsIgnoreCase(LIBERIAN_DOLLAR.getCode())) {
                return units * 11.65;
            } else if (from.equalsIgnoreCase(NAIRA.getCode())) {
                return units * 5.98;
            } else if (from.equalsIgnoreCase(CEDI.getCode())) {
                return units * 400.33;
            } else if (from.equalsIgnoreCase(RAND.getCode())) {
                return units * 135.4;
            } else if (from.equalsIgnoreCase(BIRR.getCode())) {
                return units * 66.8;
            } else if (from.equalsIgnoreCase(DIRHAM.getCode())) {
                return units * 630.61;
            } else if (from.equalsIgnoreCase(YEN.getCode())) {
                return units * 21.71;
            } else if (from.equalsIgnoreCase(YUAN.getCode())) {
                return units * 327.82;
            } else if (from.equalsIgnoreCase(SGD_DOLLAR.getCode())) {
                return units * 1667.45;
            } else if (from.equalsIgnoreCase(RUPEE.getCode())) {
                return units * 30.42;
            }
            return units;
        }

        static double azanianRand(String from, double units) {
            if (from.equalsIgnoreCase(US_DOLLAR.getCode())) {
                return units * 17.1;
            } else if (from.equalsIgnoreCase(BRITISH_POUND.getCode())) {
                return units * 21.60;
            } else if (from.equalsIgnoreCase(EURO.getCode())) {
                return units * 19.46;
            }  else if (from.equalsIgnoreCase(LEONES.getCode())) {
                return units * 0.0017;
            } else if (from.equalsIgnoreCase(LIBERIAN_DOLLAR.getCode())) {
                return units * 0.09;
            } else if (from.equalsIgnoreCase(NAIRA.getCode())) {
                return units * 0.04;
            } else if (from.equalsIgnoreCase(CEDI.getCode())) {
                return units * 2.96;
            } else if (from.equalsIgnoreCase(TZ_SHILLING.getCode())) {
                return units * 0.0074;
            } else if (from.equalsIgnoreCase(BIRR.getCode())) {
                return units * 0.49;
            } else if (from.equalsIgnoreCase(DIRHAM.getCode())) {
                return units * 4.66;
            } else if (from.equalsIgnoreCase(YEN.getCode())) {
                return units * 0.16;
            } else if (from.equalsIgnoreCase(YUAN.getCode())) {
                return units * 2.42;
            } else if (from.equalsIgnoreCase(SGD_DOLLAR.getCode())) {
                return units * 12.31;
            } else if (from.equalsIgnoreCase(RUPEE.getCode())) {
                return units * 0.22;
            }
            return units;
        }

        static double ethiopianBirr(String from, double units) {
            if (from.equalsIgnoreCase(US_DOLLAR.getCode())) {
                return units * 34.67;
            } else if (from.equalsIgnoreCase(BRITISH_POUND.getCode())) {
                return units * 43.79;
            } else if (from.equalsIgnoreCase(EURO.getCode())) {
                return units * 39.44;
            }  else if (from.equalsIgnoreCase(LEONES.getCode())) {
                return units * 0.0035;
            } else if (from.equalsIgnoreCase(LIBERIAN_DOLLAR.getCode())) {
                return units * 0.17;
            } else if (from.equalsIgnoreCase(NAIRA.getCode())) {
                return units * 0.09;
            } else if (from.equalsIgnoreCase(CEDI.getCode())) {
                return units * 5.99;
            } else if (from.equalsIgnoreCase(TZ_SHILLING.getCode())) {
                return units * 0.01;
            } else if (from.equalsIgnoreCase(RAND.getCode())) {
                return units * 2.03;
            } else if (from.equalsIgnoreCase(DIRHAM.getCode())) {
                return units * 9.44;
            } else if (from.equalsIgnoreCase(YEN.getCode())) {
                return units * 0.32;
            } else if (from.equalsIgnoreCase(YUAN.getCode())) {
                return units * 4.91;
            } else if (from.equalsIgnoreCase(SGD_DOLLAR.getCode())) {
                return units * 24.96;
            } else if (from.equalsIgnoreCase(RUPEE.getCode())) {
                return units * 0.46;
            }
            return units;
        }

        static double uaeDirham(String from, double units) {
            if (from.equalsIgnoreCase(US_DOLLAR.getCode())) {
                return units * 3.67;
            } else if (from.equalsIgnoreCase(BRITISH_POUND.getCode())) {
                return units * 4.6;
            } else if (from.equalsIgnoreCase(EURO.getCode())) {
                return units * 4.13;
            }  else if (from.equalsIgnoreCase(LEONES.getCode())) {
                return units * 0.000373;
            } else if (from.equalsIgnoreCase(LIBERIAN_DOLLAR.getCode())) {
                return units * 0.02;
            } else if (from.equalsIgnoreCase(NAIRA.getCode())) {
                return units * 0.0095;
            } else if (from.equalsIgnoreCase(CEDI.getCode())) {
                return units * 0.63;
            } else if (from.equalsIgnoreCase(TZ_SHILLING.getCode())) {
                return units * 0.0016;
            } else if (from.equalsIgnoreCase(RAND.getCode())) {
                return units * 0.22;
            } else if (from.equalsIgnoreCase(BIRR.getCode())) {
                return units * 0.11;
            } else if (from.equalsIgnoreCase(YEN.getCode())) {
                return units * 0.03;
            } else if (from.equalsIgnoreCase(YUAN.getCode())) {
                return units * 0.52;
            } else if (from.equalsIgnoreCase(SGD_DOLLAR.getCode())) {
                return units * 2.64;
            } else if (from.equalsIgnoreCase(RUPEE.getCode())) {
                return units * 0.05;
            }
            return units;
        }

        static double japaneseYen(String from, double units) {
            if (from.equalsIgnoreCase(US_DOLLAR.getCode())) {
                return units * 3.67;
            } else if (from.equalsIgnoreCase(BRITISH_POUND.getCode())) {
                return units * 4.6;
            } else if (from.equalsIgnoreCase(EURO.getCode())) {
                return units * 4.13;
            }  else if (from.equalsIgnoreCase(LEONES.getCode())) {
                return units * 0.000373;
            } else if (from.equalsIgnoreCase(LIBERIAN_DOLLAR.getCode())) {
                return units * 0.02;
            } else if (from.equalsIgnoreCase(NAIRA.getCode())) {
                return units * 0.0095;
            } else if (from.equalsIgnoreCase(CEDI.getCode())) {
                return units * 0.63;
            } else if (from.equalsIgnoreCase(TZ_SHILLING.getCode())) {
                return units * 0.0016;
            } else if (from.equalsIgnoreCase(RAND.getCode())) {
                return units * 0.22;
            } else if (from.equalsIgnoreCase(BIRR.getCode())) {
                return units * 0.11;
            } else if (from.equalsIgnoreCase(DIRHAM.getCode())) {
                return units * 0.03;
            } else if (from.equalsIgnoreCase(YUAN.getCode())) {
                return units * 0.52;
            } else if (from.equalsIgnoreCase(SGD_DOLLAR.getCode())) {
                return units * 2.64;
            } else if (from.equalsIgnoreCase(RUPEE.getCode())) {
                return units * 1.41;
            }
            return units;
        }
    }

    private static String getCurrencyFrom(String from) {
        return EnumSet.allOf(Currency.class).stream()
                .filter(d -> from.equalsIgnoreCase(d.getCode()))
                .findFirst()
                .map(d -> d.name().toLowerCase()).orElse(from);
    }

    private static double convertCurrency(Scanner console) {
        double result = 0;

        out.println("Choose a Currency: [US] [D]ollar, Pound([gbp]), [Eur]o, [L]ibe[r]ian [D]ollar, Leones([sll]), Naira([ngn]), Cedi([ghs]), Schilling([tza]), Rand([zar]), Birr([etb]), Dirham([aed]), Yen([jpy]), [SG] [D]ollar, Renminbi([cny]), Rupee([inr])");
        String from = console.next();
        out.println();

        out.println("How many units?: ");
        double units = Double.parseDouble(console.next());
        out.println();

        out.println("Choose a converting Currency: [US] [D]ollar, Pound([gbp]), [Eur]o, [L]ibe[r]ian [D]ollar, Leones([sll]), Naira([ngn]), Cedi([ghs]), Schilling([tzs]), Rand([zar]), Birr([etb]), Dirham([aed]), Yen([jpy]), [SG] [D]ollar, Renminbi([cny]), Rupee([inr])");
        String to = console.next();
        out.println();

        switch (to.toLowerCase()) {
            case "usd":
                to = US_DOLLAR.name().toLowerCase();
                result = usDollar(from, units);
                break;
            case "gbp":
                to = BRITISH_POUND.name().toLowerCase();
                result = kiloHertz(from, units);
                break;
            case "eur":
                to = EURO.name().toLowerCase();
                result = kiloHertz(from, units);
                break;
            case "lrd":
                to = LIBERIAN_DOLLAR.name().toLowerCase();
                result = megaHertz(from, units);
                break;
            case "sll":
                to = LEONES.name().toLowerCase();
                result = megaHertz(from, units);
                break;
            case "ngn":
                to = NAIRA.name().toLowerCase();
                result = gigaHertz(from, units);
                break;
            case "ghs":
                to = CEDI.name().toLowerCase();
                result = teraHertz(from, units);
                break;
            case "tzs":
                to = TZ_SHILLING.name().toLowerCase();
                result = teraHertz(from, units);
                break;
            case "zar":
                to = RAND.name().toLowerCase();
                result = teraHertz(from, units);
                break;
            case "etb":
                to = BIRR.name().toLowerCase();
                result = teraHertz(from, units);
                break;
            case "aed":
                to = DIRHAM.name().toLowerCase();
                result = teraHertz(from, units);
                break;
            case "jpy":
                to = YEN.name().toLowerCase();
                result = teraHertz(from, units);
                break;
            case "sgd":
                to = SGD_DOLLAR.name().toLowerCase();
                result = teraHertz(from, units);
                break;
            case "cny":
                to = YUAN.name().toLowerCase();
                result = teraHertz(from, units);
                break;
            case "inr":
                to = RUPEE.name().toLowerCase();
                result = teraHertz(from, units);
                break;
            default:
                throw new IllegalArgumentException(from + " is not a valid input!");
        }
        double roundedResult = NumberConstants.roundedCurrencyValue(result);
        out.printf("%.2f %s(s) = %.2f %s(s)%n", units, getCurrencyFrom(from), roundedResult, to);
        return roundedResult;
    }
}
