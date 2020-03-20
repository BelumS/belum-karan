package org.example.numbers;

import org.example.common.NumberConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;
import static org.example.common.NumberConstants.INVALID_INPUT;
import static org.example.common.NumberConstants.roundedValues;

public final class Calculator {
    private Calculator() {
    }

    public static double print(Scanner console) {
        try {
            out.println("Choose [N]ormal or [S]cientific Mode.");
            String mode = console.next();
            out.println();

            switch (mode.toLowerCase()) {
                case "n":
                    out.print("Enter the calculation: ");
                    String[] normal = console.nextLine().split(" ");
                    out.println();
                    return testNormal(normal[1], Double.parseDouble(normal[0]), Double.parseDouble(normal[2]));
                case "s":
                    out.print("Enter the scientific calculation: ");
                    String[] science = console.nextLine().split(" ");
                    out.println();
                    return testScientific(science[0], Double.parseDouble(science[1]));
                default:
                    throw new AssertionError(INVALID_INPUT);
            }
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

    private static double testNormal(String operation, double x, double y) {
        BinaryOperation op;
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

    //TODO: Add more operations, and store a history of the calculations
    private static double testScientific(String operation, double val) {
        Map<String, Double> memory = new LinkedHashMap<>();
        UnaryOperation op;
        double result;

        switch (operation.toLowerCase()) {
            case "sqrt":
                op = ScientificOperation.SQRT;
                result = ScientificOperation.SQRT.apply(val);
                break;
            case "e":
                op = ScientificOperation.E;
                result = ScientificOperation.E.apply(val);
                break;
            default:
                throw new AssertionError(NumberConstants.INVALID_INPUT);
        }
        memory.put(String.format("%s(%.2f) = %.2f%n", op, val, result), result);
        memory.forEach(out::printf);
        return result;
    }

    @FunctionalInterface
    private interface UnaryOperation {
        double apply(double val1);
    }

    @FunctionalInterface
    private interface BinaryOperation {
        double apply(double val1, double val2);
    }

    private enum BasicOperation implements BinaryOperation {
        ADD("+") {
            @Override
            public double apply(double val1, double val2) {
                return roundedValues(val1 + val2);
            }
        },
        SUBTRACT("-") {
            @Override
            public double apply(double val1, double val2) {
                return roundedValues(val1 - val2);
            }
        },
        MULTIPLY("*") {
            @Override
            public double apply(double val1, double val2) {
                return roundedValues(val1 * val2);
            }
        },
        DIVIDE("/") {
            @Override
            public double apply(double val1, double val2) {
                return roundedValues(val1 / val2);
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

    private enum AdvancedOperation implements BinaryOperation {
        REMAINDER("%") {
            @Override
            public double apply(double val1, double val2) {
                return roundedValues(val1 % val2);
            }
        },
        EXP("^") {
            @Override
            public double apply(double val1, double val2) {
                return roundedValues(Math.pow(val1, val2));
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

    //TODO: Add sqrt and PI symbols from a word processor
    private enum ScientificOperation implements UnaryOperation {
       SQRT("sqrt"){ @Override public double apply(double val) { return Math.sqrt(val); }},

        //TODO: Implement Factorial using recursion
       FACTORIAL("!"){ @Override public double apply(double val) { return 0; }},
       E("e"){ @Override public double apply(double val) { return roundedValues(Math.E * val); }},
       PI("PI"){ @Override public double apply(double val) { return roundedValues(Math.PI * val); }},
       SIN("sin"){@Override public double apply(double val) { return Math.sin(val); }},
       COS("cos"){ @Override public double apply(double val) { return Math.cos(val); }},
       TAN("tan"){ @Override public double apply(double val) { return Math.tan(val); }},
       LOG("log"){ @Override public double apply(double val) { return Math.log10(val); }},
       NAT_LOG("ln"){ @Override public double apply(double val) { return Math.log(val); }},

        //TODO: Implement inversion
       INVERSE("inv"){ @Override public double apply(double val) { return 0; }};

       private String symbol;

       ScientificOperation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return this.symbol;
        }
    }
}
