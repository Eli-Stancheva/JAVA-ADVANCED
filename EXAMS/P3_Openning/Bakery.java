package ADVANCED.EXAMS.Exam_7_16_December_2020.P3_Openning;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if (capacity > employees.size()){
            employees.add(employee);
        }
    }

    public boolean remove(String name){
        Employee toRemove = null;
        for (Employee e : employees) {
            if(e.getName().equals(name)){
                toRemove = e;
            }
        }

        if (toRemove == null){
            return false;
        } else {
            employees.remove(toRemove);
            return true;
        }
    }

    public Employee getOldestEmployee(){
        Employee oldestEmployee = null;
        int oldest = Integer.MIN_VALUE;
        for (Employee e : employees) {
            if (e.getAge() > oldest){
                oldest = e.getAge();
                oldestEmployee = e;
            }
        }
        return oldestEmployee;
    }

    public Employee getEmployee(String name){
        Employee givenName = null;
        for (Employee e : employees) {
            if (e.getName().equals(name)){
                givenName = e;
            }
        }
        return givenName;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Employees working at Bakery %s:\n", name));
        for (Employee e : employees) {
            builder.append(e).append("\n");
        }
       return builder.toString();
    }
}
