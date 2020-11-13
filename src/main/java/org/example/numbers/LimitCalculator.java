package org.example.numbers;

import org.example.common.ValueConstants;

import java.util.Scanner;

/**
 * Limit Calculator - Ask the user to enter f(x) and the limit value,
 * then return the value of the limit statement.
 * <br/>
 * Optional: Make the calculator capable of supporting infinite limits.
 */
public final class LimitCalculator {
    private LimitCalculator() {
    }

    public static double displayCalculation(Scanner scanner) {
        try (scanner) {
            System.out.println("Enter the f(x) equation? ax_b");

            System.out.println("a = ");
            String a = scanner.next();

            System.out.println("Exponent?: ");
            String expChoice = scanner.next();

            String exp = "1";
            if (ValueConstants.VALUE_Y.equalsIgnoreCase(expChoice)) {
                exp = scanner.next();
            }

            System.out.println("Operand = ");
            String operand = scanner.next();

            System.out.println("b = ");
            String b = scanner.next();

            System.out.println();
            String equation = a + "x^" + exp + " " + operand + " " + b;

            System.out.println("The Limit Value = ");
            String limitValue = scanner.next();

            double result = f(a, exp, operand, b, limitValue);
            System.out.println("f(x)=" + equation + " with lim(x -> " + limitValue + ") = " + result);
            return result;
        } catch (Exception e) {
            System.err.println("An Exception occurred: " + e);
            e.printStackTrace();
            throw e;
        }
    }

    private static double f(String aValue, String expValue, String operand, String bValue, String limitValue) {
        double a = Double.parseDouble(aValue);
        double exp = Double.parseDouble(expValue);
        double b = Double.parseDouble(bValue);
        double limit = Double.parseDouble(limitValue);

        double y = Math.pow(a * limit, exp);
        switch (operand) {
            case "+":
                return y + b;
            case "-":
                return y - b;
            case "*":
                return y * b;
            case "/":
                return y / b;
            default:
                throw new IllegalArgumentException("'" + operand + "' is not a valid math operand!");
        }
    }
}
