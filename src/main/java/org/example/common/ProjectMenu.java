package org.example.common;

import static java.lang.System.out;

import java.util.Scanner;

import org.example.numbers.ChangeReturn;
import org.example.numbers.Enth;
import org.example.numbers.Fibonacci;
import org.example.numbers.MortgageCalculator;
import org.example.numbers.NextPrime;
import org.example.numbers.NumberBaseConverter;
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
    private static final String REPEAT = "View the Menu Again";
    private static final String QUIT = "Quit";

    private ProjectMenu() {
    }

    public static void menu() {
        try (Scanner console = new Scanner(System.in)){
            menuOptions();
            //out.print("> ");
            int choice = Integer.parseInt(console.next());
            //int choice = 1;
    
            switch (choice) {
            case -1:
                exitApp();
                break;
            case 0:
                menu();
                break;    
            case 1:
                numberOptions(console);
                break;
            case 2:
                textOptions();
                break;
            case 3:
                dataStructureOptions();
                break;
            case 4:
                algorithmOptions();
                break;
            case 5:
                classOptions();
                break;
            case 6:
                fileOptions();
                break;
            case 7:
                threadingOptions();
                break;
            case 8:
                networkingOptions();
                break;
            case 9:
                databaseOptions();
                break;
            case 10:
                webOptions();
                break;
            case 11:
                securityOptions();
                break;
            case 12:
                graphOptions();
                break;
            case 13:
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
        StringBuilder builder = new StringBuilder("\n*** Welcome to Belum's Karan Project Solutions! ***\n");

        builder.append("1. ").append(NumberConstants.TITLE).append("\n")
            .append("2. ").append(TEXT).append("\n")
            .append("3. ").append(DATA_STRUCTURES).append("\n")
            .append("4. ").append(ALGORITHMS).append("\n")
            .append("5. ").append(CLASSES).append("\n")
            .append("6. ").append(FILES).append("\n")
            .append("7. ").append(THREADING).append("\n")
            .append("8. ").append(NETWORKING).append("\n")
            .append("9. ").append(DATABASES).append("\n")
            .append("10. ").append(WEB).append("\n")
            .append("11. ").append(SECURITY).append("\n")
            .append("12. ").append(GRAPHS).append("\n")
            .append("13. ").append(GRAPHICS_MULTIMEDIA)
            .append(" \n\n0. ").append(REPEAT)
            .append("\n-1. ").append(QUIT);

        System.out.println(builder.toString());
    }

    private static void repeatMenu(String choice, Scanner console){
        try {
            menuOptions();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void exitApp() {
        out.println("... Exiting ...");
        System.exit(0);
    }

    private static void numberMenu() {
        StringBuilder builder = new StringBuilder(" - Number Projects - ");

        builder.append("\n1. ").append(NumberConstants.TITLE_PI).append("\n")
            .append("2. ").append(NumberConstants.TITLE_E).append("\n")
            .append("3. ").append(NumberConstants.TITLE_FIBONACCI).append("\n")
            .append("4. ").append(NumberConstants.TITLE_PRIME_FACTORS).append("\n")
            .append("5. ").append(NumberConstants.TITLE_NEXT_PRIME).append("\n")
            .append("6. ").append(NumberConstants.TITLE_TILE_COST).append("\n")
            .append("7. ").append(NumberConstants.TITLE_MORTGAGE).append("\n")
            .append("8. ").append(NumberConstants.TITLE_CHANGE_RETURN).append("\n")
            .append("9. ").append(NumberConstants.TITLE_NUMBER_CONVERVER).append("\n")
            .append(" \n\n0. ").append(REPEAT)
            .append("\n-1. ").append(QUIT);

        System.out.println(builder.toString());
    }

    private static void numberOptions(Scanner console) {
        try {
            numberMenu();
            //out.println("> \r");
            int choice = 8;//Integer.parseInt(console.next());
            out.println();

            switch (choice) {
            case -1:
                exitApp();
                break;
            case 0:
                numberOptions(console);
                break;
            case 1:
                Pinth.displayPi(console);
                break;
            case 2:
                Enth.displayE(console);
                break;
            case 3:
                Fibonacci.sequence(console);
                break;
            case 4:
                PrimeFactors.calculate(console);
                break;
            case 5:
                NextPrime.infinitePrimes(console);
                break;
            case 6:
                TileCost.calculate(console);
                break;
            case 7:
                MortgageCalculator.printCalculation(console);
                break;
            case 8:
                ChangeReturn.print(console);
                break;
            case 9:
                NumberBaseConverter.print(console);
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