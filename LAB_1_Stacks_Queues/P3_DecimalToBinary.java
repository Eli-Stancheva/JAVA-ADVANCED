package ADVANCED.LAB_1_Stacks_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P3_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (input == 0){
            System.out.println(0);
        } else {
            while (input != 0) {
                int rest = input % 2;
                stack.push(rest);
                input = input / 2;
            }
        }

        for (int element : stack) {
            System.out.print(element);
        }
    }
}

