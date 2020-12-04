package org.example.common;

import org.example.constants.AppConstants;
import org.example.constants.NumberConstants;
import org.example.constants.TextConstants;
import org.example.numbers.*;
import org.example.text.*;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Generates a text-based UI that displays the karan projects,
 * and allows for user input.
 */
public final class ProjectMenu {
    private static final String TITLE = "\n*** Welcome to Belum's Karan Project Solutions! ***\n";
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
    private static final String QUIT_MSG = "Quit";
    private static final int EXIT = -1;
    private static boolean quit = false;
    private static int menuCounter = 0;

    private ProjectMenu() {
    }

    /**
     * Displays the text-based UI for the application, and allows for user input.
     */
    public static void menu() {
        try (Scanner console = new Scanner(System.in)) {
            menuOptions();
            out.print("> ");
            int choice = Integer.parseInt(console.next());
            out.println();

            do {
                switch (choice) {
                    case EXIT:
                        quit = true;
                        exitApp();
                        break;
                    case 0:
                        menu();
                        break;
                    case 1:
                        numberOptions(console);
                        break;
                    case 2:
                        textOptions(console);
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
                        exitOnError();
                }
            } while (!quit);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            exitOnError();
        }
    }

    private static void menuOptions() {
        StringBuilder builder = new StringBuilder(TITLE);

        builder.append("1. ").append(NumberConstants.TITLE).append("\n")
                .append("2. ").append(TextConstants.TITLE).append("\n")
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
                .append("\n-1. ").append(QUIT_MSG).append("\n");
        out.println(builder.toString());
    }

    private static void exitApp() {
        out.println("... Exiting ...");
        System.exit(0);
    }

    private static void exitOnError() {
        out.println("Invalid Menu Option .. Exiting!");
        System.exit(EXIT);
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
                .append("9. ").append(NumberConstants.TITLE_NUMBER_CONVERTER).append("\n")
                .append("10. ").append(NumberConstants.TITLE_CALCULATOR).append("\n")
                .append("11. ").append(NumberConstants.TITLE_UNIT_CONVERTER).append("\n")
                .append("12. ").append(NumberConstants.TITLE_ALARM_CLOCK).append("\n")
                .append("13. ").append(NumberConstants.TITLE_TWO_CITIES).append("\n")
                .append("14. ").append(NumberConstants.TITLE_CREDIT_CARD_VALIDATOR).append("\n")
                .append("15. ").append(NumberConstants.TITLE_TAX_CALCULATOR).append("\n")
                .append("16. ").append(NumberConstants.TITLE_FACTORIAL_FINDER).append("\n")
                .append("17. ").append(NumberConstants.TITLE_COMPLEX_NUMBER_ALGEBRA).append("\n")
                .append("18. ").append(NumberConstants.TITLE_HAPPY_NUMBERS).append("\n")
                .append("19. ").append(NumberConstants.TITLE_NUMBER_NAMES).append("\n")
                .append("20. ").append(NumberConstants.TITLE_COIN_FLIP).append("\n")
                .append("21. ").append(NumberConstants.TITLE_LIMIT_CALCULATOR).append("\n")
                .append("22. ").append(NumberConstants.TITLE_FAST_EXP).append("\n")
                .append("  \n0. ").append(REPEAT)
                .append("\n-1. ").append(QUIT_MSG);
        out.println(builder.toString());
    }

    //TODO: Refactor this logic so that an invalid entry asks the 
    //User to input the data, at least 3 times before exiting the app.
    private static void numberOptions(Scanner console) {
        try {
            numberMenu();
            out.print("> ");
            int choice = Integer.parseInt(console.next());
            out.println();

            //TODO: Fix the delayed scanner input
            do {
                switch (choice) {
                    case EXIT:
                        quit = true;
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
                    case 10:
                        Calculator.print(console);
                        break;
                    case 11:
                        UnitConverter.display(console);
                        break;
                    case 12:
                        AlarmClock.displayAlarm(console);
                        break;
                    case 13:
                        TwoCities.displayCalculation(console);
                        break;
                    case 14:
                        CreditCardValidator.displayChecksum(console);
                        break;
                    case 15:
                        TaxCalculator.calculateSalesTax(console);
                        break;
                    case 16:
                        FactorialFinder.displayFactorials(console);
                        break;
                    case 17:
                        ComplexNumbers.displayEquation(console);
                        break;
                    case 18:
                        HappyNumbers.displayNumbers(console);
                        break;
                    case 19:
                        NumberNames.displayNames(console);
                        break;
                    case 20:
                        CoinFlip.displayResult(console);
                        break;
                    case 21:
                        LimitCalculator.displayCalculation(console);
                        break;
                    case 22:
                        FastExponentiation.displayResult(console);
                        break;
                    default:
                        exitOnError();
                }
            } while (!quit || menuCounter < 4);
        } catch (Exception e) {
            ++menuCounter;
            AppConstants.printError(e);
            numberOptions(console);
        }

        if (menuCounter == 3)
            exitApp();
    }

    private static void textMenu() {
        StringBuilder builder = new StringBuilder(" - Text Projects - ");

        builder.append("\n1. ").append(TextConstants.TITLE_FIZZ_BUZZ).append("\n")
                .append("2. ").append(TextConstants.TITLE_REVERSE_STRING).append("\n")
                .append("3. ").append(TextConstants.TITLE_PIG_LATIN).append("\n")
                .append("4. ").append(TextConstants.TITLE_COUNT_VOWELS).append("\n")
                .append("5. ").append(TextConstants.TITLE_PALINDROME).append("\n")
                .append("  \n0. ").append(REPEAT)
                .append("\n-1. ").append(QUIT_MSG);
        out.println(builder.toString());
    }

    private static void textOptions(Scanner console) {
        try {
            textMenu();
            out.print("> ");
            int choice = Integer.parseInt(console.next());
            out.println();

            do {
                switch (choice) {
                    case EXIT:
                        quit = true;
                        exitApp();
                        break;
                    case 0:
                        textOptions(console);
                        break;
                    case 1:
                        FizzBuzz.displayText(console);
                        break;
                    case 2:
                        ReverseString.displayReversal(console);
                        break;
                    case 3:
                        PigLatin.displayGame(console);
                        break;
                    case 4:
                        CountVowels.displayVowels(console);
                        break;
                    case 5:
                        Palindrome.displayIfPalindrome(console);
                        break;
                    default:
                        exitOnError();
                }
            } while (!quit || menuCounter < 4);
        } catch (Exception e) {
            ++menuCounter;
            AppConstants.printError(e);
            textOptions(console);
        }

        if (menuCounter == 3)
            exitApp();
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