package org.example.constants;

public abstract class AppConstants {
   protected AppConstants(){}

   protected static final String APP_NAME = "belum-karan";

   /**
    * Displays an error message to the console.
    * @param e - The Exception whose stack trace will displayed on the console.
    * @param message - The detailed message explaining why the error occurred.
    */
   public static void printError(Exception e, String message) {
      System.err.println(message);
      if(e != null) {
         e.printStackTrace();
      }
      System.out.println("Try again!");
   }
}

