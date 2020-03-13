package org.example;

import org.example.common.ProjectMenu;

/**
 * The entry point for the application.
 */
public class Application {

    /**
     * The central method of the application, invoked directly by the JVM.
     * @param args an optional array of command line arguments
     */
    public static void main(String[] args) {
        ProjectMenu.menu();
    }
}