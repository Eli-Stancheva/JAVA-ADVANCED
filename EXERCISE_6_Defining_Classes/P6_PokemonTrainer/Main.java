package ADVANCED.EXERCISE_6_Defining_Classes.P6_PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> map = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("Tournament")) {
            String[] pokemonInfo = command.split(" ");

            String trainerName = pokemonInfo[0];
            String pokemonName = pokemonInfo[1];
            String element = pokemonInfo[2];
            int health = Integer.parseInt(pokemonInfo[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);

            map.putIfAbsent(trainerName, new Trainer());
            map.get(trainerName).addPokemon(pokemon);

            command = scanner.nextLine();
        }

        String command2 = scanner.nextLine();
        while (!command2.equals("End")) {
            String searchedElement = command2;

            for (Map.Entry<String, Trainer> entry : map.entrySet()) {
                if (entry.getValue().pokemonSize() > 0) {
                    boolean havePokemon = false;
                    for (Pokemon pokemon : entry.getValue().getPokemon()) {
                        if (pokemon.getElement().equals(searchedElement)) {
                            havePokemon = true;
                            entry.getValue().setBadges();
                            break;
                        }
                    }
                    if (!havePokemon) {
                        entry.getValue().missingPokemon();
                    }
                }
            }
            command2 = scanner.nextLine();
        }
        map.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue().getBadges(), b1.getValue().getBadges()))
                .forEach(e -> {
                    System.out.printf("%s %s %s\n", e.getKey(), e.getValue().getBadges(), e.getValue().pokemonSize());
                });
    }
}
