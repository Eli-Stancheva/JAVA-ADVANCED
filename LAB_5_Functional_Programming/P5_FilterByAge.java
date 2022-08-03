package ADVANCED.LAB_5_Functional_Programming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class P5_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> people = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] infoPerson = scanner.nextLine().split(", ");
            String personName = infoPerson[0];
            int personAge = Integer.parseInt(infoPerson[1]);
            people.put(personName, personAge);
        }

        String condition = scanner.nextLine();
        int limitAge = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        BiPredicate<Integer, Integer> isValid;
        if (condition.equals("younger")) {
            isValid = (personAge, age) -> personAge <= age;
        } else {
            isValid = (personAge, age) -> personAge >= age;
        }

        Consumer<Map.Entry<String, Integer>> print;
        if (format.equals("age")) {
            print = p -> System.out.println(p.getValue());
        } else if (format.equals("name")) {
            print = p -> System.out.println(p.getKey());
        } else {
            print = p -> System.out.printf("%s - %d\n", p.getKey(), p.getValue());
        }

        people.entrySet()
                .stream()
                .filter(p -> isValid.test(p.getValue(), limitAge))
                .forEach(print);
    }
}
