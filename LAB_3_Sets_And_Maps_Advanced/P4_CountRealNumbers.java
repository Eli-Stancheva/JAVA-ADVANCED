package ADVANCED.LAB_3_Sets_And_Maps_Advanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P4_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            if (!map.containsKey(input[i])) {
                map.put(input[i], 1);
            } else {
                int curr = map.get(input[i]);
                curr++;
                map.put(input[i], curr);
            }
        }
        for (Double element : map.keySet()) {
            System.out.printf("%.1f -> %d%n", element, map.get(element));
        }
    }
}
