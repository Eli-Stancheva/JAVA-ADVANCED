package ADVANCED.LAB_3_Sets_And_Maps_Advanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class P3_Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> player1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> player2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 50; i++) {
            if (player1.isEmpty()) {
                System.out.println("Second player win!");
                return;
            }
            if (player2.isEmpty()) {
                System.out.println("First player win!");
                return;
            }

            int cardFirst = player1.iterator().next();
            int cardSecond = player2.iterator().next();

            player1.remove(cardFirst);
            player2.remove(cardSecond);

            if (cardFirst > cardSecond) {
                player1.add(cardFirst);
                player1.add(cardSecond);
            } else if (cardFirst < cardSecond) {
                player2.add(cardFirst);
                player2.add(cardSecond);
            }
        }

        int firstSize = player1.size();
        int secondSize = player2.size();

        if (firstSize > secondSize){
            System.out.println("First player win!");
        } else if (secondSize > firstSize){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
