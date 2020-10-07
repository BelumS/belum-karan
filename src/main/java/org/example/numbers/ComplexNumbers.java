package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.Scanner;

/**
 * - Complex Number Algebra -
 * Show addition, multiplication, negation, and inversion of complex numbers in separate functions.
 * (Subtraction and division operations can be made with pairs of these operations.)
 * Print the results for each operation tested.
 */
public final class ComplexNumbers {
    private double real;
    private double img;

    private ComplexNumbers() {
    }

    private ComplexNumbers(double real, double img) {
        this.real = real;
        this.img = img;
    }

    private static ComplexNumbers sum(ComplexNumbers c1, ComplexNumbers c2) {
        var temp = new ComplexNumbers(0, 0);
        temp.real = c1.real + c2.real;
        temp.img = c1.img + c2.img;
        return temp;
    }

    private static ComplexNumbers difference(ComplexNumbers c1, ComplexNumbers c2) {
        var temp = new ComplexNumbers(0, 0);
        temp.real = c1.real - c2.real;
        temp.img = c1.img - c2.img;
        return temp;
    }

    private static ComplexNumbers multiply(ComplexNumbers c1, ComplexNumbers c2) {
        var temp = new ComplexNumbers(0, 0);
        temp.real = c1.real * c2.real;
        temp.img = c1.img * c2.img;
        return temp;
    }

    private static ComplexNumbers divide(ComplexNumbers c1, ComplexNumbers c2) {
        var temp = new ComplexNumbers(0, 0);
        temp.real = c1.real / c2.real;
        temp.img = c1.img / c2.img;
        return temp;
    }

    public static String displayEquation(Scanner scanner) {
        ComplexNumbers c3 = new ComplexNumbers();
        String str = null;
        try {
            System.out.println("Type a real number #1: ");
            String realChoice1 = scanner.next();

            System.out.println("Type a real number #2: ");
            String realChoice2 = scanner.next();

            System.out.println("Type an imaginary number #1: ");
            String imgChoice1 = scanner.next();

            System.out.println("Type an imaginary number #2: ");
            String imgChoice2 = scanner.next();

            System.out.println("Type an operation: ");
            String op = scanner.next();

            double real1 = Double.parseDouble(realChoice1);
            double real2 = Double.parseDouble(imgChoice1);

            double img1 = Double.parseDouble(realChoice2);
            double img2 = Double.parseDouble(imgChoice2);

            var c1 = new ComplexNumbers(real1, img1);
            var c2 = new ComplexNumbers(real2, img2);

            switch (op) {
                case "+":
                    c3 = ComplexNumbers.sum(c1, c2);
                    str = "Sum is: " + c3.real + " + " + c3.img + "i";
                    break;
                case "-":
                    c3 = ComplexNumbers.difference(c1, c2);
                    str = "Difference is: " + c3.real + " + " + c3.img + "i";
                    break;
                case "*":
                    c3 = ComplexNumbers.multiply(c1, c2);
                    str = "Multiplication is: " + NumberConstants.roundedValues(c3.real) + " * " + NumberConstants.roundedValues(c3.img) + "i";
                    break;
                case "/":
                    c3 = ComplexNumbers.divide(c1, c2);
                    str = "Division is: " + NumberConstants.roundedValues(c3.real) + " / " + NumberConstants.roundedValues(c3.img) + "i";
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.err.println("An Exception occurred in: " + e);
            throw e;
        }
        System.out.println(str);
        return str;
    }


}
