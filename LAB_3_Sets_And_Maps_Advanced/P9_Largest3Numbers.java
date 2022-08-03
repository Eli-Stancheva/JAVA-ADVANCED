package ADVANCED.LAB_3_Sets_And_Maps_Advanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P9_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(e -> System.out.print(e + " "));
    }
}
