package ADVANCED.EXAMS.Exam_1_15_December_2021.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool; //or Set
    private String name;
    private int capacity;
    private int size; //the volume of the pool

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        boolean haveSameFish = false;
        for (Fish f : fishInPool) {
            if (f.getName().equals(fish.getName())) {
                haveSameFish = true;
            }
        }
        if (!haveSameFish && capacity > getFishInPool()) {
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        Fish removedFish = null;

        for (Fish f : fishInPool) {
            if (f.getName().equals(name)) {
               removedFish = f;
            }
        }

        if (removedFish == null){
            return false;
        } else {
            fishInPool.remove(removedFish);
            return true;
        }
    }

    public Fish findFish(String name) {
        for(Fish f : fishInPool){
            if (f.getName().equals(name)){
                return f;
            }
        }
        return null;
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Aquarium: %s ^ Size: %d", getName(), getSize())).append("\n");
        for(Fish f : fishInPool){
            builder.append(f.toString()).append("\n");
        }
        return builder.toString();
    }
}
