package ADVANCED.EXERCISE_8_Iterators_Comparators.P6_StrategyPattern;

import java.util.Comparator;

public class ComparatorAge implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2){
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}
