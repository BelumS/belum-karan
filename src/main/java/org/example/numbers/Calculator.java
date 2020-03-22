package org.example.numbers;

import org.example.common.NumberConstants;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;
import static org.example.common.NumberConstants.*;

public final class Calculator {
    private Calculator() {
    }

    public static double print(Scanner console) {
        try {
            out.println();
            out.println("Choose [N]ormal, [S]cientific, [I]nverse Mode, [R]eturn, or [Q]uit: ");
            String mode = console.nextLine();

            switch (mode.toLowerCase()) {
                case "n":
                    out.println("Enter the calculation [+|-|*|/|^|%]");
                    String[] normal = console.nextLine().split(" ");
                    return testNormal(normal[1], Double.parseDouble(normal[0]), Double.parseDouble(normal[2]));
                case "s":
                    out.println("Enter the scientific calculation [!|sqrt|PI|e|sin|cos|tan|log|ln]");
                    String[] science = console.nextLine().split(" ");
                    return testScientific(science[0], Double.parseDouble(science[1]));
                case "i":
                    out.println("Enter the inverse calculation [i'(sqrt|sin|cos|tan|log|ln)']");
                    String[] inverse = console.nextLine().split(" ");
                    return testInverse(inverse[0], Double.parseDouble(inverse[1]));
                case "r":
                    print(console);
                    return 0;
                case "q":
                    out.println("Powering down...");
                    System.exit(0);
                    return 0;
                default:
                    throw new AssertionError(INVALID_INPUT);
            }
        } catch (ArithmeticException | NumberFormatException e) {
            NumberConstants.printError(e, e.getMessage());
            throw e;
        } catch (Exception e) {
            NumberConstants.printError(e, e.getMessage());
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

    private static double testScientific(String operation, double val) {
        Map<String, Double> memory = new LinkedHashMap<>();
        boolean symbolAfter = false;
        UnaryOperation op;
        double result;

        switch (operation.toLowerCase()) {
            case "sqrt":
                op = ScientificOperation.SQRT;
                result = ScientificOperation.SQRT.apply(val);
                break;
            case "e":
                symbolAfter = true;
                op = ScientificOperation.E;
                result = ScientificOperation.E.apply(val);
                break;
            case "pi":
                symbolAfter = true;
                op = ScientificOperation.PI;
                result = ScientificOperation.PI.apply(val);
                break;
            case "!":
                symbolAfter = true;
                op = ScientificOperation.FACTORIAL;
                result = ScientificOperation.FACTORIAL.apply(val);
                break;
            case "sin":
                op = ScientificOperation.SIN;
                result = ScientificOperation.SIN.apply(val);
                break;
            case "cos":
                op = ScientificOperation.COS;
                result = ScientificOperation.COS.apply(val);
                break;
            case "tan":
                op = ScientificOperation.TAN;
                result = ScientificOperation.TAN.apply(val);
                break;
            case "log":
                op = ScientificOperation.LOG;
                result = ScientificOperation.LOG.apply(val);
                break;
            case "ln":
                op = ScientificOperation.NAT_LOG;
                result = ScientificOperation.NAT_LOG.apply(val);
                break;
            default:
                throw new AssertionError(NumberConstants.INVALID_INPUT);
        }
        if (symbolAfter)
            memory.put(String.format("(%.2f)%s = %.2f%n", val, op, result), result);
        else
            memory.put(String.format("%s(%.2f) = %.2f%n", op, val, result), result);
        memory.forEach(out::printf);
        return result;
    }

    private static double testInverse(String operation, double val) {
        Map<String, Double> memory = new LinkedHashMap<>();
        boolean symbolAfter = false;
        UnaryOperation op;
        double result;

        switch (operation.toLowerCase()) {
            case "isqrt":
                symbolAfter = true;
                op = InverseOperation.INV_SQRT;
                result = InverseOperation.INV_SQRT.apply(val);
                break;
            case "isin":
                op = InverseOperation.INV_SIN;
                result = InverseOperation.INV_SIN.apply(val);
                break;
            case "icos":
                op = InverseOperation.INV_COS;
                result = InverseOperation.INV_COS.apply(val);
                break;
            case "itan":
                op = InverseOperation.INV_TAN;
                result = InverseOperation.INV_TAN.apply(val);
                break;
            case "ilog":
                op = InverseOperation.INV_LOG;
                result = InverseOperation.INV_LOG.apply(val);
                break;
            case "iln":
                op = InverseOperation.INV_NAT_LOG;
                result = InverseOperation.INV_NAT_LOG.apply(val);
                break;
            default:
                throw new AssertionError(NumberConstants.INVALID_INPUT);
        }
        if (symbolAfter)
            memory.put(String.format("(%.2f)%s = %.2f%n", val, op, result), result);
        else
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

    private enum ScientificOperation implements UnaryOperation {
       SQRT("√"){ @Override public double apply(double val) { return Math.sqrt(val); }},
       FACTORIAL("!"){
           @Override
           public double apply(double val) {
            if(val > 20) throw new ArithmeticException(INTEGER_OVERFLOW);
            return roundedValues((val < 1) ? 1 :val * apply(val - 1));
        }
       },
       E("e"){ @Override public double apply(double val) { return roundedValues(Math.E * val); }},
       PI("π"){ @Override public double apply(double val) { return roundedValues(Math.PI * val); }},
       SIN("sin"){@Override public double apply(double val) { return Math.sin(val); }},
       COS("cos"){ @Override public double apply(double val) { return Math.cos(val); }},
       TAN("tan"){ @Override public double apply(double val) { return Math.tan(val); }},
       LOG("log"){ @Override public double apply(double val) { return Math.log10(val); }},
       NAT_LOG("ln"){ @Override public double apply(double val) { return Math.log(val); }};

       private String symbol;

       ScientificOperation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return this.symbol;
        }
    }

    private enum InverseOperation implements UnaryOperation {
        INV_SQRT("^2"){ @Override public double apply(double val) { return Math.pow(val, 2); }},
        INV_SIN("sin^-1"){@Override public double apply(double val) { return Math.pow(Math.sin(val), -1); }},
        INV_COS("cos^-1"){ @Override public double apply(double val) { return Math.pow(Math.cos(val), -1); }},
        INV_TAN("tan^-1"){ @Override public double apply(double val) { return Math.pow(Math.tan(val), -1); }},
        INV_LOG("10^"){ @Override public double apply(double val) { return Math.pow(10, val); }},
        INV_NAT_LOG("e^"){ @Override public double apply(double val) { return Math.pow(Math.E, val); }};

        private String symbol;

        InverseOperation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return this.symbol;
        }
    }
}
