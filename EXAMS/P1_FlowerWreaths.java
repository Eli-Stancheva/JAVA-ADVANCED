package ADVANCED.EXAMS.Exam_8_19_August_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P1_FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lilies = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] roses = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stackLilies = new ArrayDeque<>();
        ArrayDeque<Integer> queueRoses = new ArrayDeque<>();

        for (int lily : lilies) {
            stackLilies.push(lily);
        }

        for (int rose : roses) {
            queueRoses.offer(rose);
        }

        int wreaths = 0;
        int storedSum = 0;
        while (stackLilies.size() > 0 && queueRoses.size() > 0) {
            int sum = stackLilies.peek() + queueRoses.peek();

            if (sum == 15) {
                wreaths++;
                stackLilies.pop();
                queueRoses.poll();
            } else if (sum > 15) {
                stackLilies.push(stackLilies.pop() - 2);
            } else {
                storedSum += sum;
                stackLilies.pop();
                queueRoses.poll();
            }
        }
        while (storedSum > 15) {
            wreaths++;
            storedSum -= 15;
        }

        if (wreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }
}
