package ADVANCED.EXERCISE_5_Functional_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> връща true / false -> test
        //BiFunction<приема1, приема2, връща> -> apply

        List<String> people = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] data = input.split(" ");
            String command = data[0];
            String criteria = data[1];
            String string = data[2];

            Predicate<String> predicate = null;

            if (criteria.equals("Length")) {
                predicate = x -> x.length() == Integer.parseInt(string);
            } else if (criteria.equals("StartsWith")) {
                predicate = x -> x.startsWith(string);
            } else {
                predicate = x -> x.endsWith(string);
            }

            if (command.equals("Remove")) {
                List<String> toRemove = new ArrayList<>();
                for (String person : people) {
                    if (predicate.test(person)) {
                        toRemove.add(person);
                    }
                }
                people.removeAll(toRemove);
            } else {
                List<String> toAdd = new ArrayList<>();
                for (String person : people) {
                    if (predicate.test(person)) {
                        toAdd.add(person);
                    }
                }
                people.addAll(toAdd);
            }
            input = scanner.nextLine();
        }
        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(people.stream().sorted().collect(Collectors.toCollection(ArrayList::new)).toString().replaceAll("([\\[\\]])", "") + " are going to the party!");
        }
    }
}
