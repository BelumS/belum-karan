package org.example.numbers;

import java.util.*;

/**
 * Distance Between Two Cities - Calculates the distance between two cities
 * and allows the user to specify a unit of distance. This program may require
 * finding coordinates for the cities like latitude and longitude.
 */
public final class TwoCities {
    private static final Set<String> cities = new TreeSet<>(Set.of(
            "Honolulu", "Seattle", "Los Angeles", "Phoenix", "New York City", "Miami",
            "Mexico City", "Veracuz", "Toronto", "Sao Paolo", "Rio de Janeiro",
            "Tokyo", "Shanghai", "Beijing", "Seoul", "Madrid", "London", "Paris", "Rome", "Athens",
            "Havana", "San Juan", "Lima", "Port au Prince", "Bogota", "Kingston",
            "Cairo", "Luxor", "Nairobi", "Dar es Salaam", "Johannesburg", "Freetown",
            "Monrovia", "Addis Ababa", "Kigali", "Lagos", "Akkra"
    ));

    private static Map<String, String> citiesMap = new TreeMap<>();

    //TODO: Add all City permutations to a TreeMap, delimited by a colon; {K=[CityA:CityB], V=[M:KM]}
    //TODO: Then to separate, create a stream to separate by the colon, and collect to a TreeSet.
    //private static final String[] CITIY_KV_SPLITTER = map.keySet().split(":");

    private TwoCities(){}

    public static void displayCalculation(Scanner console) {
        var result = 0.0;
        try (console) {
            System.out.println("---------- Distance between 2 Cities ----------");
            System.out.println("List of Cities: " + cities);
            System.out.println("Choose City #1: ");
            String cityA = console.next();
            System.out.println();

            System.out.println("Choose City #2: ");
            String cityB = console.next();
            System.out.println();

            System.out.println("Choose a Unit of Distance: [Mi]les, [K]ilo[m]eters");
            String distanceChoice = console.next();
            System.out.println();

            switch(distanceChoice.toLowerCase()) {
                case "mi":
                    result = calculateMiles(console, cityA, cityB);
                    break;
                case "km":
                    result = calculateKilometers(console, cityA, cityB);
                    break;
                default:
                    throw new AssertionError(distanceChoice + " is an invalid entry!");
            }
            System.out.println(String.format("The distance between %s and %s is %.2f%s(s)", cityA, cityB, result, distanceChoice));
        } catch (Exception e) {
            System.err.println("An Exception occurred while displaying the calculation: " + e);
            throw e;
        }
    }

    private static double calculateMiles(Scanner scanner, String cityA, String cityB) {
        try (scanner) {
            System.out.println("");
            return 0.0;
        } catch (Exception e) {
            System.err.println("An Exception occurred " + e);
            throw e;
        }
    }

    private static double calculateKilometers(Scanner scanner, String cityA, String cityB) {
        try (scanner) {
            return 0.0;
        } catch (Exception e) {
            System.err.println("An Exception occurred " + e);
            throw e;
        }
    }
}
