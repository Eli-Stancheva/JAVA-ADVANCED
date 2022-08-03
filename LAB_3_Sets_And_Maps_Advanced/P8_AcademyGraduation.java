package ADVANCED.LAB_3_Sets_And_Maps_Advanced;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P8_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> map = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] score = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

            double sum = 0;
            for (int j = 0; j < score.length; j++) {
                sum += score[j];
            }
            double avg = sum / score.length;
            map.put(name, avg);
        }
        map.entrySet().stream().forEach(e -> {
            DecimalFormat curr = new DecimalFormat("0.############################################");
            System.out.print(e.getKey() + " is graduated with " + curr.format(e.getValue()) + "\n");
        });
    }
}
