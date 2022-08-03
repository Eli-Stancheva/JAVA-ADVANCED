package ADVANCED.EXAMS.Exam_2_23_October_2021.P3_Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (roster.size() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person p : roster) {
            if (p.getName().equals(name)) {
                roster.remove(p);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        Person person = null;
        for (Person p : roster) {
            if (p.getName().equals(name) && p.getHometown().equals(hometown)) {
               person = p;
            }
        }
        return person;
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The people in the hotel %s are:", name)).append("\n");
        for (Person person : roster) {
            builder.append(person.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
