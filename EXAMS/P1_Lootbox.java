package ADVANCED.EXAMS.Exam_10_22_Feb_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P1_Lootbox {
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
               int toRemove = secondStack.pop();
               firstQueue.offer(toRemove);
            }
        }

        if (firstQueue.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        if (secondStack.isEmpty()){
            System.out.println("Second lootbox is empty");
        }

        if (claimedItems >= 100){
            System.out.println("Your loot was epic! Value: " + claimedItems);
        } else {
            System.out.println("Your loot was poor... Value: " + claimedItems);
        }
    }
}
