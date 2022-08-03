package ADVANCED.LAB_1_Stacks_Queues;

import javax.swing.*;
import java.util.*;

public class P2_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack,input);

        int sum = 0;
        while (stack.size() > 1){
            int number1 = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int number2 = Integer.parseInt(stack.pop());

            if (operation.equals("+")){
                sum = number1 + number2;
            } else if (operation.equals("-")){
                sum = number1 - number2;
            }
            stack.push(String.valueOf(sum));
        }
        System.out.println(stack.peek());
    }
}
