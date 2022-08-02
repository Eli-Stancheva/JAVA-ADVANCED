package ADVANCED.EXERCISE_5_Functional_Programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P5_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int divider = Integer.parseInt(scanner.nextLine());
        Collections.reverse(numbers);

        numbers.stream()
                .filter(n -> n % divider != 0)
                .forEach(e -> System.out.print(e + " "));

        //начин 2
        //Predicate<Integer> checkDivision = number -> number % divider == 0;
        //numbers.removeIf(checkDivision);
        //numbers.forEach(n -> System.out.print(n + " "));
    }
}
