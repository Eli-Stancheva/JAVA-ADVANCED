package ADVANCED.EXERCISE_5_Functional_Programming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P8_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> връща true / false -> test
        //BiFunction<приема1, приема2, връща> -> apply

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> even = numbers.stream().filter(e -> e % 2 == 0).sorted().collect(Collectors.toList());
        List<Integer> odd = numbers.stream().filter(e -> e % 2 != 0).sorted().collect(Collectors.toList());
        even.forEach(e -> System.out.print(e + " "));
        odd.forEach(e -> System.out.print(e + " "));

        //вариант 2
        /*Comparator<Integer> comparator = ((first, second) -> {
               if (first % 2 == 0 && second % 2 != 0) {            //първо четно, второ нечетно -> не разменяме
                return -1;
            } else if (first % 2 != 0 && second % 2 == 0){        //първо нечетно, второ четно -> размяна
                return 1;
            } else {                                             //първо четно, второто четно   //първи нечетно, второто нечетно
                 return first.compareTo(second);
                //first == second -> 0 -> няма размяна
                //first < second -> -1 -> няма размяна
                //first > second -> 1 -> има размяна
            }
        });
        numbers.stream().sorted(comparator).forEach(n -> System.out.print(n + " "));
        */
    }
}

