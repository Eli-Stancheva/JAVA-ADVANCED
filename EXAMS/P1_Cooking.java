package ADVANCED.EXAMS.Exam_7_16_December_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] liquids = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ingredients = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stackIngredients = new ArrayDeque<>();
        ArrayDeque<Integer> queueLiquids = new ArrayDeque<>();

        for (int liquid : liquids) {
            queueLiquids.offer(liquid);
        }

        for (int ingredient : ingredients) {
            stackIngredients.push(ingredient);
        }

        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;

        while (!stackIngredients.isEmpty() && !queueLiquids.isEmpty()) {
            int currLiquid = queueLiquids.peek();
            int currIngredients = stackIngredients.peek();
            int sum = currLiquid + currIngredients;

            if (sum == 25) {
                bread++;
                stackIngredients.pop();
                queueLiquids.poll();
            } else if (sum == 50) {
                cake++;
                stackIngredients.pop();
                queueLiquids.poll();
            } else if (sum == 75) {
                pastry++;
                stackIngredients.pop();
                queueLiquids.poll();
            } else if (sum == 100) {
                fruitPie++;
                stackIngredients.pop();
                queueLiquids.poll();
            } else {
                queueLiquids.poll();
                int toRemove = stackIngredients.pop() + 3;
                stackIngredients.push(toRemove);
            }
        }
        if (bread >= 1 && cake >= 1 && pastry >= 1 && fruitPie >= 1) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (queueLiquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            String output = queueLiquids.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Liquids left: " + output);
        }

        if (stackIngredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            String output = stackIngredients.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Ingredients left: " + output);
        }

        System.out.println("Bread: " + bread);
        System.out.println("Cake: " + cake);
        System.out.println("Fruit Pie: " + fruitPie);
        System.out.println("Pastry: " + pastry);
    }
}
