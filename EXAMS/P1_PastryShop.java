package ADVANCED.EXAMS.Exam_3_18_August_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquids = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] ingredients = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queueLiquids = new ArrayDeque<>();
        ArrayDeque<Integer> stackIngredients = new ArrayDeque<>();

        for (int i = 0; i < liquids.length; i++) {
            queueLiquids.offer(liquids[i]);
        }
        for (int i = 0; i < ingredients.length; i++) {
            stackIngredients.push(ingredients[i]);
        }

        int countBiscuit = 0;
        int countCake = 0;
        int countPastry = 0;
        int countPie = 0;

        while (!queueLiquids.isEmpty() && ! stackIngredients.isEmpty()){
            int currLiquids = queueLiquids.peek();
            int currIngredients = stackIngredients.peek();
            int sum = currLiquids + currIngredients;

            if (sum == 25){
                countBiscuit++;
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (sum == 50){
                countCake++;
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (sum == 75){
                countPastry++;
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (sum == 100){
                countPie++;
                queueLiquids.poll();
                stackIngredients.pop();
            } else {
                queueLiquids.poll();
                int toIncrease = stackIngredients.pop() + 3;
                stackIngredients.push(toIncrease);
            }
        }

        if (countBiscuit >= 1 && countCake >= 1 && countPastry >= 1 && countPie >= 1){
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (queueLiquids.isEmpty()){
            System.out.println("Liquids left: none");
        } else {
            String output = queueLiquids.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Liquids left: " + output);
        }

        if (stackIngredients.isEmpty()){
            System.out.println("Ingredients left: none");
        } else {
            String output = stackIngredients.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Ingredients left: " + output);
        }

        System.out.printf("Biscuit: %d\n", countBiscuit);
        System.out.printf("Cake: %d\n", countCake);
        System.out.printf("Pie: %d\n", countPie);
        System.out.printf("Pastry: %d", countPastry);
    }
}
