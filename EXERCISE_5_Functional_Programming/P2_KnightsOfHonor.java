package ADVANCED.EXERCISE_5_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P2_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] people = scanner.nextLine().split(" ");
        Consumer<String> print = p -> System.out.println("Sir " + p);
        Arrays.stream(people).forEach(print);
    }
}
