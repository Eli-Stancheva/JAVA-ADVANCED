package ADVANCED.LAB_5_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringNumbers = scanner.nextLine().split(", ");

        List<String> numStrings = Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(e -> e.toString())
                .collect(Collectors.toList());
        System.out.println(String.join(", ", numStrings));

        numStrings = numStrings.stream()
                .map(Integer::parseInt)
                .sorted()
                .map(e -> e.toString())
                .collect(Collectors.toList());
        System.out.println(String.join(", ", numStrings));
    }
}
