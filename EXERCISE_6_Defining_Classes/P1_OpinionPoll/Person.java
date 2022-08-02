package ADVANCED.EXERCISE_6_Defining_Classes.P1_OpinionPoll;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name + " - " + age;
    }
}
