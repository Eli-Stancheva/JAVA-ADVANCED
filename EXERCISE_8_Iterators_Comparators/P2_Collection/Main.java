package ADVANCED.EXERCISE_8_Iterators_Comparators.P2_Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String command = scanner.nextLine();
        ListyIterator listyIterator = new ListyIterator();
        listyIterator.create(input);

        while (!command.equals("END")) {
            switch (command) {
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
                default:
                    break;

            }
            command = scanner.nextLine();;
        }
    }
}
