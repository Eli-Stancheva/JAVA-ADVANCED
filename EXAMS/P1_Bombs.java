package ADVANCED.EXAMS.Exam_9_28_June_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] effects = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] casings = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stackCasing = new ArrayDeque<>();
        ArrayDeque<Integer> queueEffects = new ArrayDeque<>();

        for (int c : casings) {
            stackCasing.push(c);
        }

        for (int e : effects) {
            queueEffects.offer(e);
        }

        int countDatura = 0;
        int countCherry = 0;
        int countSmoke = 0;

        while (!stackCasing.isEmpty() && !queueEffects.isEmpty()) {
            int currEffect = queueEffects.peek();
            int currCasing = stackCasing.peek();
            int sum = currEffect + currCasing;

            if (sum == 40) {
                countDatura++;
                stackCasing.pop();
                queueEffects.poll();
            } else if (sum == 60) {
                countCherry++;
                stackCasing.pop();
                queueEffects.poll();
            } else if (sum == 120) {
                countSmoke++;
                stackCasing.pop();
                queueEffects.poll();
            } else {
                stackCasing.push(stackCasing.pop() - 5);
            }
            if (countDatura >= 3 && countCherry >= 3 && countSmoke >= 3) {
              break;
            }
        }

        if (countDatura >= 3 && countCherry >= 3 && countSmoke >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (queueEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            String output = queueEffects.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Bomb Effects: " + output);
        }

        if (stackCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            String output = stackCasing.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Bomb Casings: " + output);
        }

        System.out.println("Cherry Bombs: " + countCherry);
        System.out.println("Datura Bombs: " + countDatura);
        System.out.println("Smoke Decoy Bombs: " + countSmoke);
    }
}
