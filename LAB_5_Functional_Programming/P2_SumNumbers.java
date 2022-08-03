package ADVANCED.LAB_5_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P2_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        Function<String, Integer> parser = Integer::parseInt;

        List<Integer> numbers = Arrays.stream(input)
                .map(parser)
                .collect(Collectors.toList());
        System.out.print("Count = " + numbers.size() + "\n");

        int sum = Arrays.stream(input).mapToInt(Integer::parseInt).sum();
        System.out.print("Sum = " + sum);
    }
}
