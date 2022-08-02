package ADVANCED.EXERCISE_3_Sets_And_Maps_Advanced;

import java.lang.management.LockInfo;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P3_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> elements = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] compounds = scanner.nextLine().split(" ");
            elements.addAll(Arrays.asList(compounds));
        }
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
