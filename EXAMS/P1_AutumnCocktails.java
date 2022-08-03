package ADVANCED.EXAMS.Exam_2_23_October_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P1_AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ingredientsNumber = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] ingredientsFreshness = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> bucketQ = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessS = new ArrayDeque<>();

        for (int i = 0; i < ingredientsNumber.length; i++) {
            bucketQ.offer(ingredientsNumber[i]);
        }
        for (int i = 0; i < ingredientsFreshness.length; i++) {
            freshnessS.push(ingredientsFreshness[i]);
        }

        int countPearSour = 0;
        int countTheHarvest = 0;
        int countAppleHinny = 0;
        int countHighFashion = 0;

        while (!bucketQ.isEmpty() && !freshnessS.isEmpty()) {
            int bucket = bucketQ.peek();
            int freshness = freshnessS.peek();
            int totalFreshness = bucket * freshness;

            if (bucket == 0) {
                bucketQ.poll();
                continue;
            }

            if (totalFreshness == 150) {
                countPearSour++;
                bucketQ.poll();
                freshnessS.pop();
            } else if (totalFreshness == 250) {
                countTheHarvest++;
                bucketQ.poll();
                freshnessS.pop();
            } else if (totalFreshness == 300) {
                countAppleHinny++;
                bucketQ.poll();
                freshnessS.pop();
            } else if (totalFreshness == 400) {
                countHighFashion++;
                bucketQ.poll();
                freshnessS.pop();
            } else {
                freshnessS.pop();
                int currBucket = bucketQ.poll() + 5;
                bucketQ.offer(currBucket);
            }
        }

        if (countPearSour >= 1 && countTheHarvest >= 1 && countAppleHinny >= 1 && countHighFashion >= 1) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!bucketQ.isEmpty()) {
            int sumIng = 0;
            for (Integer integer : bucketQ) {
                sumIng += integer;
            }
            System.out.println("Ingredients left: " + sumIng);
        }

        if (countAppleHinny > 0) {
            System.out.println(" # Apple Hinny --> " + countAppleHinny);
        }

        if (countHighFashion > 0) {
            System.out.println(" # High Fashion --> " + countHighFashion);
        }

        if (countPearSour > 0) {
            System.out.println(" # Pear Sour --> " + countPearSour);
        }

        if (countTheHarvest > 0) {
            System.out.println(" # The Harvest --> " + countTheHarvest);
        }
    }
}
