package org.example.common;

import static java.lang.System.out;

import java.util.Scanner;

import org.example.numbers.ChangeReturn;
import org.example.numbers.Enth;
import org.example.numbers.Fibonacci;
import org.example.numbers.MortgageCalculator;
import org.example.numbers.NextPrime;
import org.example.numbers.Pinth;
import org.example.numbers.PrimeFactors;
import org.example.numbers.TileCost;

public class ProjectMenu {
    private static final String TEXT = "Text";
    private static final String DATA_STRUCTURES = "Data Structures";
    private static final String ALGORITHMS = "Algorithms";
    private static final String CLASSES = "Classes";
    private static final String FILES = "Files";
    private static final String THREADING = "Threading";
    private static final String NETWORKING = "Networking";
    private static final String DATABASES = "Databases";
    private static final String WEB = "Web";
    private static final String SECURITY = "Security";
    private static final String GRAPHS = "Graphs";
    private static final String GRAPHICS_MULTIMEDIA = "Graphics and Multimedia";

    private ProjectMenu() {
    }

    public static void menu() {
        System.out.println("\n*** Welcome to Belum's Karan Project Solutions! ***\n");

        try (Scanner console = new Scanner(System.in)){
            menuOptions();
            //out.print("> ");
            int choice = Integer.parseInt(console.next());
    
            switch (choice) {
            case 0:
                numberOptions(console);
                break;
            case 1:
                textOptions();
                break;
            case 2:
                dataStructureOptions();
                break;
            case 3:
                algorithmOptions();
                break;
            case 4:
                classOptions();
                break;
            case 5:
                fileOptions();
                break;
            case 6:
                threadingOptions();
                break;
            case 7:
                networkingOptions();
                break;
            case 8:
                databaseOptions();
                break;
            case 9:
                webOptions();
                break;
            case 10:
                securityOptions();
                break;
            case 11:
                graphOptions();
                break;
            case 12:
                graphicOptions();
                break;
            default:
                out.println("Invalid Menu Option .. Exiting!");
                System.exit(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void menuOptions() {
        StringBuilder builder = new StringBuilder();

        builder.append("0. ").append(NumberConstants.TITLE).append("\n")
            .append("1. ").append(TEXT).append("\n")
            .append("2. ").append(DATA_STRUCTURES).append("\n")
            .append("3. ").append(ALGORITHMS).append("\n")
            .append("4. ").append(CLASSES).append("\n")
            .append("5. ").append(FILES).append("\n")
            .append("6. ").append(THREADING).append("\n")
            .append("7. ").append(NETWORKING).append("\n")
            .append("8. ").append(DATABASES).append("\n")
            .append("9. ").append(WEB).append("\n")
            .append("10. ").append(SECURITY).append("\n")
            .append("11. ").append(GRAPHS).append("\n")
            .append("12. ").append(GRAPHICS_MULTIMEDIA);

        System.out.println(builder.toString());
    }

    private static void numberMenu() {
        StringBuilder builder = new StringBuilder();

        builder.append("0. ").append(NumberConstants.TITLE_PI).append("\n")
            .append("1. ").append(NumberConstants.TITLE_E).append("\n")
            .append("2. ").append(NumberConstants.TITLE_FIBONACCI).append("\n")
            .append("3. ").append(NumberConstants.TITLE_PRIME_FACTORS).append("\n")
            .append("4. ").append(NumberConstants.TITLE_NEXT_PRIME).append("\n")
            .append("5. ").append(NumberConstants.TITLE_TILE_COST).append("\n")
            .append("6. ").append(NumberConstants.TITLE_MORTGAGE).append("\n")
            .append("7. ").append(NumberConstants.TITLE_CHANGE_RETURN).append("\n");

        System.out.println(builder.toString());
    }

    private static void numberOptions(Scanner console) {
        try {
            numberMenu();
            //out.println("> \r");
            int choice = Integer.parseInt(console.next());
            out.println();

            switch (choice) {
            case 0:
                Pinth.displayPi(console);
                break;
            case 1:
                Enth.displayE(console);
                break;
            case 2:
                Fibonacci.sequence(console);
                break;
            case 3:
                PrimeFactors.calculate(console);
                break;
            case 4:
                NextPrime.infinitePrimes(console);
                break;
            case 5:
                TileCost.calculate(console);
                break;
            case 6:
                MortgageCalculator.printCalculation(console);
                break;
            case 7:
                ChangeReturn.print(console);
                break;
            default:
                out.println("Invalid Menu Option .. Exiting!");
                System.exit(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void textOptions() {
    }

    private static void dataStructureOptions() {
    }

    private static void algorithmOptions() {
    }

    private static void classOptions() {
    }

    private static void fileOptions() {
    }

    private static void threadingOptions() {
    }

    private static void networkingOptions() {
    }

    private static void databaseOptions() {
    }

    private static void webOptions() {
    }

    private static void securityOptions() {
    }

    private static void graphOptions() {
    }

    private static void graphicOptions() {
    }
}