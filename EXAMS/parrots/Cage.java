package ADVANCED.EXAMS.EXAM_12_19_February_2022.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private List<Parrot> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (capacity > data.size()) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        Parrot removedParrot = null;

        for (Parrot p : data) {
            if (p.getName().equals(name)) {
                removedParrot = p;
            }
        }

        if (removedParrot == null) {
            return false;
        } else {
            data.remove(removedParrot);
            return true;
        }
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = null;
        for (Parrot p : data) {
            if (p.getName().equals(name)) {
                p.setAvailable(false);
                parrot = p;
            }
        }
        data.removeIf(p -> p.getName().equals(name));
        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> sells = new ArrayList<>();
        for (Parrot p : data) {
            if (p.getSpecies().equals(species)) {
                sells.add(p);
            }
        }
        data.removeIf(p -> p.getSpecies().equals(species));
        return sells;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Parrots available at %s:", name)).append(System.lineSeparator());
        for (Parrot datum : data) {
            builder.append(datum.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
