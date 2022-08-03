package ADVANCED.LAB_3_Sets_And_Maps_Advanced;

import java.util.*;

public class P7_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split(" ");
            String continents = info[0];
            String countries = info[1];
            String cities = info[2];

            map.putIfAbsent(continents, new LinkedHashMap<>());
            map.get(continents).putIfAbsent(countries, new ArrayList<>());
            map.get(continents).get(countries).add(cities);
        }
        for(Map.Entry<String, Map<String, List<String>>> entry : map.entrySet()){
            System.out.printf("%s: \n", entry.getKey());
            for(Map.Entry<String, List<String>> country : entry.getValue().entrySet()){
                System.out.printf("  %s -> ", country.getKey());
                for(String city : country.getValue()){
                    System.out.print(String.join(", ", city));
                }
                System.out.println();
            }
        }
    }
}
