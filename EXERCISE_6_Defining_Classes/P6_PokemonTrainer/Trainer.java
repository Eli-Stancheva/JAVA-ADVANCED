package ADVANCED.EXERCISE_6_Defining_Classes.P6_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemon;

    public Trainer() {
        this.badges = 0;
        this.pokemon = new ArrayList<>();
    }

    public Trainer(String name, int badges, List<Pokemon> pokemon) {
        this.name = name;
        this.badges = badges;
        this.pokemon = pokemon;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges() {
        this.badges++;
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public int pokemonSize() {
        return this.pokemon.size();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemon.add(pokemon);
    }

    private UnaryOperator<Pokemon> damagePokemon = pokemon ->
            new Pokemon(pokemon.getPokemonName(), pokemon.getElement(), pokemon.getHealth() - 10);

    public void missingPokemon() {
        this.pokemon = this.pokemon
                .stream()
                .map(damagePokemon)
                .filter(pokemon -> pokemon.getHealth() > 0)
                .collect(Collectors.toList());
    }
}
