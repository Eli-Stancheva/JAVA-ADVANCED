package ADVANCED.EXERCISE_5_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class P1_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] people = scanner.nextLine().split(" ");
        Consumer<String> print = System.out::println;
        Arrays.stream(people).forEach(print);
    }
}
