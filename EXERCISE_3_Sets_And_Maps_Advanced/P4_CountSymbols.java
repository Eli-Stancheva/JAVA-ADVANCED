package ADVANCED.EXERCISE_3_Sets_And_Maps_Advanced;

import java.util.*;

public class P4_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> map = new TreeMap<>();
        String input = scanner.nextLine();
        for(char el : input.toCharArray()){
            if (map.containsKey(el)){
                map.put(el, map.get(el) + 1);
            } else {
                map.put(el, 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.printf("%s: %d time/s\n", entry.getKey(), entry.getValue());
        }
    }
}
