package ADVANCED.EXERCISE_1_Stacks_Queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P4_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] commands = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int toPush = commands[0];
        int toPoll = commands[1];
        int toCheck = commands[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < toPush; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < toPoll; i++) {
            queue.poll();
        }

        if (queue.isEmpty()){
            System.out.println(0);
        } else if (queue.contains(toCheck)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
