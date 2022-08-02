package ADVANCED.EXERCISE_7_Generics.Generic_Box;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Comparable<T>>{
    private List<T> list;

    public Box(){
        this.list = new ArrayList<>();
    }

    public void add(T element){
        this.list.add(element);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (T element : list) {
            builder.append(String.format("%s: %s",element.getClass().getName(), element)).append("\n");
        }
        return builder.toString();
    }

    public void swap(int firstIndex, int secondIndex){
        T fistIndexElement = this.list.get(firstIndex);
        T secondIndexElement = this.list.get(secondIndex);

        this.list.set(firstIndex, secondIndexElement);
        this.list.set(secondIndex, fistIndexElement);
    }

    public int countElementsGreaterThan (T element){
        int count = 0;
        for (T t : list) {
            if (t.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }
}
