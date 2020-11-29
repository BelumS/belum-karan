package org.example.constants;

/**
 * The app-related constants shared app-wide
 */
public abstract class AppConstants {
    protected AppConstants() {
    }

    protected static final String APP_NAME = "belum-karan";

    /**
     * Displays an error message to the console.
     *
     * @param e The Exception whose stack trace will displayed on the console.
     */
    public static void printError(Exception e) {
        System.err.println("An Exception occurred " + e.getMessage());
        e.printStackTrace();
        System.out.println("Try again!");
    }
}

