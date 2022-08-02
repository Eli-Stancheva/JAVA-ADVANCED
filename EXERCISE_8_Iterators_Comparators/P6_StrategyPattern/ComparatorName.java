package ADVANCED.EXERCISE_8_Iterators_Comparators.P6_StrategyPattern;

import java.util.Comparator;

public class ComparatorName implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int toReturn = Integer.compare(person1.getName().length(),person2.getName().length());

        if (toReturn==0){
            return Character.compare(person1.getName().toLowerCase().charAt(0),person2.getName().toLowerCase().charAt(0));
        }
        return toReturn;
    }
}
