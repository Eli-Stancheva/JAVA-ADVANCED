package ADVANCED.EXAMS.Exam_4_26_June_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P1_OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tasks = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] threads = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int taskToKill = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> threadsQ = new ArrayDeque<>();
        ArrayDeque<Integer> tasksS = new ArrayDeque<>();

        for (int i = 0; i < threads.length; i++) {
            threadsQ.offer(threads[i]);
        }
        for (int i = 0; i < tasks.length; i++) {
            tasksS.push(tasks[i]);
        }

        while (!threadsQ.isEmpty() && !tasksS.isEmpty()){
            int valueThread = threadsQ.peek();
            int valueTasks = tasksS.peek();

            if (taskToKill == valueTasks){
                System.out.printf("Thread with value %d killed task %d\n", valueThread, taskToKill);
                break;
            }

            if (valueThread >= valueTasks){
                threadsQ.poll();
                tasksS.pop();
            }
            if (valueThread < valueTasks){
                threadsQ.poll();
            }
        }
            System.out.println(threadsQ.toString().replaceAll("[\\[\\],]", ""));
    }
}
