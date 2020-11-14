package org.example.numbers;

import org.example.constants.NumberConstants;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Distance Between Two Cities - Calculates the distance between two cities
 * and allows the user to specify a unit of distance. This program may require
 * finding coordinates for the cities like latitude and longitude.
 */
public final class TwoCities {
    private static final List<String> cityNames = new ArrayList<>();
    private static List<String> cityDistances;
    private static final Map<String, String> citiesMap = new TreeMap<>();

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

    private TwoCities() {
    }

    public static void displayCalculation(Scanner console) {
        fillMap();

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

            String cityAResult = "";
            String cityBResult = "";
            for (Cities c : Cities.values()) {
                if (cityA.equalsIgnoreCase(c.getAbbreviation())) {
                    cityAResult = c.getSimpleName();
                }

                if (cityB.equalsIgnoreCase(c.getAbbreviation())) {
                    cityBResult = c.getSimpleName();
                }
            }

            String cityMapKey = cityAResult + ":" + cityBResult;
            String cityMapValue = citiesMap.get(cityMapKey);

            System.out.println("Choose a Unit of Distance: [Mi]les, [K]ilo[m]eters");
            String distanceChoice = console.next();
            System.out.println();

            String[] cities = cityMapKey.split(":");
            String[] distances = cityMapValue.split(":");

            switch (distanceChoice.toLowerCase()) {
                case "km":
                    System.out.println(String.format("The distance between %s and %s is %s(s).%n", cities[0], cities[1], distances[0]));
                    break;
                case "mi":
                    System.out.println(String.format("The distance between %s and %s is %s(s).%n", cities[0], cities[1], distances[1]));
                    break;
                default:
                    throw new AssertionError(distanceChoice + " is an invalid entry!");
            }
        } catch (Exception e) {
            System.err.println("An Exception occurred while displaying the calculation: " + e);
            throw e;
        }
    }

    private static void fillMap() {
        fillDistances();

        for (int i = 0; i < cityDistances.size(); i++) {
            citiesMap.put(Cities.getCityNameKeys().get(i), cityDistances.get(i));
        }
    }

    private static void fillDistances() {
        cityDistances = List.of(
                "6088km:0", "3644km:0", "2371km:0", "7794km:0", "2574km:0", "12345km:0",
                "5634km:0", "7709km:0", "1553km:0", "11877km:0", "5454km:0",
                "6546km:0", "6682km:0", "2001km:0", "5064km:0", "8410km:0", "485km:0",
                "1565km:0", "5865km:0", "7939km:0", "7214km:0",
                "6008km:0", "8512km:0", "5189km:0", "10662km:0", "6214km:0",
                "7532km:0", "5190km:0", "10236km:0", "8764km:0",
                "8565km:0", "1426km:0", "13006km:0", "6167km:0", "8479km:0", "818km:0",
                "12534km:0", "3618km:0", "6929km:0", "6938km:0", "2467km:0", "549km:0", "7729km:0", "6468km:0",
                "9196km:0", "11867km:0", "4632km:0", "6944km:0", "1165km:0", "11394km:0", "3687km:0",
                "9108km:0", "7263km:0", "12556km:0", "474km:0", "11577km:0",
                "2039km:0", "5372km:0", "8634km:0", "6722km:0", "7657km:0", "6795km:0", "8760km:0",
                "12082km:0", "3906km:0", "11209km:0"
        );

        cityDistances = cityDistances.stream()
                .map(d -> {
                    String[] distances = d.split("km:");
                    d = d.replace(":0", ":" + kilometerToMiles(Integer.parseInt(distances[0])) + "mi");
                    return d;
                })
                .collect(Collectors.toList());
    }

    private static int kilometerToMiles(int kilometer) {
        return (int) (kilometer / NumberConstants.KM_TO_MI);
    }
}
