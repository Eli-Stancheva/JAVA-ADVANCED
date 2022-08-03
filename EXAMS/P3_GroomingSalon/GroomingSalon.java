package ADVANCED.EXAMS.Exam_4_26_June_2021.P3_GroomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (capacity > data.size()) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        Pet removedPet = null;

        for (Pet p : data) {
            if (p.getName().equals(name)) {
                removedPet = p;
            }
        }

        if (removedPet == null) {
            return false;
        } else {
            data.remove(removedPet);
            return true;
        }
    }

    public Pet getPet(String name, String owner) {
        Pet get = null;

        for (Pet p : data) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)) {
                get = p;
            }
        }

        return get;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("The grooming salon has the following clients:\n");
        for (Pet p : data) {
            builder.append(String.format("%s %s\n", p.getName(), p.getOwner()));
        }
        return builder.toString();
    }
}
