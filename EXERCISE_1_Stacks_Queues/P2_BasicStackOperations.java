package ADVANCED.EXERCISE_1_Stacks_Queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P2_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] elements = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int toPush = input[0];
        int toPop = input[1];
        int toCheck = input[2];

        for (int i = 0; i < toPush; i++) {
            stack.push(elements[i]);
        }
        for (int i = 0; i < toPop; i++) {
            stack.pop();
        }
        if (stack.contains(toCheck)){
            System.out.println("true");
        } else {
            if (!stack.isEmpty()){
                System.out.println(Collections.min(stack));
            } else {
                System.out.println(0);
            }
        }
    }
}
