package ADVANCED.LAB_1_Stacks_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P1_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();

        String currUrl = "";

        while (!operation.equals("Home")) {
            if (operation.equals("back")){
                if (stack.size() > 1){
                    stack.pop();
                    currUrl = stack.peek();
                    System.out.println(currUrl);
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                stack.push(operation);
                currUrl = stack.peek();
                System.out.println(currUrl);
            }
            operation = scanner.nextLine();
        }
    }
}
