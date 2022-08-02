package ADVANCED.EXERCISE_6_Defining_Classes.P1_OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> peopleList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] personInformation = scanner.nextLine().split(" ");
            String name = personInformation[0];
            int age = Integer.parseInt(personInformation[1]);

            if (age > 30) {
                Person person = new Person(name, age);
                peopleList.add(person);
            }
        }

        peopleList.sort(Comparator.comparing(Person::getName));
        peopleList.forEach(p -> System.out.println(p.toString()));
    }
}
