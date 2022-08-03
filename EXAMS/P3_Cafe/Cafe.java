package ADVANCED.EXAMS.Exam_3_18_August_2021.P3_Cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public int getEmployees() {
        return employees.size();
    }

    public void addEmployee(Employee employee){
        if (capacity > getEmployees()){
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){
        Employee removed = null;

        for (Employee e : employees) {
            if (e.getName().equals(name)){
               removed = e;
            }
        }
        if (removed == null){
            return  false;
        } else {
            employees.remove(removed);
            return true;
        }
    }

    public Employee getOldestEmployee(){
        Employee oldest = null;

        int maxAge = Integer.MIN_VALUE;
        for (Employee e : employees) {
            if (e.getAge() > maxAge){
                maxAge = e.getAge();
                oldest = e;
            }
        }
        return oldest;
    }

    public Employee getEmployee(String name){
        Employee getEmp = null;

        for (Employee e : employees) {
            if (e.getName().equals(name)){
                getEmp = e;
            }
        }
        return getEmp;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Employees working at Cafe %s: \n", name));
        for (Employee e : employees) {
           builder.append(e.toString()).append("\n");
        }
        return builder.toString();
    }
}
