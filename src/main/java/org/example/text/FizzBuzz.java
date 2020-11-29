package org.example.text;

import org.example.constants.AppConstants;
import org.example.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Represents the FizzBuzz algorithm
 */
public final class FizzBuzz {
    private FizzBuzz() {
    }

    public static List<String> displayText(Scanner scanner) {
        try(scanner) {
            System.out.println("Generate FizzBuzz up to what number? ");
            String limit = scanner.next();

            if (StringUtils.isNotBlank(limit) && Integer.parseInt(limit) > 0) {
                var list = fizzBuzzStream(Integer.parseInt(limit));
                System.out.println("Generated " + list);
                return list;
            }
            return new ArrayList<>();
        } catch (Exception e) {
            AppConstants.printError(e);
            throw e;
        }
    }

    /**
     * Generates the FizzBuzz algorithm
     *
     * @param limit the integer upper bound for the algorithm
     * @return the list of values for the algorithm
     */
    private static List<String> fizzBuzzStream(int limit) {
        return IntStream.rangeClosed(1, limit)
                .mapToObj(n -> (n % 5 == 0 || n % 3 == 0)
                        ? ((n % 3 == 0) ? "Fizz" : "") + ((n % 5 == 0) ? "Buzz" : "")
                        : Integer.toString(n))
                .collect(Collectors.toList());
    }
}
