package ADVANCED.EXAMS.EXAM_11_17_December_2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] materials = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] magic = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> magicQueue = new ArrayDeque<>();
        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();

        for (int box1 : magic) {
            magicQueue.offer(box1);
        }

        for (int box2 : materials) {
            materialsStack.push(box2);
        }

        int doll = 0;
        int train = 0;
        int bear = 0;
        int bicycle = 0;
        while (!magicQueue.isEmpty() && !materialsStack.isEmpty()) {
            int currMagic = magicQueue.peek();
            int currMaterial = materialsStack.peek();
            int totalLevel = currMaterial * currMagic;

            if (totalLevel == 150) {
                doll++;
                magicQueue.poll();
                materialsStack.pop();
            } else if (totalLevel == 250) {
                train++;
                magicQueue.poll();
                materialsStack.pop();
            } else if (totalLevel == 300) {
                bear++;
                magicQueue.poll();
                materialsStack.pop();
            } else if (totalLevel == 400) {
                bicycle++;
                magicQueue.poll();
                materialsStack.pop();
            } else {
                if (currMagic == 0 || currMaterial == 0) {
                    if (currMagic == 0) {
                        magicQueue.poll();
                    }
                    if (currMaterial == 0) {
                        materialsStack.pop();
                    }
                    if (currMagic == 0 && currMaterial == 0) {
                        magicQueue.poll();
                        materialsStack.pop();
                    }
                }
                if (totalLevel < 0) {
                    totalLevel = currMagic + currMaterial;
                    magicQueue.poll();
                    materialsStack.pop();
                    materialsStack.push(totalLevel);
                } else if (totalLevel > 0) {
                    magicQueue.poll();
                    int newMaterialValue = materialsStack.pop() + 15;
                    materialsStack.push(newMaterialValue);
                }
            }
        }

        if ((doll > 0 && train > 0) || (bear > 0 && bicycle > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!magicQueue.isEmpty()) {
            String output = magicQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Magic left: " + output);
        }

        if (!materialsStack.isEmpty()) {
            String output = materialsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Materials left: " + output);
        }

        if (bicycle >= 1) {
            System.out.println("Bicycle: " + bicycle);
        }
        if (doll >= 1) {
            System.out.println("Doll: " + doll);
        }
        if (bear >= 1) {
            System.out.println("Teddy bear: " + bear);
        }
        if (train >= 1) {
            System.out.println("Wooden train: " + train);
        }
    }
}
