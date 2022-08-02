package ADVANCED.EXERCISE_5_Functional_Programming;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P3_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Consumer<List<Integer>> printMinNum = list -> System.out.println(Collections.min(list));
        printMinNum.accept(numbers);
    }
}
