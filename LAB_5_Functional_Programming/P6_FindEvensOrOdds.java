package ADVANCED.LAB_5_Functional_Programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P6_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bounds = scanner.nextLine().split(" ");
        int upperBound = Integer.parseInt(bounds[0]);
        int lowerBound = Integer.parseInt(bounds[1]);
        String command = scanner.nextLine();

        List<Integer> allNumbers = new ArrayList<>();
        for (int i = upperBound; i <= lowerBound; i++) {
            allNumbers.add(i);
        }

        if (command.equals("even")) {
            List<String> resultEven = allNumbers.stream()
                    .filter(e -> e % 2 ==0)
                    .map(e -> e.toString())
                    .collect(Collectors.toList());
            System.out.println(String.join(" ", resultEven));
        } else if (command.equals("odd")) {
            List<String> resultOdd = allNumbers.stream()
                    .filter(e -> e % 2 !=0)
                    .map(e -> e.toString())
                    .collect(Collectors.toList());
            System.out.println(String.join(" ", resultOdd));
        }
    }
}
