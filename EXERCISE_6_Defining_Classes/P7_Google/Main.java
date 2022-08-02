package ADVANCED.EXERCISE_6_Defining_Classes.P7_Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split(" ");
            String name = data[0];

            if (!people.containsKey(name)){
                people.put(name, new Person());
            }

            String parameters = data[1];
            switch (parameters){
                case"company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName, department, salary);
                    people.get(name).setCompany(company);
                    break;
                case"pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    people.get(name).getPokemon().add(pokemon);
                    break;
                case"parents":
                    String parentsName = data[2];
                    String parentsBirth = data[3];
                    Parents parent = new Parents(parentsName, parentsBirth);
                    people.get(name).getParents().add(parent);
                    break;
                case"children":
                    String childName = data[2];
                    String childBirth = data[3];
                    Children children = new Children(childName, childBirth);
                    people.get(name).getChildren().add(children);
                    break;
                case"car":
                    String carModel = data[2];
                    int carSpeed = Integer.parseInt(data[3]);
                    Car car = new Car(carModel, carSpeed);
                    people.get(name).setCar(car);
                    break;
            }
            input = scanner.nextLine();
        }

        String searchedPerson = scanner.nextLine();
        System.out.println(searchedPerson);
        Person personalData = people.get(searchedPerson);
        System.out.println(personalData);
    }
}
