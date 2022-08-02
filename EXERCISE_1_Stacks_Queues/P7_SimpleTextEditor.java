package ADVANCED.EXERCISE_1_Stacks_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P7_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String command = input[0];
                switch (command){
                    case "1":
                        stack.push(builder.toString());
                        String string = input[1];
                        builder.append(string);
                        break;
                    case "2":
                        stack.push(builder.toString());
                        int count = Integer.parseInt(input[1]);
                        int startIndex = builder.length() - count;
                        builder.delete(startIndex, startIndex + count);
                        break;
                    case "3":
                        int index = Integer.parseInt(input[1]);
                        System.out.println(builder.charAt(index - 1));
                        break;
                    case "4":
                        if (!stack.isEmpty()){
                            builder = new StringBuilder(stack.pop());
                        }
                        break;
                }
        }
    }
}
