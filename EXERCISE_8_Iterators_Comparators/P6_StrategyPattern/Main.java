package ADVANCED.EXERCISE_8_Iterators_Comparators.P6_StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ComparatorName comparatorName = new ComparatorName();
        ComparatorAge comparatorAge = new ComparatorAge();
        TreeSet<Person> peopleNames = new TreeSet<>(comparatorName);
        TreeSet<Person> peopleAge = new TreeSet<>(comparatorAge);
        int peopleNum = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < peopleNum; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]));
            peopleNames.add(person);
            peopleAge.add(person);
        }
        for (Person personN:peopleNames) {
            System.out.println(personN);
        }
        for (Person personA:peopleAge) {
            System.out.println(personA);
        }
    }
}
