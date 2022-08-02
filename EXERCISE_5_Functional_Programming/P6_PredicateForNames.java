package ADVANCED.EXERCISE_5_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P6_PredicateForNames {
    public static void main(String[] args) {
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> връща true / false -> test
        //BiFunction<приема1, приема2, връща> -> apply

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split(" ");
        Predicate<String> validNames = name -> name.length() <= n;
        Arrays.stream(names).filter(validNames).forEach(System.out::println);
    }
}
