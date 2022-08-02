package ADVANCED.EXERCISE_1_Stacks_Queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P1_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }
       for(int element : stack){
           System.out.print(element + " ");
       }
    }
}
