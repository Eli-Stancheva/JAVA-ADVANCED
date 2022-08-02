package ADVANCED.EXERCISE_8_Iterators_Comparators.P5_ComparingObjects;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] personInfo = input.split("\\s+");
            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]), personInfo[2]);
            people.add(person);
            input = scanner.nextLine();
        }
        int counterALike = 0;
        int counter = 0;
        int index = Integer.parseInt(scanner.nextLine());
        Person personToComp = people.get(index-1);
        for (Person person:people) {
            counter++;
            if (counter!=index) {
                if (personToComp.compareTo(person) == 0) {
                    counterALike++;
                }
            }else {
                continue;
            }
        }
        if (counterALike>0) {
            System.out.printf("%d %d %d",counterALike+1,people.size()-(counterALike+1),people.size());
        }else {
            System.out.println("No matches");
        }
    }
}
