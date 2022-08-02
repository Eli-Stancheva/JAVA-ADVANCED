package ADVANCED.EXERCISE_8_Iterators_Comparators.P4_Froggy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersLake = new ArrayList<>();
        String[] numbers = scanner.nextLine().split(", ");
        for (int i = 0; i < numbers.length; i++) {
            int num = Integer.parseInt(numbers[i]);
            numbersLake.add(num);
        }
        String input = scanner.nextLine();
        Lake lake = new Lake(numbersLake);
        StringBuilder builder = new StringBuilder();

        for (Integer num:lake) {
            builder.append(num).append(", ");
        }
        System.out.println(builder.substring(0,builder.length()-2));
    }
}
