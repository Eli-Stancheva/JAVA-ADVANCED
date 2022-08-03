package ADVANCED.EXAMS.EXAM_11_17_December_2019.P3_Christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Present> data;
    private String color;
    private int capacity;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (capacity > data.size()) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        Present removedPresent = null;
        for (Present p : data) {
            if (p.getName().equals(name)) {
                removedPresent = p;
            }
        }
        if (removedPresent == null) {
            return false;
        } else {
            data.remove(removedPresent);
            return true;
        }
    }

    public Present heaviestPresent() {
        Present heaviestPresent = null;
        double heavier = Double.MIN_VALUE;
        for (Present p : data) {
            if (p.getWeight() > heavier) {
                heavier = p.getWeight();
                heaviestPresent = p;
            }
        }
        return heaviestPresent;
    }

    public Present getPresent(String name) {
        Present present = null;
        for (Present p : data) {
            if (p.getName().equals(name)) {
                present = p;
            }
        }
        return present;
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s bag contains:", color)).append(System.lineSeparator());
        for (Present p : data) {
            builder.append(p.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
