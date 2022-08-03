package ADVANCED.EXAMS.Exam_6_20_February_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P1_MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstBox = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondBox = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> firstQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondStack = new ArrayDeque<>();

        for (int box1 : firstBox) {
            firstQueue.offer(box1);
        }

        for (int box2 : secondBox) {
            secondStack.push(box2);
        }

        int claimedItems = 0;
        while (!firstQueue.isEmpty() && !secondStack.isEmpty()) {
            int currQueue = firstQueue.peek();
            int currStack = secondStack.peek();
            int sum = currQueue + currStack;

            if (sum % 2 == 0) {
                claimedItems += sum;
                firstQueue.poll();
                secondStack.pop();
            } else {
                int lastItemFromSecondBox = secondStack.pop();
                firstQueue.offer(lastItemFromSecondBox);
            }
        }
        if (firstQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else if (secondStack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (claimedItems >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d", claimedItems);
        } else {
            System.out.printf("Poor prey... Value: %d", claimedItems);
        }
    }
}
