package ADVANCED.LAB_5_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P3_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));

        List<String> list = Arrays.stream(input)
                .filter(isUpperCase)
                .collect(Collectors.toList());

        System.out.println(list.size());
        System.out.println(String.join("\n", list));
    }
}
