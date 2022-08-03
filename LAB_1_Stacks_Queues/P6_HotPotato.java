package ADVANCED.LAB_1_Stacks_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P6_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String element : children) {
            queue.offer(element);
        }

        while (queue.size() != 1){
            for (int i = 1; i < n; i++) {
                String curr = queue.poll();
                queue.offer(curr);
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}
