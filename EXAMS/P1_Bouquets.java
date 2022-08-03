package ADVANCED.EXAMS.Exam_5_14_April_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P1_Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tulips = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] daffodils = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stackTulips = new ArrayDeque<>();
        ArrayDeque<Integer> queueDaffodils = new ArrayDeque<>();

        for (int t : tulips) {
            stackTulips.push(t);
        }

        for (int d : daffodils) {
            queueDaffodils.offer(d);
        }

        int bouquets = 0;
        int forLater = 0;
        while (!stackTulips.isEmpty() && !queueDaffodils.isEmpty()) {
            int currTulips = stackTulips.peek();
            int currDaffodils = queueDaffodils.peek();
            int sum = currDaffodils + currTulips;

            while (sum > 15) {
                currTulips -= 2;
                sum = currTulips + currDaffodils;
                stackTulips.pop();
                stackTulips.push(currTulips);
            }

            if (sum == 15) {
                bouquets++;
                stackTulips.pop();
                queueDaffodils.poll();
            }

            if (sum < 15) {
                forLater += sum;
                stackTulips.pop();
                queueDaffodils.poll();
            }
        }

        while (forLater >= 15) {
            bouquets++;
            forLater -= 15;
        }

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
