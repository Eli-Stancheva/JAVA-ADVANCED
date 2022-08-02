package ADVANCED.EXERCISE_3_Sets_And_Maps_Advanced;

import java.util.*;

public class P8_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> map = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String[] infoPlayers = input.split(": ");
            String name = infoPlayers[0];
            String[] cards = infoPlayers[1].split(", ");

            Set<String> setCards = new HashSet<>();
            setCards.addAll(Arrays.asList(cards));

            if (!map.containsKey(name)) {
                map.put(name, setCards);
            } else {
                Set<String> currCards = map.get(name);
                currCards.addAll(setCards);
                map.put(name, currCards);
            }

            input = scanner.nextLine();
        }
        map.entrySet().forEach(entry -> {
            int points = cardsPoints(entry.getValue());
            System.out.printf("%s: %d\n", entry.getKey(), points);
        });
    }

    private static int cardsPoints(Set<String> cards) {
        Map<Character, Integer> symbolsValue = getSymbolsValues();
        int sumPoints = 0;

        for (String card : cards) {
            int points = 0;
            if(card.startsWith("10")){
                char type = card.charAt(2);
                points = 10 * symbolsValue.get(type);
            } else {
                char power = card.charAt(0);
                char type = card.charAt(1);
                points = symbolsValue.get(power) * symbolsValue.get(type);
            }
            sumPoints += points;
        }
        return sumPoints;
    }

    private static Map<Character, Integer> getSymbolsValues() {
        Map<Character, Integer> values = new HashMap<>();
        values.put('2', 2);
        values.put('3', 3);
        values.put('4', 4);
        values.put('5', 5);
        values.put('6', 6);
        values.put('7', 7);
        values.put('8', 8);
        values.put('9', 9);
        values.put('J', 11);
        values.put('Q', 12);
        values.put('K', 13);
        values.put('A', 14);
        values.put('S', 4);
        values.put('H', 3);
        values.put('D', 2);
        values.put('C', 1);

        return values;
    }
}
