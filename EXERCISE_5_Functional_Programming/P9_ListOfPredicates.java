package ADVANCED.EXERCISE_5_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class P9_ListOfPredicates {
    public static void main(String[] args) {
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> връща true / false -> test
        //BiFunction<приема1, приема2, връща> -> apply
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        BiFunction<Integer, List<Integer>, Boolean> isDivisible = ((num, list) -> {
            for (int number : numberList) {
                for (int i = 1; i <= n; i++) {
                    if (num % number != 0){
                        return  false;
                    }
                }
            }
            return true;
        });

        for (int num = 1; num <= n; num++) {
            if (isDivisible.apply(num, numberList)){
                System.out.print(num + " ");
            }
        }
    }
}
