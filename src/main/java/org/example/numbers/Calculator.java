package org.example.numbers;

import org.example.common.NumberConstants;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.System.err;
import static java.lang.System.out;

public final class Calculator {
    private Calculator() {
    }

    public static double print(Scanner console) {
        try {
            out.print("Enter the one line calculation: ");
            String[] inputs = console.nextLine().split(" ");
            out.println();

            return test(inputs[1], Double.parseDouble(inputs[0]), Double.parseDouble(inputs[2]));
        } catch (ArithmeticException | NumberFormatException e) {
            err.println(e.getMessage());
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            err.println(e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    private static double test(String operation, double x, double y) {
        Operation op;
        double result;

        switch (operation) {
            case "+":
                op = BasicOperation.ADD;
                result = BasicOperation.ADD.apply(x, y);
                break;
            case "-":
                op = BasicOperation.SUBTRACT;
                result = BasicOperation.SUBTRACT.apply(x, y);
                break;
            case "*":
                op = BasicOperation.MULTIPLY;
                result = BasicOperation.MULTIPLY.apply(x, y);
                break;
            case "/":
                assert y != 0;
                op = BasicOperation.DIVIDE;
                result = BasicOperation.DIVIDE.apply(x, y);
                break;
            case "%":
                op = AdvancedOperation.REMAINDER;
                result = AdvancedOperation.REMAINDER.apply(x, y);
                break;
            case "^":
                op = AdvancedOperation.EXP;
                result = AdvancedOperation.EXP.apply(x, y);
                break;
            default:
                throw new IllegalArgumentException(NumberConstants.INVALID_INPUT);
        }
        out.printf("%.2f %s %.2f = %.2f%n", x, op, y, result);
        return result;
    }

    private interface Operation {
        double apply(double val1, double val2);

        static double roundedValues(double val) {
            return BigDecimal.valueOf(val).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
    }

    private enum BasicOperation implements Operation {
        ADD("+") {
            @Override
            public double apply(double val1, double val2) {
                return Operation.roundedValues(val1 + val2);
            }
        },
        SUBTRACT("-") {
            @Override
            public double apply(double val1, double val2) {
                return Operation.roundedValues(val1 - val2);
            }
        },
        MULTIPLY("*") {
            @Override
            public double apply(double val1, double val2) {
                return Operation.roundedValues(val1 * val2);
            }
        },
        DIVIDE("/") {
            @Override
            public double apply(double val1, double val2) {
                return Operation.roundedValues(val1 / val2);
            }
        };

        private String symbol;

        BasicOperation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return this.symbol;
        }
    }

    private enum AdvancedOperation implements Operation {
        REMAINDER("%") {
            @Override
            public double apply(double val1, double val2) {
                return Operation.roundedValues(val1 % val2);
            }
        },
        EXP("^") {
            @Override
            public double apply(double val1, double val2) {
                return Operation.roundedValues(Math.pow(val1, val2));
            }
        };

        private String symbol;

        AdvancedOperation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return this.symbol;
        }
    }
}
