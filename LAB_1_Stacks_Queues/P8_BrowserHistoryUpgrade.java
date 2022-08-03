package ADVANCED.LAB_1_Stacks_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P8_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();

        String currUrl = "";

        while (!operation.equals("Home")) {
            if (operation.equals("back")){
                if (queue.size() > 1){
                    queue.poll();
                    currUrl = queue.peek();
                    System.out.println(currUrl);
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                queue.push(operation);
                currUrl = queue.peek();
                System.out.println(currUrl);
            }
            operation = scanner.nextLine();
        }
    }
}
