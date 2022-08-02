package ADVANCED.EXERCISE_6_Defining_Classes.P2_CompanyRoster;

public class Employee {
    //задължителни полета
    private String name;
    private double salary;
    private String position;
    private String department;
    //незадължителни полета
    private String email;
    private int age;

    //има 6 полета
    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    //има 4 полета
    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    //има 5 полета
    //полетата са всички без имейл
    public Employee(String name, double salary, String position, String department, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = age;
        this.email = "n/a";
    }

    //има 5 полета
    //полетата са всички без години
    public Employee(String name, double salary, String position, String department, String email) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = -1;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" ").append(String.format("%.2f", salary)).append(" ").append(email).append(" ").append(age);
        return builder.toString();
    }
}
