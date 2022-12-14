package ADVANCED.EXERCISE_8_Iterators_Comparators.P3_StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MyStack stack = new MyStack();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] inputParts = input.split("\\s+");
            String command = inputParts[0];

            switch (command) {
                case "Push":
                    int[] elements = Arrays.stream(input.substring(5).trim().split(", ")).mapToInt(Integer::parseInt).toArray();
                    stack.push(elements);
                    break;
                case "Pop":
                    stack.pop();
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < 2; i++) {
            for (int element : stack) {
                System.out.println(element);
            }
        }
    }
}
