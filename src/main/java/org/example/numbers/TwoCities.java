package org.example.numbers;

import java.util.*;
import java.util.stream.Stream;

/**
 * Distance Between Two Cities - Calculates the distance between two cities
 * and allows the user to specify a unit of distance. This program may require
 * finding coordinates for the cities like latitude and longitude.
 */
public final class TwoCities {
    enum Cities {
        ADDIS_ABABA("AA", "[A]ddis [A]baba"),
        AKKRA("AK", "[A][k]kra"),
        CAIRO("CR", "[C]ai[r]o"),
        DAR_ES_SALAAM("DS", "[D]ar es [S]alaam"),
        FREETOWN("FT", "[F]ree[t]own"),
        KIGALI("KGL", "[K]i[g]a[l]i"),
        KINGSTON("KG", "[K]in[g]ston"),
        LAGOS("LG", "[L]a[g]os"),
        MONROVIA("MNR", "[M]o[n][r]ovia"),
        NAIROBI("NR", "[N]ai[r]obi"),
        PORT_AU_PRINCE("PP", "[P]ort-au-[P]rince"),
        SOWETO("SWT", "[S]o[w]e[t]o");

        private final String abbreviation;
        private final String abbreviatedSimpleName;

        Cities(String abbreviation, String abbreviatedSimpleName) {
            this.abbreviation = abbreviation;
            this.abbreviatedSimpleName = abbreviatedSimpleName;
        }

        public String getSimpleName() {
            String result = this.getAbbreviatedSimpleName();
            result = result.replace("[", "");
            result = result.replace("]", "");
            return result.substring(0, 1).toUpperCase() + result.substring(1);
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public String getAbbreviatedSimpleName() {
            return abbreviatedSimpleName;
        }

        public static List<String> getCityNameKeys() {
            return List.of(
                    "Addis Ababa:Akkra", "Addis Ababa:Cairo", "Addis Ababa:Dar es Salaam", "Addis Ababa:Freetown", "Addis Ababa:Kigali", "Addis Ababa:Kingston",
                    "Addis Ababa:Lagos", "Addis Ababa:Monrovia", "Addis Ababa:Nairobi", "Addis Ababa:Port-au-Prince", "Addis Ababa:Soweto",
                    "Akkra:Cairo", "Akkra:Dar es Salaam", "Akkra:Freetown", "Akkra:Kigali", "Akkra:Kingston",
                    "Akkra:Lagos", "Akkra:Monrovia", "Akkra:Nairobi", "Akkra:Port-au-Prince", "Akkra:Soweto",
                    "Cairo:Dar es Salaam", "Cairo:Freetown", "Cairo:Kigali", "Cairo:Kingston",
                    "Cairo:Lagos", "Cairo:Monrovia", "Cairo:Nairobi", "Cairo:Port-au-Prince", "Cairo:Soweto",
                    "Dar es Salaam:Freetown", "Dar es Salaam:Kigali", "Dar es Salaam:Kingston", "Dar es Salaam:Lagos",
                    "Dar es Salaam:Monrovia", "Dar es Salaam:Nairobi", "Dar es Salaam:Port-au-Prince", "Dar es Salaam:Soweto",
                    "Freetown:Kigali", "Freetown:Kingston", "Freetown:Lagos", "Freetown:Monrovia", "Freetown:Nairobi", "Freetown:Port-au-Prince", "Freetown:Soweto",
                    "Kigali:Kingston", "Kigali:Lagos", "Kigali:Monrovia", "Kigali:Nairobi", "Kigali:Port-au-Prince", "Kigali:Soweto",
                    "Kingston:Lagos", "Kingston:Monrovia", "Kingston:Nairobi", "Kingston:Port-au-Prince", "Kingston:Soweto",
                    "Lagos:Monrovia", "Lagos:Nairobi", "Lagos:Port-au-Prince", "Lagos:Soweto",
                    "Monrovia:Nairobi", "Monrovia:Port-au-Prince", "Monrovia:Soweto",
                    "Nairobi:Port-au-Prince", "Nairobi:Soweto",
                    "Port-au-Prince:Soweto"
            );
        }
    }

    private static Set<String> cityNames = new TreeSet<>();
    private static Map<String, String> citiesMap = new TreeMap<>();

    //TODO: Add all City permutations to a TreeMap, delimited by a colon; {K=[CityA:CityB], V=[M:KM]}
    //TODO: Then to separate, create a stream to separate by the colon, and collect to a TreeSet.
    //private static final String[] CITY_KV_SPLITTER = citiesMap.keySet().toString().split(":");

    private TwoCities() {
    }

    public static void displayCalculation(Scanner console) {
        var resultA = 0.0;
        var resultB = 0.0;
        try (console) {
            System.out.println("---------- Distance between 2 Cities ----------");
            Stream.of(Cities.values()).forEach(city -> cityNames.add(city.getAbbreviatedSimpleName()));
            System.out.println("Cities: " + cityNames);

            System.out.println("Choose City #1: ");
            String cityA = console.next();
            System.out.println();

            System.out.println("Choose City #2: ");
            String cityB = console.next();
            System.out.println();

            System.out.println("Choose a Unit of Distance: [Mi]les, [K]ilo[m]eters");
            String distanceChoice = console.next();
            System.out.println();

            switch (distanceChoice.toLowerCase()) {
                case "mi":
                    resultA = calculateMiles(console, distanceChoice.toLowerCase(), cityA, cityB);
                    break;
                case "km":
                    resultB = calculateKilometers(console, distanceChoice.toLowerCase(), cityA, cityB);
                    break;
                default:
                    throw new AssertionError(distanceChoice + " is an invalid entry!");
            }
            System.out.println(String.format("The distance between %s and %s is %.2f%s(s)", cityA, cityB, 0.0, distanceChoice));
            citiesMap.put((cityA + ":" + cityB), (resultA + ":" + resultB));
        } catch (Exception e) {
            System.err.println("An Exception occurred while displaying the calculation: " + e);
            throw e;
        }
    }

    private static double calculateMiles(Scanner scanner, String distanceChoice, String cityA, String cityB) {
        try (scanner) {
            System.out.println();
            return 0.0;
        } catch (Exception e) {
            System.err.println("An Exception occurred " + e);
            throw e;
        }
    }

    private static double calculateKilometers(Scanner scanner, String distanceChoice, String cityA, String cityB) {
        try (scanner) {
            System.out.println();
            return 0.0;
        } catch (Exception e) {
            System.err.println("An Exception occurred " + e);
            throw e;
        }
    }
}
